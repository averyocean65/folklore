package org.averyocean65.gui;

import org.averyocean65.folklore.Fraction;
import org.averyocean65.utils.Result;

import javax.swing.*;
import java.awt.*;

public class JFraction extends JComponent {
    private Fraction fraction;

    private final JTextField numeratorField;
    private final JTextField denominatorField;

    public JFraction() {
        super();

        setLayout(new FlowLayout());
        Dimension fieldDimension = new Dimension(50, 30);

        numeratorField = new JTextField("");
        numeratorField.setPreferredSize(fieldDimension);
        add(numeratorField);

        Label separator = new Label(":");
        add(separator);

        denominatorField = new JTextField("");
        denominatorField.setPreferredSize(fieldDimension);
        add(denominatorField);
    }

    public Result<Fraction> getFraction() {
        try {
            int numerator = Integer.parseInt(numeratorField.getText());
            int denominator = Integer.parseInt(denominatorField.getText());

            return new Result<>(true, new Fraction(numerator, denominator));
        } catch (Exception e) {
            return new Result<>(false, null);
        }
    }

    public void setFraction(Fraction f) {
        fraction = f;
        numeratorField.setText(String.valueOf(f.getNumerator()));
        denominatorField.setText(String.valueOf(f.getDenominator()));
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        numeratorField.setEnabled(enabled);
        denominatorField.setEnabled(enabled);
    }
}
