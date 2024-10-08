package datastructures.HashTables.LeetCodeQuestions;
import java.util.*;
public class L1 {
    /*public static Character firstNonRepeatingChar(String word){
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int i = 0; i<word.length()-1; i++){
            hm.put(word.charAt(i), word.charAt(i+1));
        }
        for(Map.Entry<Character, Character> entry: hm.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return null;
    }*/
    public static int[] twoSum(int[] numbers, int target){
        Map<int[], Integer> hm = new HashMap<>();
        for(int i = 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                hm.put(new int[]{i,j}, numbers[i] + numbers[j]);
            }
        }
        for(Map.Entry<int[], Integer> entry: hm.entrySet()){
            if(entry.getValue() == target){
                return entry.getKey();
            }
        }
        return null;

    }

    public static Character firstNonRepeatingChar(String word){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i<word.length(); i++){
            hm.put(word.charAt(i), hm.getOrDefault(word.charAt(i),0) + 1);
        }
        System.out.println(hm);
        for(int i = 0; i<word.length(); i++){
            if(hm.get(word.charAt(i)) == 1){
                System.out.println(hm.get(word.charAt(i)));
                return word.charAt(i);
            }
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }
}
