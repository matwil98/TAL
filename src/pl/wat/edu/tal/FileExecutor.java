package pl.wat.edu.tal;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileExecutor {

    /**
     * Method which save data to file.
     * @param file
     * @param weights
     * @param values
     * @param takenElements
     * @param optimum
     * @throws IOException
     */
    public void saveToFile(final File file, final ArrayList<Integer> weights, final ArrayList<Integer> values, final ArrayList<Integer>  takenElements, final int optimum) throws IOException {

        var weightsSubtitle = "Weights:";
        var valuesSubtitle = "Values:";
        var optimuSubtitle = "Optimum result:";
        var takenElementsSubtitle = "Taken elements:";

        try {
            var bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            var weightSb = new StringBuilder();
            var valueSb = new StringBuilder();

            for (var i = 0; i < weights.size(); i++) {
                weightSb.append(weights.get(i) + ",");
                valueSb.append(values.get(i) + ",");
                if (i == weights.size() - 1) {
                    weightSb.replace(weightSb.length() - 1, weightSb.length(), " ");
                    valueSb.replace(valueSb.length() - 1, valueSb.length(), " ");
                }
            }
            var takenSb = new StringBuilder();
            for (var j = 0; j < takenElements.size(); j++) {
                takenSb.append("el. nr " + takenElements.get(j) + " ,");
                if (j == takenElements.size() - 1) {
                    takenSb.replace(takenSb.length() - 1, takenSb.length(), " ");
                }
            }
            var optimumSb = new StringBuilder();
            optimumSb.append(optimum);

            bufferedWriter.write(weightsSubtitle + "\n");
            bufferedWriter.write(weightSb.toString() + "\n");
            bufferedWriter.write(valuesSubtitle + "\n");
            bufferedWriter.write(valueSb.toString() + "\n");
            bufferedWriter.write(optimuSubtitle + "\n");
            bufferedWriter.write(optimumSb.toString() + "\n");
            bufferedWriter.write(takenElementsSubtitle + "\n");
            bufferedWriter.write(takenSb + "\n");
            bufferedWriter.write("---------------------------------------" + "\n");

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException exc) {
            System.exit(0);
        }

    }

}
