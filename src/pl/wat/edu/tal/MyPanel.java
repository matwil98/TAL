package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MyPanel extends JPanel implements ActionListener {

    private Knapsack knapsack;
    private JLabel numOfObjects;
    private JTextField numOfObjectsTextField;
    private JLabel scopeOfWeights;
    private JTextField scopeOfWeightsTextField;
    private JLabel knapsackCapacity;
    private JTextField knapsackCapacityField;
    private JTextField resultTextfield;
    private JLabel timeFieldLabel;
    private JTextField timeField;
    private JLabel optimumResult;

    private JLabel values;
    private JTextField valuesTextField;
    private JButton jButton;
    private JButton resultButton;
    private JTextArea areaOfWeights;
    private JTextArea areaOfValues;

    private ArrayList<Integer> arrayList;
    private ArrayList<Integer> arrayList1;

    public MyPanel() {
        JPanel jPanel = new JPanel();
     setBackground(new Color(200,200,200,200));
        jPanel.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
        jPanel.setLayout(new GridLayout(4,2, 10, 5));
        jPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        knapsackCapacity = new JLabel("Capacity");
        jPanel.add(knapsackCapacity);
        knapsackCapacityField = new JTextField(6);
        jPanel.add(knapsackCapacityField);
        numOfObjects = new JLabel("Enter numOfObjects");
        jPanel.add(numOfObjects);
        numOfObjectsTextField = new JTextField(6);
        jPanel.add(numOfObjectsTextField);
        scopeOfWeights = new JLabel("Enter scope of weights");
        jPanel.add(scopeOfWeights);
        scopeOfWeightsTextField = new JTextField(6);
        jPanel.add(scopeOfWeightsTextField);
        values = new JLabel("Enter scope of values");
        jPanel.add(values);
        valuesTextField = new JTextField(6);
        jPanel.add(valuesTextField);
        areaOfWeights = new JTextArea("Wagi przedmiotów", 2, 10);
        areaOfValues = new JTextArea("Wartości przedmiotów", 2, 10);
        jButton = new JButton("Draw");
        jButton.addActionListener(this);
        jPanel.add(jButton);
        resultButton = new JButton("DP alghoritm");
        resultButton.addActionListener(this);
        jPanel.add(resultButton);
        jPanel.add(areaOfWeights);
        jPanel.add(areaOfValues);
        optimumResult = new JLabel("Optimum result");
        jPanel.add(optimumResult);
        resultTextfield = new JTextField(6);
        jPanel.add(resultTextfield);
        timeFieldLabel = new JLabel("Time of running alghoritm");
        jPanel.add(timeFieldLabel);
        timeField = new JTextField(10);
        jPanel.add(timeField);
        add(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        knapsack = new Knapsack();
        Object source = e.getSource();

        if (source == jButton) {
            int number = Integer.parseInt(numOfObjectsTextField.getText());
            int scopeOfWeights = Integer.parseInt(scopeOfWeightsTextField.getText());
            int scopeOfValues = Integer.parseInt(valuesTextField.getText());
            String[] stringList;
            String[] stringList2;
            StringBuilder napis = new StringBuilder();
            StringBuilder napis2 = new StringBuilder();
            arrayList = knapsack.convertToArrayList(number, scopeOfWeights);
            arrayList1 = knapsack.convertToArrayList(number, scopeOfValues);
            for (int i = 0; i < number; i++) {
                stringList = new String[number];
                stringList2 = new String[number];
                stringList[i] = arrayList.get(i).toString();
                stringList2[i] = arrayList1.get(i).toString();
                napis.append(Arrays.toString(stringList[i].split(",")));
                napis2.append(Arrays.toString(stringList2[i].split(",")));
            }
            areaOfWeights.setText(napis.toString());
            areaOfValues.setText(napis2.toString());
        } else if (source == resultButton) {
            Scanner sc = new Scanner(System.in);
            int numOfObjects = Integer.parseInt(numOfObjectsTextField.getText());
            int knapsackCapacity = Integer.parseInt(knapsackCapacityField.getText());
            double startTimeAlghoritm = System.currentTimeMillis();
            int optimum = knapsack.solveKnapsackProblemTest(arrayList, arrayList1, knapsackCapacity, numOfObjects);
            double endTimeAlghoritm = System.currentTimeMillis();
            double diference = endTimeAlghoritm - startTimeAlghoritm;
            resultTextfield.setText(String.valueOf(optimum));
            timeField.setText(diference + " ms");
        }
    }
    public JButton createButton(String text, int x, int y, int width, String actionCommand) {
        JButton jButton1 = new JButton(text);
        jButton1.setBackground(new Color(140, 210, 38));
        jButton1.setBounds(x, y, width, 20);
        jButton1.setBorder(null);
        jButton1.setForeground(new Color(56, 89, 152));
        jButton1.setActionCommand(actionCommand);
        jButton1.addActionListener(this);
        return jButton1;
    }
}
