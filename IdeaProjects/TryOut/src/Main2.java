import java.util.*;
public class Main2 {
    public ListNode front;
    public static void main(String[] args){
        int [] arr = new int[]{0,1,1,1,1,0,0,2,3,5,1,0,2};
        System.out.println(randomProduct(arr, 2));
    }

    public static int randomProduct(int[] arr, int n) {
        // Your code here!
        return subGenerator(arr,n, new ArrayList<Integer>(), 0);
    }
    private static int subGenerator(int[] arr, int n, List<Integer> newList, int count){
        if(newList.size() == n || (newList.size()<n && count == arr.length)){
            int product = 1;
            for (Integer integer : newList) {
                product *= integer;
            }
            return product;
        }
        int product1 = subGenerator(arr,n,new ArrayList<>(newList), count+1);
        newList.add(arr[count]);
        int product2 = subGenerator(arr,n,new ArrayList<>(newList), count+1);
        //newList.remove(newList.size()-1);

        return Math.max(product1,product2);
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this(x, null);
        }
        ListNode(int x, ListNode next){
            val = x;
            this.next = next;
        }
    }
}
