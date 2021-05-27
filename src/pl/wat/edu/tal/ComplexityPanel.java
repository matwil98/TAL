package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComplexityPanel extends JPanel {

    private ArrayList<Integer> arrayList;
    private ArrayList<Integer> values;
    private ArrayList<Integer> weights;

    public ComplexityPanel(ArrayList<Integer> arrayList, ArrayList<Integer> values, ArrayList<Integer> weights) {
        JPanel jPanel = new JPanel();
        JButton jButton;
        this.arrayList = arrayList;
        this.values = values;
        this.weights = weights;
        for (Integer i : arrayList) {
            jButton = new JButton();
            jButton.setBackground(new Color(40,255,80));
            jButton.setText( "El nr: " + String.valueOf(i));
            int index = i;
            int tooltip = values.get(index - 1);
            jButton.setToolTipText("Value: " + tooltip  + "\n" + ", Weight: " + String.valueOf(weights.get(i-1)));
            jPanel.add(jButton);
        }

        add(jPanel);
    }

}

