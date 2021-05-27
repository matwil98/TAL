package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private JPanel jPanel;
    private JTextField knapsackCapacityField;
    private JTextField numOfObjectsTextField;
    private JTextField scopeOfWeightsTextField;
    private JTextField valuesTextField;
    private JTextArea areaOfWeights;
    private JTextArea areaOfValues;
    private JButton jButton;
    private JButton resultButton;
    private JTextField timeField;
    private JButton flushButton;
    private JButton exactAlgorithm;
    private JTextField exactResult;
    private JTextField tfTimeOfExactA;
    private JTextField resultTextfield;
    private JTextField timeDiffernece;

    private ArrayList<Integer> arrayList;
    private ArrayList<Integer> arrayList1;
    private int capacity;
    private int nOfObjects;
    int[][] optimum;
    ArrayList<Integer> takenElements;
    double startTimeAlgorithmDP;
    double endTimeAlgorithmDP;
    double startTimeAlgorithmEA;
    double endTimeAlgorithmEA;

    public GUI() {

        jButton.addActionListener(e -> {
            var knapsack = new Knapsack();
            var number = Integer.parseInt(numOfObjectsTextField.getText());
            var scopeOfWeights = Integer.parseInt(scopeOfWeightsTextField.getText());
            var scopeOfValues = Integer.parseInt(valuesTextField.getText());
            String[] stringList;
            String[] stringList2;
            var napis = new StringBuilder();
            var napis2 = new StringBuilder();
            arrayList = knapsack.convertToArrayList(number, scopeOfWeights);
            arrayList1 = knapsack.convertToArrayList(number, scopeOfValues);
            for (var i = 0; i < number; i++) {
                stringList = new String[number];
                stringList2 = new String[number];
                stringList[i] = String.valueOf(arrayList.get(i));
                stringList2[i] = String.valueOf(arrayList1.get(i));
                napis.append(stringList[i]).append(",");
                napis2.append(stringList2[i]).append(",");
                if (i == number - 1) {
                    napis.replace(napis.length() - 1, napis.length(), " ");
                    napis2.replace(napis2.length() - 1, napis2.length(), " ");
                }
            }
            areaOfWeights.setText(napis.toString());
            areaOfWeights.setLineWrap(true);
            areaOfWeights.setEditable(false);
            areaOfValues.setText(napis2.toString());
            areaOfValues.setLineWrap(true);
            areaOfValues.setEditable(false);

        });
        resultButton.addActionListener(e -> {
            var knapsack = new Knapsack();
            nOfObjects = Integer.parseInt(numOfObjectsTextField.getText());
            capacity = Integer.parseInt(knapsackCapacityField.getText());
            startTimeAlgorithmDP = System.nanoTime();
            try {
                optimum = knapsack.solveKnapsackProblemTest(arrayList, arrayList1, capacity, nOfObjects);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            endTimeAlgorithmDP = System.nanoTime();
            double difference = endTimeAlgorithmDP - startTimeAlgorithmDP;
            resultTextfield.setText(String.valueOf(optimum[nOfObjects][capacity]));
            timeField.setText(difference + " ns");
            String[][] matrix = knapsack.printOptimumMatrix(optimum);

            var frame = new JFrame();
            var matrixPanel = new MatrixPanel(matrix);
            frame.setTitle("Matrix of optimum results ");
            var icon = new ImageIcon("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/matrix.png");
            frame.setIconImage(icon.getImage());
            frame.add(matrixPanel);
            frame.setVisible(true);
            frame.setLocation(40, 100);
            frame.pack();
            takenElements = knapsack.takenElements(optimum, arrayList, arrayList1, nOfObjects, capacity);

            var complexityPanel = new ComplexityPanel(takenElements, arrayList1, arrayList);
            var jFrame = new JFrame();
            var imageIcon = new ImageIcon("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/elements.jpg");
            jFrame.setIconImage(imageIcon.getImage());
            jFrame.setTitle("Taken elements");
            jFrame.add(complexityPanel);
            jFrame.setVisible(true);
            jFrame.setLocation(40, 380);
            jFrame.pack();
        });

        flushButton.setActionCommand("Flush data");
        flushButton.addActionListener(e -> {
            String action = e.getActionCommand();
            if (action.equals("Flush data")) {
                JTextField tmp;
                JTextArea tmp2;
                for (Component component : jPanel.getComponents()) {
                    if (component.getClass().toString().contains("javax.swing.JTextField")) {
                        tmp = (JTextField) component;
                        tmp.setText(null);
                    }
                }
                for (Component component : jPanel.getComponents()) {
                    if (component.getClass().toString().contains("javax.swing.JTextArea")) {
                        tmp2 = (JTextArea) component;
                        tmp2.setText(null);
                    }
                }
            }
        });

        exactAlgorithm.addActionListener(e -> {
            var knapsack = new Knapsack();
            nOfObjects = Integer.parseInt(numOfObjectsTextField.getText());
            capacity = Integer.parseInt(knapsackCapacityField.getText());
            startTimeAlgorithmEA = System.nanoTime();
            int result = 0;
            try {
                result = knapsack.exactAlgorithm(arrayList, arrayList1, capacity, nOfObjects);
            } catch (LowCapacityException lowCapacityException) {
                lowCapacityException.printStackTrace();
            }
            endTimeAlgorithmEA = System.nanoTime();
            double difference = endTimeAlgorithmEA - startTimeAlgorithmEA;
            exactResult.setText(String.valueOf(result));
            tfTimeOfExactA.setText(difference + " ns");
            int compareTime;
            double dpDiffernece = endTimeAlgorithmDP - startTimeAlgorithmDP;
            double eaDifference = endTimeAlgorithmEA - startTimeAlgorithmEA;
            if (dpDiffernece < eaDifference) {
                 compareTime = (int)eaDifference/ (int)dpDiffernece;
                timeDiffernece.setText("DP był szybszy ok. " + compareTime + " razy");
            } else{
                compareTime = (int) dpDiffernece / (int) eaDifference;
                timeDiffernece.setText("EA był szybszy ok. " + compareTime + " razy");
            }
        });
    }

    public static void main(String[] args) {
        var frame = new JFrame("Discrete Knapsack problem");
        frame.setContentPane(new GUI().jPanel);
        var imageIcon = new ImageIcon("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/plecak.jpg");
        frame.setIconImage(imageIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(650,300);
        frame.pack();
        frame.setVisible(true);
    }
}
