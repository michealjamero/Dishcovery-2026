package dishcovery;

import javax.swing.*;
import java.awt.*;

public class StarItem extends JButton {
    public StarItem() {
        setContentAreaFilled(false);
        setBorder(null);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setText("\u2605"); // Use Unicode escape for star character to avoid encoding issues
        setFont(new Font("sansserif", Font.PLAIN, 25));
        setForeground(Color.LIGHT_GRAY);
    }

    public void setSelected(boolean selected) {
        if (selected) {
            setForeground(new Color(255, 204, 0)); // Gold color
        } else {
            setForeground(Color.LIGHT_GRAY);
        }
    }
}
