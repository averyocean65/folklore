package org.averyocean65.gui;

import javax.swing.*;

public class VectorWindow extends WindowWrapper {
    private JTabbedPane tabs;

    public VectorWindow() {
        super("Vector Demo", 300, 300);
    }

    @Override
    protected void spawnWindowElements() {
        tabs = new JTabbedPane();
        makeVector2Tab();
        makeVector3Tab();

        rootFrame.add(tabs);
    }

    protected void makeVector2Tab() {
        JPanel backdrop = new JPanel();

        tabs.add("Vector 2", backdrop);
    }

    protected void makeVector3Tab() {
        JPanel backdrop = new JPanel();

        tabs.add("Vector 3", backdrop);
    }
}
