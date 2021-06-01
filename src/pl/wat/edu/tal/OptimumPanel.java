package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OptimumPanel extends JPanel {

    ArrayList<Integer> arrayList;
    ArrayList<Integer> values;
    ArrayList<Integer> weights;

    public OptimumPanel( ArrayList<Integer> arrayList,  ArrayList<Integer> values,  ArrayList<Integer> weights) {
        var jPanel = new JPanel();
        JButton jButton;
        this.arrayList = arrayList;
        this.values = values;
        this.weights = weights;
        for (Integer i : arrayList) {
            jButton = new JButton();
            jButton.setBackground(new Color(40, 255, 80));
            jButton.setText("El nr: " + i);
            int index = i;
            int tooltip = values.get(index - 1);
            jButton.setToolTipText("Value: " + tooltip + "\n" + ", Weight: " + weights.get(i - 1));
            jPanel.add(jButton);
        }

        add(jPanel);
    }

}

