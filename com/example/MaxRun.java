import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This program finds the max run of lines in a file.
 *
 * @author Jaydin Madore
 * @version 1
 * @since 2024-04-14
 */

public final class MaxRun {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();

        try {
            // Read input file.
            inputList = Files.readAllLines(Paths.get("input.txt"));

            // The Program creates an array with all elements in the input file.
            String[] lineArray = new String[inputList.size()];
            lineArray = inputList.toArray(lineArray);

            // This Code calls the function and write to the output File.
            try (FileWriter outputFile = new FileWriter("output.txt")) {
                // Calls the findMaxRunInLine function to find the maximum
                // run of characters in the line.
                // This For loop is repeated till is has gone through each
                // line in the lineArray array.
                for (String line : lineArray) {
                    int runCount = findMaxRun(line);
                    // It writes the run value to the output1.txt file, followed by a  newline
                    // character (\n).
                    outputFile.write(runCount + "\n");
                }
            }

        }
        // For when there is no input file.
        catch (IOException err) {
            System.err.println("Error: " + err.getMessage());
        }
    }

    // This function finds the max run for each line.
    public static int findMaxRun(String line) {
        // Declare variables.
        int currentRunCount = 1;
        int maxRunCount = 0;

        // If the line only holds one character.
        if (line.length() == 1) {
            maxRunCount = 1;
        }

        // The For Loop will not be executed if the line withen the input.txt flie
        // holds less than two characters.
        for (int counter = 0; counter < line.length() - 1; counter++) {
            // Will checks if the current character in the line is the same as the next character in the line.
            if (line.charAt(counter) == line.charAt(counter + 1)) {
                // If the character is the same it adds one to currentRunCount.
                currentRunCount++;
            } else {
                //If it is not the same, reset the current run count to 1.
                currentRunCount = 1;
            }
            // If the current run count is greater than the maximum run count.
            if (currentRunCount > maxRunCount) {
                maxRunCount = currentRunCount;
            }
        }
        // Returns the max run to the runCount variable in main.
        return maxRunCount;
    }
}