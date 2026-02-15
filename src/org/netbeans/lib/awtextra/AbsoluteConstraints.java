package org.netbeans.lib.awtextra;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

public class AbsoluteConstraints implements Serializable {
    private static final long serialVersionUID = 1L;

    private int x;
    private int y;
    private int width = -1;
    private int height = -1;

    public AbsoluteConstraints(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public AbsoluteConstraints(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Point getLocation() {
        return new Point(x, y);
    }

    public Dimension getSize() {
        return new Dimension(width, height);
    }
}
