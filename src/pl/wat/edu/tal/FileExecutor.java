package pl.wat.edu.tal;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileExecutor {

    private String filename;
    private Random random;

    public FileExecutor() {

    }

    public int[] randomTable() {
        System.out.println("Enter the length of table: ");
        random = new Random();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Liczba elementów tablicy musi być dodatnia!");
        }
        int[] w = new int[number];
        System.out.println("Enter the upper bound of random numbers");
        int bound = sc.nextInt();
        for (int i = 0; i < w.length; i++) {
            w[i] = random.nextInt(bound) + 1;
        }
        return w;
    }

    public void writeTableToFile(int[] w, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            numbers.add(w[i]);
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int j = 0; j < numbers.size(); j++) {
            fileWriter.write(numbers.get(j).toString() + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void readTableFromFile(String filename) throws IOException {
        File file = new File(filename);
        if(!file.exists()){
            file.createNewFile();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
        }
        System.out.println(stringBuilder.toString());


    }
}
