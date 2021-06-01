package pl.wat.edu.tal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Knapsack {

    int globalCounterOfOperations = 0;
    /**
     * Method of dynamic programming solution 0-1 knapsack problem.
     * @param weights
     * @param values
     * @param capacity
     * @param numberOfItems
     * @return knapsackTable [][]
     * @throws IllegalArgumentException
     */
    public int[][] solveKnapsackProblemTest(final ArrayList<Integer> weights, final ArrayList<Integer> values, final int capacity, final int numberOfItems) throws IllegalArgumentException {
        var complexityCounter = new ComplexityCounter(0);
        if (numberOfItems <= 0) {
            complexityCounter.increaseCounterOfOperation(1);
            JOptionPane.showMessageDialog(null, "Number of items must be > 0", "Warning", JOptionPane.WARNING_MESSAGE);
            throw new IllegalArgumentException();
        } else if (countWeightsOfAllItems(weights) <= capacity) {
            JOptionPane.showMessageDialog(null, "Weights of all items are lower than capacity. All elements are taken", "Warning", JOptionPane.WARNING_MESSAGE);
            complexityCounter.increaseCounterOfOperation(1);
        }
    
        var knapsackTable = new int[numberOfItems + 1][capacity + 1];
        for (var i = 1; i <= numberOfItems; i++) {
            for (var w = 1; w <= capacity; w++) {
                if (weights.get(i - 1) > w) {
                    knapsackTable[i][w] = knapsackTable[i - 1][w];
                    complexityCounter.increaseCounterOfOperation(1);
                } else {
                    knapsackTable[i][w] = Math.max(
                            knapsackTable[i - 1][w],
                            knapsackTable[i - 1]
                                    [w - weights.get(i - 1)]
                                    + values.get(i - 1));
                    complexityCounter.increaseCounterOfOperation(1);
                }
            }
        }
        System.out.println("Liczba wykoannych operacji: " + complexityCounter.getCounterOperation());
        return knapsackTable;
    }

    /**
     * Method which returns ArrayList of taken to knapsack elements.
     * @param t          as table from DP method solution
     * @param weights    as ArrayList of weights of elements
     * @param values     as ArrayList of values of elements
     * @param numOfItems as number of items
     * @param capacity   as knapsack's capacity
     * @return takenElements
     */
    public ArrayList<Integer> takenElements(final int[][] t, final ArrayList<Integer> weights, final ArrayList<Integer> values, final int numOfItems, final int capacity) {
        ArrayList<Integer> takenElements = new ArrayList<>();
        int currentKnapsackCapacity = capacity;
        for (int i = numOfItems; i >= 1; i--) {
            if (t[i][currentKnapsackCapacity] > t[i - 1][currentKnapsackCapacity]) {
                takenElements.add(i);
                currentKnapsackCapacity -= weights.get(i - 1);
            }
        }

        return takenElements;
    }

    /**
     * Method of exact algorithm.
     * @param weights
     * @param values
     * @param capacity
     * @param numberOfItems
     * @return optimum
     */
    public int exactAlgorithm(final ArrayList<Integer> weights, final ArrayList<Integer> values, final int capacity, final int numberOfItems) {
        var complexityCounter = new ComplexityCounter(0);
        var optimum = 0;
        complexityCounter.increaseCounterOfOperation(1);
        if (countWeightsOfAllItems(weights) <= capacity) {
            complexityCounter.increaseCounterOfOperation(1);
            return countWeightsOfAllItems(values);
        } else if (numberOfItems <= 0) {
            complexityCounter.increaseCounterOfOperation(1);
        } else if (weights.get(numberOfItems - 1) > capacity) {
            complexityCounter.increaseCounterOfOperation(1);
            return exactAlgorithm(weights, values, capacity, numberOfItems - 1);
        } else {
            optimum = Math.max(exactAlgorithm(weights, values, capacity, numberOfItems - 1),
                    values.get(numberOfItems - 1) + exactAlgorithm(weights, values, capacity - weights.get(numberOfItems - 1),
                            numberOfItems - 1));
            complexityCounter.increaseCounterOfOperation(1);
        }
        globalCounterOfOperations +=complexityCounter.getCounterOperation();
        System.out.println("Liczba wykonanych operacji dla algorytmu dokładnego: " + globalCounterOfOperations);
        return optimum;
    }

    /**
     * This method counts the weights of all table's elements.
     * Method is used to verify whether sum of elements is lower than knapsack capacity
     * @param arrayList
     * @return sumOfItems
     */
    public int countWeightsOfAllItems(final ArrayList<Integer> arrayList) {
        var sumOfItems = 0;
        for (var i = 0; i < arrayList.size(); i++) {
            sumOfItems += arrayList.get(i);
        }
        return sumOfItems;
    }

    /**
     * Method which convert parameters given by user to ArrayList
     * of elements weights and values.
     * @param number
     * @param scope
     * @return arrayList
     */
    public ArrayList<Integer> convertToArrayList(final int number,
                                                 final int scope) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (var i = 0; i < number; i++) {
            int randomValue = new Random().nextInt(scope) + 1;
            arrayList.add(randomValue);
        }
        return arrayList;
    }

    /**
     * Method which converts matrix of Integer to matrix of String.
     * @param t
     * @return table
     */
    public String[][] printOptimumMatrix(final int[][] t) {
        var table = new String[t.length][t[0].length];
        for (var i = 0; i < t.length; i++) {
            for (var j = 0; j < t[0].length; j++) {
                table[i][j] = String.valueOf(t[i][j]);
            }
        }
        return table;
    }

}



