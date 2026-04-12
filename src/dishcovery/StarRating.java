package dishcovery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StarRating extends JPanel {
    private int star = 0; // Current rating
    private EventStarRating event;

    public StarRating() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        setOpaque(false);
        setBackground(Color.WHITE);
        init();
    }

    private void init() {
        for (int i = 1; i <= 5; i++) {
            StarItem item = new StarItem();
            int index = i;
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setStar(index);
                    if (event != null) {
                        event.selected(index);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    highlightStars(index);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    highlightStars(star);
                }
            });
            add(item);
        }
    }

    public void setStar(int star) {
        this.star = star;
        highlightStars(star);
    }

    public int getStar() {
        return star;
    }

    private void highlightStars(int count) {
        Component[] coms = getComponents();
        for (int i = 0; i < coms.length; i++) {
            if (coms[i] instanceof StarItem) {
                StarItem item = (StarItem) coms[i];
                item.setSelected(i < count);
            }
        }
    }

    public void addEventStarRating(EventStarRating event) {
        this.event = event;
    }
}
