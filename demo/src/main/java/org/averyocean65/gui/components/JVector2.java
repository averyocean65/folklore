package org.averyocean65.gui.components;

import org.averyocean65.folklore.Fraction;
import org.averyocean65.folklore.vectors.Vector2;
import org.averyocean65.utils.Result;

import javax.swing.*;
import java.awt.*;

public class JVector2 extends JComponent {
    private Vector2 vector;

    private final JTextField xField;
    private final JTextField yField;

    public JVector2() {
        super();

        JSpacer spacer = new JSpacer(16);

        setLayout(new FlowLayout());
        Dimension fieldDimension = new Dimension(50, 30);

        xField = new JTextField("");
        xField.setPreferredSize(fieldDimension);
        add(xField);

        add(spacer);

        yField = new JTextField("");
        yField.setPreferredSize(fieldDimension);
        add(yField);
    }

    public Result<Vector2> getVector() {
        try {
            double x = Double.parseDouble(xField.getText());
            double y = Double.parseDouble(yField.getText());

            return new Result<>(true, new Vector2(x, y));
        } catch (Exception e) {
            return new Result<>(false, null);
        }
    }

    public void setVector(Vector2 f) {
        vector = f;
        xField.setText(String.valueOf(f.getX()));
        yField.setText(String.valueOf(f.getY()));
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        xField.setEnabled(enabled);
        yField.setEnabled(enabled);
    }
}
