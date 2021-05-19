package pl.wat.edu.tal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        setLayout(new GridLayout(2, 3));
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
        jPanel.add(areaOfWeights);
        jPanel.add(areaOfValues);

        resultButton = new JButton("DP alghoritm");
        resultButton.addActionListener(this);
        jPanel.add(resultButton);
        resultTextfield = new JTextField(6);
        jPanel.add(resultTextfield);

        timeFieldLabel = new JLabel("Running time of the algorithm");
        jPanel.add(timeFieldLabel);
        timeField = new JTextField(10);
        jPanel.add(timeField);

        add(jPanel);
    }

    public int parseStringToInteger(JTextField jTextField) {
        int number = Integer.parseInt(jTextField.getText());
        return number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        knapsack = new Knapsack();

        Object source = e.getSource();

        if (source == jButton) {
            int number = parseStringToInteger(numOfObjectsTextField);
            int scopeOfWeights = parseStringToInteger(scopeOfWeightsTextField);
            int scopeOfValues = parseStringToInteger(valuesTextField);
            System.out.println(number + "  " + scopeOfWeights + " " + scopeOfValues);
            String[] stringList;
            String[] stringList2;
            String napis = "";
            String napis2 = "";
            arrayList = knapsack.convertToArrayList(number, scopeOfWeights);
            arrayList1 = knapsack.convertToArrayList(number, scopeOfValues);
            for (int i = 0; i < number; i++) {
                stringList = new String[number];
                stringList2 = new String[number];
                stringList[i] = arrayList.get(i).toString();
                stringList2[i] = arrayList1.get(i).toString();
                napis += stringList[i] + ",";
                napis2 += stringList2[i] + ",";
            }
            areaOfWeights.setText(napis);
            areaOfValues.setText(napis2);
        } else if (source == resultButton) {
            System.out.println("Test drugiego buttona");
            System.out.println("Podaj liczbę elementów");
            Scanner sc = new Scanner(System.in);
            int liczba = sc.nextInt();
            int knapsackCapacity = parseStringToInteger(knapsackCapacityField);

            double startTimeAlghoritm = System.nanoTime();
           int optimum =  knapsack.solveKnapsackProblemTest(arrayList, arrayList,knapsackCapacity, liczba);
            double endTimeAlghoritm = System.nanoTime();
            double diference = endTimeAlghoritm - startTimeAlghoritm;
            resultTextfield.setText(String.valueOf(optimum));
            timeField.setText(diference + " us");
        }

    }
}
