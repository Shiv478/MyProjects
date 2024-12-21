import java.util.ArrayList;
import java.util.Set;

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
    public void removeAll(Set<Integer> set){
        ListNode curr = head;
        if(set.contains(curr.data)){
            head = head.next;
        }
        while(curr != null){
            if(set.contains(curr.next.data)){
                curr.next = curr.next.next;
            }
        }
    }
    public static void main(String[] args){
        SinglyLinkedList s11 = new SinglyLinkedList();
        s11.head = new ListNode(1);
        s11.head.next = new ListNode(2);
        s11.head.next.next = new ListNode(3);
        s11.head.next.next.next = new ListNode(4);
        s11.head.next.next.next.next = new ListNode(5);
        s11.head.next.next.next.next.next = new ListNode(6);
        s11.head.next.next.next.next.next.next = new ListNode(7);
        s11.head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode curr = s11.head;
        if(curr.data == 1){
            s11.head = curr.next;
        }
        while(curr.next != null){
            if(curr.next.data == 1){
                curr.next = curr.next.next;
                System.out.println("Found");
            }else {
                curr = curr.next;
            }
        }
        curr = s11.head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }





    }
}