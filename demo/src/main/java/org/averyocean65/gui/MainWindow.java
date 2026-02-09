package org.averyocean65.gui;

import org.averyocean65.gui.components.JSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends WindowWrapper {
    public MainWindow() {
        super("Folklore Demo Project", 400, 300);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout layout = new BoxLayout(rootFrame.getContentPane(), BoxLayout.Y_AXIS);
        rootFrame.setLayout(layout);
    }

    private void addElement(JComponent element) {
        element.setAlignmentX(Component.CENTER_ALIGNMENT);
        rootFrame.add(element);
    }

    @Override
    protected void spawnWindowElements() {
        // TITLE
        JLabel titleLabel = new JLabel("Folklore Demo");

        Font headerFont = titleLabel.getFont().deriveFont(Font.BOLD);
        Font subheaderFont = titleLabel.getFont().deriveFont(Font.ITALIC);

        titleLabel.setFont(headerFont);
        addElement(titleLabel);

        JLabel subtitleLabel = new JLabel("Select a feature to test below");
        subtitleLabel.setFont(subheaderFont);
        addElement(subtitleLabel);

        // SPACE
        JSpacer spacer = new JSpacer(15);
        addElement(spacer);

        // DEMO BUTTONS
        JButton fractionDemoButton = new JButton("Fraction Demo");
        fractionDemoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FractionWindow fractionWindow = new FractionWindow();
                fractionWindow.show();
            }
        });

        JButton vectorDemoButton = new JButton("Vector Demo");
        vectorDemoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VectorWindow vectorWindow = new VectorWindow();
                vectorWindow.show();
            }
        });

        addElement(fractionDemoButton);
        addElement(vectorDemoButton);
    }
}
