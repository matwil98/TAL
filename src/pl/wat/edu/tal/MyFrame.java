package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {


    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    private MyPanel myPanel;

    public MyFrame() {
        super("Discrete Knapsack problem");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("knapsack.jpg");
        setIconImage(imageIcon.getImage());


        setLocation(100, 100);
        myPanel = new MyPanel();
        setContentPane(myPanel);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


}
