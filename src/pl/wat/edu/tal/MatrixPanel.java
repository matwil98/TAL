package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MatrixPanel extends JPanel {

   private String [][] matrix;
   private ArrayList<Integer> takenElements;
   private MyPanel myPanel;
    public MatrixPanel(String [][] matrix, ArrayList<Integer> takenElements){
        this.matrix = matrix;
        this.takenElements = takenElements;
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(matrix.length, matrix[0].length));
        for (String[] strings : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                jPanel.add(new JTextField(strings[j]));
            }
        }
        add(jPanel);
    }
}
