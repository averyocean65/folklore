package org.averyocean65.gui.components;

import org.averyocean65.folklore.vectors.Vector3;
import org.averyocean65.utils.Result;

import javax.swing.*;
import java.awt.*;

public class JVector3 extends JComponent {
    private Vector3 vector;

    private final JTextField xField;
    private final JTextField yField;
    private final JTextField zField;

    public JVector3() {
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

        add(spacer);

        zField = new JTextField("");
        zField.setPreferredSize(fieldDimension);
        add(zField);
    }

    public Result<Vector3> getVector() {
        try {
            double x = Double.parseDouble(xField.getText());
            double y = Double.parseDouble(yField.getText());
            double z = Double.parseDouble(zField.getText());

            return new Result<>(true, new Vector3(x, y, z));
        } catch (Exception e) {
            return new Result<>(false, null);
        }
    }

    public void setVector(Vector3 f) {
        vector = f;
        xField.setText(String.valueOf(f.getX()));
        yField.setText(String.valueOf(f.getY()));
        zField.setText(String.valueOf(f.getZ()));
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        xField.setEnabled(enabled);
        yField.setEnabled(enabled);
    }
}
