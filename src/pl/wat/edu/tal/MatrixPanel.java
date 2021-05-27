package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {

    String [][] matrix;

    public MatrixPanel(String [][] matrix){
        this.matrix = matrix;
        var jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(matrix.length , matrix[0].length ) );

        for (String[] strings : matrix) {
            for (var j = 0; j < matrix[0].length; j++) {
                jPanel.add(new JTextField(strings[j]));
            }
        }
        add(jPanel);
    }
}
