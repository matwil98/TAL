package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    private JLabel optimumExactResult;
    private JTextField exactResult;
    private JLabel timeOfExactAlgorithm;
    private JTextField tfTimeOfExactA;

    private JLabel values;
    private JTextField valuesTextField;
    private JButton jButton;
    private JButton resultButton;
    private JTextArea areaOfWeights;
    private JTextArea areaOfValues;
    private JButton exactAlgorithm;
    private JButton flushButton;
    private JButton exitButton;
    private JButton saveToFile;

    private ArrayList<Integer> arrayList;
    private ArrayList<Integer> arrayList1;
    private JPanel jPanel;

    public MyPanel() {
        jPanel = new JPanel();
        setBackground(new Color(200, 200, 200, 200));
        jPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 5));
        jPanel.setLayout(new GridLayout(12, 2, 10, 5));
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
        jButton.setBackground(new Color(100,200,122));
        jButton.setActionCommand("draw");
        jButton.addActionListener(this);
        jPanel.add(jButton);
        resultButton = new JButton("DP alghoritm");
        resultButton.addActionListener(this);
        resultButton.setBackground(new Color(220,130,20));
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
        exactAlgorithm = new JButton("Exact algorithm");
        exactAlgorithm.addActionListener(this);
        exactAlgorithm.setBackground(new Color(220,130,20));
        jPanel.add(exactAlgorithm);
        optimumExactResult = new JLabel("Optimum result");
        jPanel.add(optimumExactResult);
        exactResult = new JTextField(6);
        jPanel.add(exactResult);
        timeOfExactAlgorithm = new JLabel("Time of running algorithm");
        jPanel.add(timeOfExactAlgorithm);
        tfTimeOfExactA = new JTextField(6);
        jPanel.add(tfTimeOfExactA);
        saveToFile = new JButton("Save results to file");
        saveToFile.setToolTipText("DUPAAAAAA");
        saveToFile.addActionListener(this);
        jPanel.add(saveToFile);
        Image img = convertIconToGoodSize("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/clean.jpg");
        flushButton = new JButton(new ImageIcon(img));
        flushButton.setActionCommand("Flushdata");
        flushButton.addActionListener(this::clearAllTextFields);
        jPanel.add(flushButton);
        Image image = convertIconToGoodSize("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/exit.png");
        exitButton = new JButton(new ImageIcon(image));
        exitButton.addActionListener(this::exitProgram);
        jPanel.add(exitButton);
        add(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        knapsack = new Knapsack();
        int knapsackCapacity;
        int numOfObjects;
        int[][] optimum;
        ArrayList<Integer> takenElements;

        Object source = e.getSource();
        String choice = e.getActionCommand();

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
            areaOfWeights.setLineWrap(true);
            areaOfWeights.setEditable(false);
            areaOfValues.setText(napis2.toString());
            areaOfValues.setLineWrap(true);
            areaOfValues.setEditable(false);

        } else if (source == resultButton) {
            numOfObjects = Integer.parseInt(numOfObjectsTextField.getText());
            knapsackCapacity = Integer.parseInt(knapsackCapacityField.getText());
            ComplexityCounter complexityCounter = new ComplexityCounter();
            double startTimeAlgorithm = System.nanoTime();
            optimum = knapsack.solveKnapsackProblemTest(arrayList, arrayList1, knapsackCapacity, numOfObjects, complexityCounter);
            double endTimeAlgorithm = System.nanoTime();
            double difference = endTimeAlgorithm - startTimeAlgorithm;
            resultTextfield.setText(String.valueOf(optimum[numOfObjects][knapsackCapacity]));
            timeField.setText(difference + " us");
            String[][] matrix = knapsack.printOptimumMatrix(optimum);

            JFrame frame = new JFrame();
            MatrixPanel matrixPanel = new MatrixPanel(matrix);
            frame.setTitle("Matrix of optimum results ");
            ImageIcon icon = new ImageIcon("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/matrix.png");
            frame.setIconImage(icon.getImage());
            frame.add(matrixPanel);
            frame.setVisible(true);
            frame.setLocation(40, 100);
            frame.pack();
            takenElements = knapsack.takenElements(optimum, arrayList, arrayList1, numOfObjects, knapsackCapacity);

            ComplexityPanel complexityPanel = new ComplexityPanel(takenElements, arrayList1, arrayList);
            JFrame jFrame = new JFrame();
            ImageIcon imageIcon = new ImageIcon("C:/studia/SEMESTR_8/TAL/KNAPSACK/TAL/elements.jpg");
            jFrame.setIconImage(imageIcon.getImage());
            jFrame.setTitle("Taken elements");
            jFrame.add(complexityPanel);
            jFrame.setVisible(true);
            jFrame.setLocation(40, 380);
            jFrame.pack();

        } else if (source == exactAlgorithm) {
            numOfObjects = Integer.parseInt(numOfObjectsTextField.getText());
            knapsackCapacity = Integer.parseInt(knapsackCapacityField.getText());
            double startTimeAlgorithm = System.nanoTime();
            int result = knapsack.exactAlgorithm(arrayList, arrayList1, knapsackCapacity, numOfObjects);
            double endTimeAlgorithm = System.nanoTime();
            double difference = endTimeAlgorithm - startTimeAlgorithm;
            exactResult.setText(String.valueOf(result));
            tfTimeOfExactA.setText(difference + " ns");
        } else if(source == saveToFile){
            int [] t = new int[]{1,2,3,4,5,6};
            FileExecutor fe = new FileExecutor();
            try {
                fe.writeTableToFile(t, "test.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * Method which clears all textFields
     *
     * @param actionEvent
     */
    public void clearAllTextFields(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();
        if (action.equals("Flushdata")) {
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
    }

    /**
     * ActionEvent which asks user whether he wants to exit from programme
     *
     * @param actionEvent
     */
    public void exitProgram(ActionEvent actionEvent) {
        int exit = JOptionPane.showConfirmDialog(jPanel, "Do you want to leave programme?", "Exit panel", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }

    /**
     * Method which convert iconimage to proper size on JButton
     *
     * @param filepath is the path to location of file
     * @return new Image
     */
    public Image convertIconToGoodSize(String filepath) {
        ImageIcon imageIcon = new ImageIcon(filepath);
        Image image = imageIcon.getImage();
        Image image1 = image.getScaledInstance(150, 30, java.awt.Image.SCALE_SMOOTH);
        return image1;
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
