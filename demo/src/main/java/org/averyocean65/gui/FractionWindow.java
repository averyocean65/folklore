package org.averyocean65.gui;

import javax.swing.*;

public class FractionWindow extends WindowWrapper {
    public FractionWindow() {
        super("Fraction Demo Window", 300, 500);
    }

    @Override
    protected void spawnWindowElements() {
        JLabel todo = new JLabel("Hey, there! This window is currently empty. Check back later!");
        rootFrame.add(todo);
    }
}
