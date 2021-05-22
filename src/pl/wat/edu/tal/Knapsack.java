package pl.wat.edu.tal;

import java.util.*;

public class Knapsack {

    ArrayList<Integer> objects = new ArrayList<>();
    ArrayList<Float> profits;
    ArrayList<Float> weights;
    int maxWeights;
    String sumProfits_sumWeights;

    public int[][] solveKnapsackProblemTest(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity, int numberOfItems) {
        ArrayList<Integer> takenElements = new ArrayList<>();
        if (countWeightsOfAllItems(weights) <= capacity) {
            System.out.println("You can pack all items. Using alghoritm is unnecessary");
        } else if (numberOfItems <= 0) {
            System.out.println("You have to have positive number of items!");
        }
        int[][] knapsackTable = new int[numberOfItems + 1][capacity + 1];
        for (int j = 0; j <= capacity; j++) knapsackTable[0][j] = 0;

        for (int i = 1; i <= numberOfItems; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights.get(i - 1) > w) {
                    knapsackTable[i][w] = knapsackTable[i - 1][w];
                } else {
                    knapsackTable[i][w] = Math.max(
                            knapsackTable[i - 1][w],
                            knapsackTable[i - 1]
                                    [w - weights.get(i - 1)] + values.get(i - 1));
                }
            }
        }

        int currentKnapsackCapacity = capacity;
        ArrayList<Integer> timesWeightAndValue = new ArrayList<>();
        for (int i = numberOfItems; i >= 1; i--) {
            if (knapsackTable[i][currentKnapsackCapacity] > knapsackTable[i - 1][currentKnapsackCapacity]) {
                takenElements.add(i);
                timesWeightAndValue.add(values.get(i - 1));
                currentKnapsackCapacity -= weights.get(i - 1);
                System.out.println("Przedmiot nr: " + i + " jest pakowany do koszyka");
            } else {
                System.out.println("Przedmiot nr " + i + " nie jest pakowany do koszyka");
            }
            System.out.println("Wartość zabranych przedmiotów: " + countElementsOfArray(timesWeightAndValue));

        }
        System.out.println(takenElements);
//        return takenElements;
        System.out.println(knapsackTable[numberOfItems][capacity]);
//        return knapsackTable[numberOfItems][capacity];
        return knapsackTable;
    }

    public int exactAlgorithm(ArrayList<Integer> weights, ArrayList<Integer> values, int capacity, int numberOfItems) {
        ArrayList<Integer> takenElements = new ArrayList<>();
        int optimum = 0;
        if (countWeightsOfAllItems(weights) <= capacity) {
            System.out.println("You can pack all items. Using alghoritm is unnecessary");
        } else if (numberOfItems <= 0) {
            System.out.println("You have to have positive number of items!");
        } else if (weights.get(numberOfItems - 1) > capacity) {
            return exactAlgorithm(weights, values, capacity, numberOfItems - 1);
        } else {
            optimum = Math.max(exactAlgorithm(weights, values, capacity, numberOfItems - 1),
                    values.get(numberOfItems - 1) + exactAlgorithm(weights, values, capacity - weights.get(numberOfItems - 1),
                            numberOfItems - 1));
            System.out.println("Optimum by exact algorithm: " + optimum);
        }
        return optimum;
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

//    public ArrayList<Integer> solveKnapsackDP(int[] weights, int[] values, int numOfItems, int capacity) {
//        ArrayList<Integer> takenElements = new ArrayList<>();
//        if (countWeightsOfAllItems(weights) <= capacity) {
//            System.out.println("You can pack all items. Using alghoritm is unnecessary");
//        } else if (numOfItems <= 0) {
//            System.out.println("You have to have positive number of items!");
//        } else {
//            ArrayList<Integer> timesWeightAndValue = new ArrayList<>();
//            int[][] knapsackTableSave = new int[numOfItems + 1][capacity + 1];
//            for (int j = 0; j < knapsackTableSave.length; j++) {
//                knapsackTableSave[0][j] = 0;
//            }
//            for (int i = 1; i <= numOfItems; i++) {
//                for (int w = 1; w <= capacity; w++) {
//                    if (weights[i - 1] > w) {
//                        knapsackTableSave[i][w] = knapsackTableSave[i - 1][w];
//                    } else {
//                        knapsackTableSave[i][w] = Math.max(knapsackTableSave[i - 1][w],
//                                knapsackTableSave[i - 1][w - weights[i - 1]] + values[i - 1]);
//                    }
//                }
//            }
//
//            int currentKnapsackCapacity = capacity;
//            for (int i = numOfItems; i >= 1; i--) {
//                if (knapsackTableSave[i][currentKnapsackCapacity] > knapsackTableSave[i - 1][currentKnapsackCapacity]) {
//                    takenElements.add(i);
//                    timesWeightAndValue.add(values[i - 1]);
//                    currentKnapsackCapacity -= weights[i - 1];
//                } else {
//                    System.out.println("Przedmiot nr " + i + " nie jest pakowany do koszyka");
//                }
//            }
//            System.out.println("Wartość zabranych przedmiotów: " + countElementsOfArray(timesWeightAndValue));
//            System.out.println("Zebrane elementy");
//            System.out.println(takenElements);
//
//        }
//        return takenElements;
//    }

    /**
     * This method finds and returns the index of the elemnt with max value from
     * the ArrayList
     *
     * @param fraction
     * @return maxIndice
     */
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

    /**
     * Method which sums elements from ArrayList, using in checking
     * whether sum of elemnts is lower than knapsack capacity
     *
     * @param arrayList
     * @return
     */
    public int countElementsOfArray(ArrayList<Integer> arrayList) {
        int amount = 0;
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
        int sumOfItems = 0;
        for (int i = 0; i < arrayList.size(); i++) {
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
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int randomValue = random.nextInt(scope) + 1;
            arrayList.add(randomValue);
        }
        System.out.println(arrayList);
        return arrayList;
    }

    /** Method which converts matrix of Integer to matrix of String
     *
     * @param t
     * @return
     */
    public String[][] printOptimumMatrix(int[][] t) {
        String[][] table = new String[t.length][t[0].length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                table[i][j] = String.valueOf(t[i][j]);
            }
        }
        return table;
    }
}


