package pl.wat.edu.tal;

import javax.swing.*;
import java.util.ArrayList;

public class ComplexityPanel extends JPanel  {

    private ArrayList<Integer> arrayList;

    public ComplexityPanel(ArrayList<Integer> arrayList){
        JPanel jPanel = new JPanel();
        this.arrayList=arrayList;
        for(Integer i: arrayList){
            jPanel.add(new JButton(String.valueOf(i)));
        }
        add(jPanel);
    }
}
