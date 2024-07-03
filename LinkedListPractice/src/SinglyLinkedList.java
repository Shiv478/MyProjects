import java.util.ArrayList;

public class SinglyLinkedList{
    private ListNode head;
    private static class ListNode{
        private int data; //Generic Type
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){
        SinglyLinkedList s11 = new SinglyLinkedList();
        s11.head = new ListNode(20);
        ListNode second  = new ListNode(15);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(3);

        s11.head.next = second;
        second.next = third;
        third.next = fourth;

        ListNode current = s11.head;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        //System.out.print("null");
        // head --> 5 --> 10 --> 6 --> 4
        // 5 <-- 10 <-- 6 <-- 4

        ListNode prev = null;
        current = s11.head; //5
        ListNode next = current.next; //10
        current.next = prev;
        while(next != null){
            prev = current;
            current = next;
            next = current.next;
            current.next = prev;
        }

        s11.head = current;
        current = s11.head;
        System.out.println("");
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }





    }
}