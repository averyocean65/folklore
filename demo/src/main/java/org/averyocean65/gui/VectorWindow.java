package org.averyocean65.gui;

import org.averyocean65.folklore.vectors.Vector2;
import org.averyocean65.gui.components.JVector2;
import org.averyocean65.utils.Result;

import javax.swing.*;

import static org.averyocean65.gui.GuiUtils.*;

public class VectorWindow extends WindowWrapper {
    private JTabbedPane tabs;

    private JVector2 vector2A;
    private JVector2 vector2B;

    public VectorWindow() {
        super("Vector Demo", 450, 400);
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

        JLabel vector2ALabel = new JLabel("A:");
        JLabel vector2BLabel = new JLabel("B:");
        vector2A = new JVector2();
        vector2B = new JVector2();

        backdrop.add(vector2ALabel);
        backdrop.add(vector2A);
        backdrop.add(vector2BLabel);
        backdrop.add(vector2B);

        JLabel singleOperationsHeader = new JLabel("Single Operations (performed on both)");
        backdrop.add(singleOperationsHeader);

        createFunctionButton(backdrop, "Get Magnitude", () -> {
            Result<Vector2> resultA = vector2A.getVector();
            Result<Vector2> resultB = vector2B.getVector();

            if(!resultA.success || !resultB.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse vectors.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double valueA = resultA.value.getMagnitude();
            double valueB = resultB.value.getMagnitude();

            String message = "A: %f, B: %f".formatted(valueA, valueB);

            JOptionPane.showMessageDialog(rootFrame, message, "Magnitude", JOptionPane.INFORMATION_MESSAGE);
        });
        createFunctionButton(backdrop, "Normalize", () -> {
            Result<Vector2> resultA = vector2A.getVector();
            Result<Vector2> resultB = vector2B.getVector();

            if(!resultA.success || !resultB.success) {
                JOptionPane.showMessageDialog(rootFrame, "Failed to parse vectors.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            vector2A.setVector(resultA.value.getNormalized());
            vector2B.setVector(resultB.value.getNormalized());
        });


        tabs.add("Vector 2", backdrop);
    }

    protected void makeVector3Tab() {
        JPanel backdrop = new JPanel();

        tabs.add("Vector 3", backdrop);
    }
}
