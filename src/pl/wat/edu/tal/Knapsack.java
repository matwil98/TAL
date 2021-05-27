package pl.wat.edu.tal;

import java.util.*;

public class Knapsack {

    ArrayList<Integer> objects = new ArrayList<>();
    ArrayList<Float> profits;
    ArrayList<Float> weights;
    int maxWeights;
    int counterOfOperations = 0;
    ComplexityCounter complexityCounter = new ComplexityCounter();


    public int[][] solveKnapsackProblemTest(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity, int numberOfItems) throws LowCapacityException, IllegalArgumentException {
        var operation = 1;

        complexityCounter.setCounterOperation(0);
        if (countWeightsOfAllItems(weights) <= capacity) {
            throw new LowCapacityException("Weight of all items is less than capacity");
        } else if (numberOfItems <= 0) {
           throw new IllegalArgumentException();
        }
        var knapsackTable = new int[numberOfItems + 1][capacity + 1];
        for (var i = 1; i <= numberOfItems; i++) {
            for (var w = 1; w <= capacity; w++) {
                if (weights.get(i - 1) > w) {
                    knapsackTable[i][w] = knapsackTable[i - 1][w];
                    complexityCounter.increaseCounterOfOperation(operation);
                } else {
                    knapsackTable[i][w] = Math.max(
                            knapsackTable[i - 1][w],
                            knapsackTable[i - 1]
                                    [w - weights.get(i - 1)] + values.get(i - 1));
                    complexityCounter.increaseCounterOfOperation(operation);
                }
            }
        }

        return knapsackTable;
    }

    public ArrayList<Integer> takenElements(int[][] t, ArrayList<Integer> weights, ArrayList<Integer> values, int numOfItems, int capacity) {
        ArrayList<Integer> takenElements = new ArrayList<>();
        int currentKnapsackCapacity = capacity;
        ArrayList<Integer> timesWeightAndValue = new ArrayList<>();
        for (int i = numOfItems; i >= 1; i--) {
            if (t[i][currentKnapsackCapacity] > t[i - 1][currentKnapsackCapacity]) {
                takenElements.add(i);
                timesWeightAndValue.add(values.get(i - 1));
                currentKnapsackCapacity -= weights.get(i - 1);
            }
        }

        return takenElements;
    }

    public int exactAlgorithm(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity, int numberOfItems) throws LowCapacityException {
        var optimum = 0;
        complexityCounter.setCounterOperation(counterOfOperations);
        if (countWeightsOfAllItems(weights) <= capacity) {
            throw new LowCapacityException("Weight of all items is less than capacity");
        } else if (numberOfItems <= 0) {
            System.out.println("");
        } else if (weights.get(numberOfItems - 1) > capacity) {
            counterOfOperations++;
            return exactAlgorithm(weights, values, capacity, numberOfItems - 1);
        } else {
            optimum = Math.max(exactAlgorithm(weights, values, capacity, numberOfItems - 1),
                    values.get(numberOfItems - 1) + exactAlgorithm(weights, values, capacity - weights.get(numberOfItems - 1),
                            numberOfItems - 1));
            counterOfOperations++;
        }
        return optimum;
    }

    public Knapsack() {
    }

    public Knapsack(ArrayList<Float> weights, ArrayList<Float> values, int numObjects, int maxWeights) {
        this.profits = values;
        this.weights = weights;
        this.maxWeights = maxWeights;
        for (var i = 0; i < numObjects; i++) {
            objects.add(i);
        }
    }

    /**
     * This method finds and returns the index of the elemnt with max value from
     * the ArrayList
     *
     * @param fraction
     * @return maxIndice
     */
    public int getIndiceMax(ArrayList<Float> fraction) {
        float maxValue = 0;
        var maxIndice = 0;
        for (var i = 0; i < fraction.size(); i++) {
            if (fraction.get(i) > maxValue) {
                maxValue = fraction.get(i);
                maxIndice = fraction.indexOf(maxValue);
            }
        }
        fraction.set(maxIndice, (float) -1);
        return maxIndice;
    }

    /**
     * Method which sums elements from ArrayList, using in checking
     * whether sum of elemnts is lower than knapsack capacity
     *
     * @param arrayList
     * @return
     */
    public int countElementsOfArray(ArrayList<Integer> arrayList) {
        var amount = 0;
        for (Integer i : arrayList) {
            amount += i;
        }
        return amount;
    }

    /**
     * This method counts the weights of all table's elements
     * Method is used to verify whether sum of elements is lower than knapsack capacity
     *
     * @param arrayList
     * @return sumOfItems
     */
    public int countWeightsOfAllItems(ArrayList<Integer> arrayList) {
        var sumOfItems = 0;
        for (var i = 0; i < arrayList.size(); i++) {
            sumOfItems += arrayList.get(i);
        }
        return sumOfItems;
    }

    /**
     * Method which convert parameters given by user to ArrayList of elements weights and values
     *
     * @param number
     * @param scope
     * @return arrayList
     */
    public ArrayList<Integer> convertToArrayList(int number, int scope) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (var i = 0; i < number; i++) {

            int randomValue = new Random().nextInt(scope) + 1;
            arrayList.add(randomValue);
            complexityCounter.countInt(arrayList.size());
        }

        return arrayList;
    }

    /**
     * Method which converts matrix of Integer to matrix of String
     *
     * @param t
     * @return
     */
    public String[][] printOptimumMatrix(int[][] t) {
        var table = new String[t.length][t[0].length];
        for (var i = 0; i < t.length; i++) {
            for (var j = 0; j < t[0].length; j++) {
                table[i][j] = String.valueOf(t[i][j]);
            }
        }
        return table;
    }

}



