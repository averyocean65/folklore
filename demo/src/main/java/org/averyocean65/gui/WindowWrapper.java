package org.averyocean65.gui;

import javax.swing.*;

public abstract class WindowWrapper {
    protected JFrame rootFrame;

    public WindowWrapper(String title, int width, int height) {
        rootFrame = new JFrame(title);
        rootFrame.setSize(width, height);

        spawnWindowElements();
    }

    protected abstract void spawnWindowElements();

    public void show() {
        rootFrame.setVisible(true);
    }

    public void hide() {
        rootFrame.setVisible(false);
    }
}