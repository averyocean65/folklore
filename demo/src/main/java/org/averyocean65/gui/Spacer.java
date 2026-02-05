package org.averyocean65.gui;

import javax.swing.*;
import java.awt.*;

public class Spacer extends JLabel {
    public Spacer(float size) {
        super(" ");
        setFont(getFont().deriveFont(size));
    }
}
