package dishcovery;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.SwingUtilities;

public class FrostedRoundedPanel extends RoundedPanel {
    private final ConvolveOp blurOp;

    public FrostedRoundedPanel(int cornerRadius) {
        super(cornerRadius);
        float v = 1f / 9f;
        float[] m = new float[]{v, v, v, v, v, v, v, v, v};
        blurOp = new ConvolveOp(new Kernel(3, 3, m), ConvolveOp.EDGE_NO_OP, null);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        java.awt.Window win = SwingUtilities.getWindowAncestor(this);
        if (win != null && getWidth() > 0 && getHeight() > 0) {
            BufferedImage snap = new BufferedImage(win.getWidth(), win.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D sg = snap.createGraphics();
            sg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            win.paint(sg);
            sg.dispose();
            Point p = SwingUtilities.convertPoint(this, 0, 0, win);
            int x = Math.max(0, p.x);
            int y = Math.max(0, p.y);
            int w = Math.min(getWidth(), snap.getWidth() - x);
            int h = Math.min(getHeight(), snap.getHeight() - y);
            if (w > 0 && h > 0) {
                BufferedImage region = snap.getSubimage(x, y, w, h);
                BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                blurOp.filter(region, out);
                g2.drawImage(out, 0, 0, null);
            }
        }
        Color bg = getBackground();
        if (bg != null) {
            g2.setComposite(AlphaComposite.SrcOver.derive(bg.getAlpha() / 255f));
            g2.setColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue()));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
        }
        g2.dispose();
        super.paintComponent(g);
    }
}
