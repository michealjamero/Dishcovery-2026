package dishcovery;

import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * Minimal helper to set an inset/border on the viewport view of a JScrollPane.
 * This acts as a lightweight replacement for the FormScroller used in examples.
 */
public class FormScroller {
    private final JScrollPane scrollPane;

    public FormScroller(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setScrollInsets(Insets insets) {
        if (scrollPane == null) return;
        if (scrollPane.getViewport() == null) return;
        java.awt.Component view = scrollPane.getViewport().getView();
        if (view instanceof JComponent) {
            ((JComponent) view).setBorder(new EmptyBorder(insets.top, insets.left, insets.bottom, insets.right));
            // force repaint
            view.revalidate();
            view.repaint();
        }
    }
}
