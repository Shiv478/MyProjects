import java.util.*;
public class LinkedIntList {
    private static ListNode front;

    public static void main(String[] args) {
        LinkedIntList list1 = new LinkedIntList(3,8,4,2,1,7,5);
        //LinkedIntList list2 = new LinkedIntList(2, 12, 6, 54);
        front = expand(front);
        System.out.println(list1);

    }

    /* TODO: */
    // implement takeSmallerFrom() below
    private static ListNode expand(ListNode values){
         int repeat = front.data;
         front = front.next;
         values = front;
         int numRep = values.data;
         ListNode temp = values.next;
         for(int i = 1; i<repeat;i++){
             values.next = new ListNode(numRep);
             values = values.next;
         }
         values.next = temp;
         System.out.println(temp.data);
         System.out.println(values.data);
         while(values.next.next != null) {
             repeat = values.next.data;
             values.next = values.next.next;
             values = values.next;
             temp = values.next;
             numRep = values.data;
             for (int i = 1; i < repeat; i++) {
                 values.next = new ListNode(numRep);
                 values = values.next;
             }
             values.next = temp;
         }
         return front;
    }


    // Constructs a list containing the given elements
    public LinkedIntList(int... elements) {
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
        }
    }

    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    public String toString() {
        String res = "";
        ListNode curr = front;
        while (curr != null) {
            res += curr.data + " ";
            curr = curr.next;
        }
        return res;
    }

    private static class ListNode {
        public final int data;
        public ListNode next;

        public ListNode() {
            this(0, null);
        }

        public ListNode(int data) {
            this(data, null);
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
