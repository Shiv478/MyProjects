import java.io.*;
import java.util.ArrayList;

public class ReadNumbersFromFile {
    public static void main(String[] args) {
        String filePath = "/mnt/data/2.in";
        int[][] numbersArray = readNumbersFromFile(filePath);

        // Print the 2D array
        System.out.println("Numbers in the 2D array:");
        for (int i = 0; i < numbersArray.length; i++) {
            for (int j = 0; j < numbersArray[i].length; j++) {
                System.out.print(numbersArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readNumbersFromFile(String filePath) {
        ArrayList<Integer> numbersList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    numbersList.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate the number of rows needed for the 2D array with 3 columns
        int rows = (int) Math.ceil(numbersList.size() / 3.0);
        int[][] numbersArray = new int[rows][3];

        // Populate the 2D array
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 3; j++) {
                if (index < numbersList.size()) {
                    numbersArray[i][j] = numbersList.get(index++);
                } else {
                    numbersArray[i][j] = 0; // Fill with 0 if there are not enough numbers
                }
            }
        }

        return numbersArray;
    }
}
