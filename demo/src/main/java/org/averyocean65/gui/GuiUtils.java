package org.averyocean65.gui;

import javax.swing.*;

public final class GuiUtils {
    public static void createFunctionButton(JComponent root, String name, Runnable function) {
        JButton button = new JButton(name);
        button.addActionListener(e -> {
            function.run();
        });

        root.add(button);
    }
}
