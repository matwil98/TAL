package pl.wat.edu.tal;

import java.util.*;

public class Knapsack {

    ArrayList<Integer> objects = new ArrayList<>();
    ArrayList<Float> profits;
    ArrayList<Float> weights;
    ArrayList<Integer> weightsI;
    ArrayList<Integer> valuesI;
    int maxWeights;
    String sumProfits_sumWeights;

    public int solveKnapsackProblem(int[] weights, int[] values, int capacity, int numberOfItems) {

        int[][] knapsackTable = new int[numberOfItems + 1][capacity + 1];
        for (int j = 0; j <= capacity; j++) knapsackTable[0][j] = 0;

        for (int i = 1; i <= numberOfItems; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] > w) {
                    knapsackTable[i][w] = knapsackTable[i - 1][w];
                } else {
                    knapsackTable[i][w] = Math.max(
                            knapsackTable[i - 1][w],
                            knapsackTable[i - 1]
                                    [w - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        System.out.println(knapsackTable[numberOfItems][capacity]);

        return knapsackTable[numberOfItems][capacity];
    }


    public int knapsackRecursive(int[] w, int[] v, int n, int W) {
        if (n <= 0) {
            return 0;
        } else if (w[n - 1] > W) {
            return knapsackRecursive(w, v, n - 1, W);
        } else {
            int result = Math.max(knapsackRecursive(w, v, n - 1, W), v[n - 1]
                    + knapsackRecursive(w, v, n - 1, W - w[n - 1]));
            System.out.println(result);
            return result;
        }

    }

    public Knapsack() {
    }

    public Knapsack(ArrayList<Float> weights, ArrayList<Float> values, int numObjects, int maxWeights) {
        this.profits = values;
        this.weights = weights;
        this.maxWeights = maxWeights;
        for (int i = 0; i < numObjects; i++) {
            objects.add(i);
        }
    }


    public ArrayList<Integer> solve() {
        ArrayList<Float> fraction = new ArrayList<>();
        ArrayList<Integer> results_objects = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            fraction.add(profits.get(i) / weights.get(i));
        }

        int maxObjectProfit;
        float sumOfWeights = 0;
        float sumOfProfits = 0;
        boolean test = true;
        while (test) {
            maxObjectProfit = getIndiceMax(fraction);
            test = false;
            float temp = sumOfWeights + weights.get(maxObjectProfit);
            if (temp <= maxWeights) {
                test = true;
                sumOfWeights = temp;
                results_objects.add(maxObjectProfit);
                sumOfProfits = sumOfProfits + profits.get(maxObjectProfit);
            }
        }
        sumProfits_sumWeights = " weights = " + sumOfWeights + " profits = " + sumOfProfits;
        System.out.println(sumProfits_sumWeights);
        for (Integer i : results_objects) {
            System.out.println(results_objects);
        }
        return results_objects;
    }

//    public ArrayList<Integer> solveKnapsackDP(int numOfItems, int capacity) {
//        ArrayList<Integer> resultsObjects = new ArrayList<>();
//        int knapsackTableSave[][] = new int[weightsI.size() + 1][valuesI.size() + 1];
//        for (int j = 0; j < knapsackTableSave.length; j++) {
//            knapsackTableSave[0][j] = 0;
//        }
//
//        for (int i = 1; i <= numOfItems; i++) {
//            for (int w = 1; w <= capacity; w++) {
//                if (numOfItems <= 0) {
//                    System.out.println("Nie ma żadnych elementów do zapakowania");
//                } else if (weightsI.get(i) > w) {
//                    knapsackTableSave[i][w] = knapsackTableSave[i - 1][w];
//                } else {
//                    knapsackTableSave[i][w] = Math.max(knapsackTableSave[i - 1][w],
//                            knapsackTableSave[i - 1][w - weightsI.get(i)] + valuesI.get(i));
//
//                }
//            }
//            return 0;
//        }
//
//    }



    public int getIndiceMax(ArrayList<Float> fraction) {
        float maxValue = 0;
        int maxIndice = 0;
        for (int i = 0; i < fraction.size(); i++) {
            if (fraction.get(i) > maxValue) {
                maxValue = fraction.get(i);
                maxIndice = fraction.indexOf(maxValue);
            }
        }
        fraction.set(maxIndice, (float) -1);
        return maxIndice;
    }

}


