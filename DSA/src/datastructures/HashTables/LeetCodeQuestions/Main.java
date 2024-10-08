package datastructures.HashTables.LeetCodeQuestions;
import java.util.*;
public class Main {
    public static Boolean itemInCommon(int[] array1, int[] array2){
        HashMap<Integer, Boolean> newHM = new HashMap<Integer, Boolean>();
        for (int j : array1) {
            newHM.put(j, true);
        }

        for (int j : array2) {
            if (newHM.get(j) != null) {
                return newHM.get(j);
            }
        }

        return false;
    }
    public static int maxProfit(int[] prices) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<prices.length; i++){
            list.add(prices[i]);
        }
        System.out.println(list);
        int max = 0;
        for(int i = 0; i<prices.length - 1; i++){
            int purchasePrice = list.removeFirst();
            //System.out.println(Collections.max(list));
            int sellPrice = Collections.max(list);
            System.out.println("sell price: " + sellPrice + " " + "purchase price: " + purchasePrice);
            if(sellPrice - purchasePrice > max){
                max = sellPrice - purchasePrice;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        /*int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
        */ int[] array3 = {1, 5, 3, 4, 2};
        maxProfit(array3);
        //System.out.println(maxProfit(array3));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

    }
}
