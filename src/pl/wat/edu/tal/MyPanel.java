package pl.wat.edu.tal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {

    private Knapsack knapsack;
    private String[] columnsName = {"ID", "Name", "Surname"};
    private Object[][] object = {{"1", "Mateusz", "Wilusz"},
                                 {"2", "Tomasz", "Kowalski"},
                                  {"3", "Jan", "Wróbel"}};

    public MyPanel() {
        JPanel jPanel = new JPanel();
        setLayout(new GridLayout(2, 3));
        JLabel numOfObjects = new JLabel("NumberOfObjects");
        jPanel.add(numOfObjects);
        JTextField numOfObjectsTextField = new JTextField(6);
//        numOfObjectsTextField.setBounds(0,0,40,30);
        jPanel.add(numOfObjectsTextField);
        JLabel knapsackCapacityLabel = new JLabel("KnapsackCapacity");
        jPanel.add(knapsackCapacityLabel);
        JTextField knapsackCapacityTextField = new JTextField(6);
        jPanel.add(knapsackCapacityTextField);
        JButton jButton = new JButton("First button");
        JTextPane jTextPane = new JTextPane();
        jPanel.add(jButton);
        jPanel.add(jTextPane);

        DefaultTableModel defaultTableModel = new DefaultTableModel(object,columnsName);
        JTable jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setViewportView(jTable);
        jTable.setModel(defaultTableModel);

        jPanel.add(jTable);
        jPanel.add(jScrollPane);
        add(jPanel);
    }


}
