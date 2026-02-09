package org.averyocean65.gui.components;

import javax.swing.*;

public class JSpacer extends JLabel {
    public JSpacer(float size) {
        super(" ");
        setFont(getFont().deriveFont(size));
    }
}
