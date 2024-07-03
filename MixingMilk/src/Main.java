import java.io.*;
import java.util.*; //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        int[][] arr = readNumbersFromFile("/Users/shivvinodshankar/Downloads/blist_bronze_dec18/2.in");
        System.out.println(Mixingmilk(arr));
    }

    public static int Mixingmilk(int[][] arr) {
        int bucket_count = 0;
        int min1;
        int max1;
        int min2;
        int max2;
        for (int i = 0; i < arr.length - 1; i++) {
            min1 = arr[i][0];
            max1 = arr[i][1];
            min2 = arr[i+1][0];
            max2 = arr[i+1][1];
            System.out.println(min1 + " " + max1 + " " + min2 + " " + max2);
            if (overlapping(min1, max1, min2, max2)) {
                bucket_count += arr[i+1][2];
                System.out.println("true " + bucket_count);
            } else {
                if (bucket_count < arr[i][2] || bucket_count < arr[i + 1][2]) {
                    bucket_count = Math.max(arr[i][2], arr[i + 1][2]);
                }

            }
        }
        return bucket_count;
    }

    private static boolean overlapping(int min1, int max1, int min2, int max2) {
        return Math.max(min1, min2) <= Math.min(max1, max2);
    }

    public static int[][] readNumbersFromFile(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        int[][] arr = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = reader.readLine();
            arr = new int[Integer.parseInt(text)][3];
            for (int i = 0; i < arr.length; i++) {
                /*for (int j = 0; j < 3; j++) {
                    text = reader.readLine();
                    arr[i][j] = Integer.parseInt(text);
                    System.out.println(i+ " " + j + " " + arr[i][j]);
                }*/
                text = reader.readLine();
                arr[i] = parseInts(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        return arr;


    }
    public static int[] parseInts(String s){
        String[] sNums = s.split(" ");
        int[] nums = new int[sNums.length];
        for(int i = 0; i < sNums.length; i++){
            nums[i] = Integer.parseInt(sNums[i]);
        }
        return nums;
    }
}
