package pl.wat.edu.tal;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {


    private final int WIDTH = 300;
    private final int HEIGHT = 200;

    private JPanel jPanel;
    private MyPanel myPanel;

    public MyFrame() {
        super("Discrete Knapsack problem");

        setBackground(new Color(100, 100, 100));
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("plecak.jpg");
        setIconImage(imageIcon.getImage());
        setLocation(100, 100);

        myPanel = new MyPanel();

        setContentPane(myPanel);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }


}
