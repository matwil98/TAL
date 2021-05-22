package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {

   private String [][] matrix;

    public MatrixPanel(String [][] matrix){
        this.matrix = matrix;
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
