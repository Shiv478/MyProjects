import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*BinaryTree bt = new BinaryTree(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(3);
        bt.insert(8);

        bt.getNode(8);*/
        //System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
        //System.out.println(majorityElement(new int[]{3,3,4}));
        /*ListNode list1 = new ListNode(-9);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);
        ListNode head = mergeTwoLists(list1, list2);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }*/
        //System.out.println(isSubsequence("b", "abc"));
        System.out.println(longestCommonPrefix(new String[]{"flower", "floppy", "flow"}));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }else if(t.length() == 0){
            return false;
        }
        if(s.length() <= t.length()){
            int j = 0;
            for(int i = 0; i<t.length() && j<s.length(); i++){
                System.out.print(j);
                if(s.charAt(j) == (t.charAt(i))){
                    j++;
                }
            }
            if(j == s.length()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public static String longestCommonPrefix(String[] strs) {
        String common = "";
        Boolean valid = true;
        char letter;
        int j= 0;;
        while(valid){
            System.out.println(j);
            letter = strs[0].charAt(j);
            for(int i = 1; i<strs.length; i++){
                if(strs[i].charAt(j) != letter){
                    valid = false;
                    break;
                }
            }
            if(valid){
                common += letter;
            }
            j++;
        }
        return common;
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        if(pointer1 == null){
            return list2;
        }else if(pointer2 == null){
            return list1;
        }
        while(pointer1 != null && pointer2 != null){
            if(pointer1.val < pointer2.val){
                System.out.print(pointer1.val + " ");
                temp.next = new ListNode(pointer1.val);
                temp = temp.next;
                pointer1 = pointer1.next;
            }else if(pointer1.val >= pointer2.val){
                System.out.print(pointer2.val + " ");
                temp.next = new ListNode(pointer2.val);
                temp = temp.next;
                pointer2 = pointer2.next;
            }
        }
        if(pointer1 == null){
            System.out.print("pointer1 is null ");
            while(pointer2 != null){
                //System.out.println(pointer2.val + " ");
                temp.next = new ListNode(pointer2.val);
                temp = temp.next;
                pointer2 = pointer2.next;
            }
        }else if(pointer2 == null){
            System.out.print("pointer2 is null ");
            while(pointer1 != null){
                temp.next = new ListNode(pointer1.val);
                pointer1 = pointer1.next;
            }
        }
        System.out.println();
        return head.next;
    }

    public static Boolean backspaceCompare(String s, String t) {
        String cutS = "";
        int hashTagBank = 0;
        for(int i =s.length() - 1; i>= 0; i--){
            if(s.charAt(i) == '#'){
                hashTagBank++;
            }
            else if(hashTagBank == 0){
                cutS += s.charAt(i);
            }else{
                hashTagBank--;
            }


        }
        String cutT = "";
        int hashTagBank2 = 0;
        for(int i =t.length() - 1; i>= 0; i--){
            if(t.charAt(i) == '#'){
                hashTagBank2++;
            }
            else if(hashTagBank2 == 0){
                cutT += t.charAt(i);
            }else{
                hashTagBank2--;
            }
        }
        System.out.println(cutS);
        System.out.println(cutT);
        if(cutS.equals(cutT)){
            return true;
        }
        return false;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int j : nums) {
            hm.put(j, hm.getOrDefault(j, 0) + 1);
        }
        int max = 0;
        int num = 0;
        for(int amount: hm.keySet()){
            System.out.println(amount + " " + hm.get(amount));
            if(hm.get(amount) > max){
                max = hm.get(amount);
                num = amount;
            }
        }
        return num;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        String sortedWord;
        for(int i = 0; i<strs.length; i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            sortedWord = new String(array);
            hm.put(sortedWord, hm.getOrDefault(sortedWord, new ArrayList<>()));
            hm.get(sortedWord).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }

}
