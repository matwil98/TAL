package pl.wat.edu.tal;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Discrete knapsack problem");
//        int numOfElements = 10;
//        int capacity = 50;
//        int[] randomWeights = new int[numOfElements];
//        int[] randomValues = new int[numOfElements];
//        for (int i = 0; i < numOfElements; i++) {
//            randomWeights[i] = new Random().nextInt(10) + 1;
//        }
//        for (int j = 0; j < numOfElements; j++) {
//            randomValues[j] = new Random().nextInt(1000) + 1;
//        }
//
//        int[] weights = new int[]{2, 2, 3, 15, 1, 4, 5, 6};
//        int[] values = new int[]{40, 160, 70, 300, 70, 25, 25, 180};
//
//        Knapsack knapsack = new Knapsack();
//        knapsack.solveKnapsackProblem(weights, values, 15,8);
//
//        float[] weights2 = new float[]{2, 2, 3, 15, 1, 4, 5, 6};
//        float[] values2 = new float[]{40, 160, 70, 300, 70, 25, 25, 180};
//
//        ArrayList<Float> w = new ArrayList<Float>();
//        ArrayList<Float> v = new ArrayList<Float>();
//        for (int i = 0; i < weights2.length; i++) {
//            w.add(weights2[i]);
//            v.add(values2[i]);
//        }
//        Knapsack knapsack2 = new Knapsack(w, v, 8, 15);
//
//
//        Knapsack knapsack = new Knapsack();
//        double startTimeDP = System.currentTimeMillis();
//        knapsack.solveKnapsackProblem(randomWeights, randomValues, capacity, numOfElements);
//        double stopTimeDP = System.currentTimeMillis();
//        System.out.println("Time of alghortim DP: " + (stopTimeDP - startTimeDP));
//
//        double startTimeGA = System.currentTimeMillis();
//        knapsack2.solve();
//        double stopTimeGA = System.currentTimeMillis();
//        System.out.println("Time of alghortim GA: " + (stopTimeGA - startTimeGA));
//
//        FileExecutor fileExecutor = new FileExecutor();
//        int[] table = fileExecutor.randomTable();
//        fileExecutor.writeTableToFile(table, "weights.txt");
//        fileExecutor.readTableFromFile("weights.txt");
//
//
//        Knapsack knapsack3 = new Knapsack();
//
//        double startRecursiveAlghoritm = System.currentTimeMillis();
//        knapsack3.knapsackRecursive(randomWeights, randomValues, numOfElements, capacity);
//        double stopRecursiveAlghoritm = System.currentTimeMillis();
//        System.out.println("Time of alghortim RECURSIVE: " + (stopRecursiveAlghoritm - startRecursiveAlghoritm));
//
//
//        MyFrame frame = new MyFrame();
//        frame.setContentPane(new MyPanel());
//        frame.setVisible(true);
//
//        int[] weights = new int[]{2, 2, 3, 15, 1, 4, 5, 6};
//        int[] values = new int[]{40, 160, 70, 300, 70, 25, 25, 180};
//
//        Knapsack knapsack = new Knapsack();
//        knapsack.solveKnapsackDP(weights,values,8,15);
//
//        knapsack.countWeightsOfAllItems(weights);


        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);


    }


}
