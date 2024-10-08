package datastructures;
import java.util.*;
public class HashSet1 {

    // WRITE FINDPAIRS METHOD HERE //
    //                             //
    //                             //
    //                             //
    //                             //
    /////////////////////////////////
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> hs = new HashSet<>();
        List<int[]> al = new ArrayList<int[]>();
        int difference;
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        for (int i = 0; i < arr1.length; i++) {
            difference = target - arr1[i];
            if (hs.contains(difference)) {
                al.add(new int[]{difference, arr1[i]});
            }
        }
        return al;
    }
    public static int longestConsecutiveSequence(int[] nums){
        Set<Integer> hs = new HashSet<>();
        for(int value: nums){
            hs.add(value);
        }
        int max = 1;
        Boolean verdict = true;
        int count = 1;
        int next;
        for(int value: nums){
            next = value + 1;
            while(verdict == true){
                if(!hs.contains(next)){
                    verdict = false;
                }else{
                    count++;
                    next++;
                }
            }
            verdict = true;
            max = Math.max(count, max);
            count = 1;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        int[] arr3 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence(arr3));
        /*List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }*/
    }
}
        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

