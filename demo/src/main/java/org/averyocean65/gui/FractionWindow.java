package org.averyocean65.gui;

import org.averyocean65.folklore.Fraction;
import org.averyocean65.utils.Result;

import javax.swing.*;
import java.awt.*;

public class FractionWindow extends WindowWrapper {
    private JTabbedPane panes;

    private JTextField singularScalar;
    private JFraction singularFraction;

    private JFraction multiFractionA;
    private JFraction multiFractionB;
    private JFraction resultFraction;

    public FractionWindow() {
        super("Fraction Demo Window", 200, 500);
    }

    @Override
    protected void spawnWindowElements() {
        panes = new JTabbedPane();
        createSingularFractionPane();
        createMultiFractionPane();

        rootFrame.add(panes);
    }

    private void createFunctionButton(JComponent root, String name, Runnable function) {
        JButton button = new JButton(name);
        button.addActionListener(e -> {
            function.run();
        });

        root.add(button);
    }

    private void createSingularFractionPane() {
        JPanel backPanel = new JPanel();

        singularFraction = new JFraction();

        JLabel scalarLabel = new JLabel("Scalar:");
        singularScalar = new JTextField("1");
        singularScalar.setPreferredSize(new Dimension(50, 30));

        backPanel.add(singularFraction);

        backPanel.add(scalarLabel);
        backPanel.add(singularScalar);

        createFunctionButton(backPanel, "Inverse", () -> {
            Result<Fraction> result = singularFraction.getFraction();
            if(!result.success) {
                JOptionPane.showMessageDialog(rootFrame, "Couldn't parse fraction!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction f = result.value;
            f = f.inverse();
            singularFraction.setFraction(f);
        });

        createFunctionButton(backPanel, "To Decimal", () -> {
            Result<Fraction> result = singularFraction.getFraction();
            if(!result.success) {
                JOptionPane.showMessageDialog(rootFrame, "Couldn't parse fraction!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction f = result.value;
            double decimal = f.toDecimal();
            JOptionPane.showMessageDialog(rootFrame, String.valueOf(decimal), "To Decimal", JOptionPane.INFORMATION_MESSAGE);
        });

        createFunctionButton(backPanel, "Simplify", () -> {
            Result<Fraction> result = singularFraction.getFraction();
            if(!result.success) {
                JOptionPane.showMessageDialog(rootFrame, "Couldn't parse fraction!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction f = result.value;
            singularFraction.setFraction(f.simplify());
        });

        createFunctionButton(backPanel, "Scale", () -> {
            Result<Fraction> result = singularFraction.getFraction();
            if(!result.success) {
                JOptionPane.showMessageDialog(rootFrame, "Couldn't parse fraction!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Result<Integer> parsed = Result.safeParseInt(singularScalar.getText());
            if(!parsed.success) {
                JOptionPane.showMessageDialog(rootFrame, "Couldn't parse scalar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction f = result.value;
            singularFraction.setFraction(f.scaleFraction(parsed.value));
        });

        panes.add("Single Fraction", backPanel);
    }

    private void createMultiFractionPane() {
        JPanel backPanel = new JPanel();

        JLabel multiFractionALabel = new JLabel("Fraction A:");
        JLabel multiFractionBLabel = new JLabel("Fraction B:");
        JLabel resultFractionLabel = new JLabel("Result:");
        multiFractionA = new JFraction();
        multiFractionB = new JFraction();

        resultFraction = new JFraction();
        resultFraction.setEnabled(false);

        backPanel.add(multiFractionALabel);
        backPanel.add(multiFractionA);
        backPanel.add(multiFractionBLabel);
        backPanel.add(multiFractionB);
        backPanel.add(resultFractionLabel);
        backPanel.add(resultFraction);

        createFunctionButton(backPanel, "Add", () -> {
            Result<Fraction> leftResult = multiFractionA.getFraction();
            Result<Fraction> rightResult = multiFractionB.getFraction();

            if(!leftResult.success || !rightResult.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse both fractions!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction added = leftResult.value.add(rightResult.value);
            resultFraction.setFraction(added);
        });

        createFunctionButton(backPanel, "Subtract", () -> {
            Result<Fraction> leftResult = multiFractionA.getFraction();
            Result<Fraction> rightResult = multiFractionB.getFraction();

            if(!leftResult.success || !rightResult.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse both fractions!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction added = leftResult.value.subtract(rightResult.value);
            resultFraction.setFraction(added);
        });

        createFunctionButton(backPanel, "Multiply", () -> {
            Result<Fraction> leftResult = multiFractionA.getFraction();
            Result<Fraction> rightResult = multiFractionB.getFraction();

            if(!leftResult.success || !rightResult.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse both fractions!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction added = leftResult.value.multiply(rightResult.value);
            resultFraction.setFraction(added);
        });

        createFunctionButton(backPanel, "Divide", () -> {
            Result<Fraction> leftResult = multiFractionA.getFraction();
            Result<Fraction> rightResult = multiFractionB.getFraction();

            if(!leftResult.success || !rightResult.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse both fractions!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Fraction added = leftResult.value.divide(rightResult.value);
            resultFraction.setFraction(added);
        });

        createFunctionButton(backPanel, "Are Equal?", () -> {
            Result<Fraction> leftResult = multiFractionA.getFraction();
            Result<Fraction> rightResult = multiFractionB.getFraction();

            if(!leftResult.success || !rightResult.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse both fractions!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean areEqual = leftResult.value.equals(rightResult.value);
            JOptionPane.showMessageDialog(rootFrame, String.valueOf(areEqual), "Are Equal?", JOptionPane.INFORMATION_MESSAGE);
        });

        panes.add("Multi Fraction", backPanel);
    }
}
