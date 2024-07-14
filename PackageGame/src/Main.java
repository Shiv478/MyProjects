//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/shivvinodshankar/Documents/JavaFiles/PackageGame/src/Input";
        File file = new File(path);
        Scanner input = new Scanner(file);
        int count = 0;
        ArrayList<Integer> bucketNumbers = new ArrayList<Integer>();
        while(input.hasNextInt()){
            count++;
            bucketNumbers.add(input.nextInt());
        }
        for(int i = 0; i < bucketNumbers.size(); i++){
            System.out.print(bucketNumbers.get(i) + " ");
        }
        System.out.println();
        bucketdistributer(3, bucketNumbers,count);

    }
    public static void bucketdistributer(int bucketNumber, ArrayList<Integer> arr, int count){
        String[] buckets = new String[bucketNumber];
        int sum = 0;
        for(int i = 0 ; i<arr.size(); i++){
            sum += arr.get(i);
        }
        System.out.println(sum);
        double unroundedAverage = (double)sum/bucketNumber;
        double avg = Math.round(unroundedAverage * 100.0) / 100.0;
        System.out.println(avg);
        Collections.sort(arr);
        for(int i = 0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
        for(int j = count; j<0; j--){
            System.out.print(arr.get(j) + " ");
        }
        String addition =" ";
        int total = 0;
        for(int i = 0; i<bucketNumber; i++){
            for(int j = 0; j<arr.size(); j++){
                if(arr.get(i) > avg){
                    buckets[i] = arr.get(i) + " ";
                }else{
                    if(total>avg){
                      break;
                    }else{
                        addition += arr.get(i) + " ";
                        total += arr.get(i);
                    }
                }
            }
        }
    }
}