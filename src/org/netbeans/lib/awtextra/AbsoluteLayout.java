package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.IdentityHashMap;
import java.util.Map;

public class AbsoluteLayout implements LayoutManager2, java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<Component, AbsoluteConstraints> constraints = new IdentityHashMap<>();

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // Not used
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraint) {
        if (constraint instanceof AbsoluteConstraints) {
            constraints.put(comp, (AbsoluteConstraints) constraint);
        } else if (constraint == null) {
            constraints.put(comp, new AbsoluteConstraints(0, 0));
        } else {
            throw new IllegalArgumentException("Constraint must be AbsoluteConstraints");
        }
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        constraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return computeLayoutSize(parent, true);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return computeLayoutSize(parent, false);
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return preferredLayoutSize(target);
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        for (Component comp : parent.getComponents()) {
            AbsoluteConstraints ac = constraints.get(comp);
            if (ac == null) continue;
            int x = insets.left + ac.getX();
            int y = insets.top + ac.getY();
            int w = ac.getWidth();
            int h = ac.getHeight();
            if (w < 0 || h < 0) {
                Dimension pref = comp.getPreferredSize();
                if (w < 0) w = pref.width;
                if (h < 0) h = pref.height;
            }
            comp.setBounds(x, y, w, h);
        }
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
        // no-op
    }

    private Dimension computeLayoutSize(Container parent, boolean preferred) {
        Insets insets = parent.getInsets();
        int maxX = 0, maxY = 0;
        for (Component comp : parent.getComponents()) {
            AbsoluteConstraints ac = constraints.get(comp);
            if (ac == null) continue;
            int w = ac.getWidth();
            int h = ac.getHeight();
            if (w < 0 || h < 0) {
                Dimension d = preferred ? comp.getPreferredSize() : comp.getMinimumSize();
                if (w < 0) w = d.width;
                if (h < 0) h = d.height;
            }
            maxX = Math.max(maxX, ac.getX() + w);
            maxY = Math.max(maxY, ac.getY() + h);
        }
        return new Dimension(insets.left + insets.right + maxX, insets.top + insets.bottom + maxY);
    }
}
