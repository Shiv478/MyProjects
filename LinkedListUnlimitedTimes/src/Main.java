import java.util.*;
public class Main {

    private ListNode head;
    private static class ListNode {

        private int data; //Generic Type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Main sll = new Main();
        int rep = 0;
        System.out.println("Please give me the number of elements you would like to add: ");
        if(input.hasNextInt()){
            rep = input.nextInt();
        }else{
            System.out.println("Invalid Response");
            System.exit(0);
        }
        //shiv
        ListNode current = null;
        for(int i = 0; i<rep; i++){
            if(i == 0) {
                System.out.println("What number are you adding: ");
                if(input.hasNextInt()) {
                    current = sll.head = new ListNode(input.nextInt());
                    System.out.println("1. " + current.data);
                }else{
                    System.out.println("Invalid Response");
                    System.exit(0);
                }
            }else {
                System.out.println("What number are you adding: ");
                System.out.println(current);
                if(input.hasNextInt()) {
                    current.next = new ListNode(input.nextInt());
                    current = current.next;
                    System.out.println("2. " + current.data);
                }else{
                    System.out.println("Invalid Response");
                }
            }
        }


        int i = 0;
        current = sll.head;


        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        current = sll.head;
        ListNode prev = null;
        current = sll.head; //5
        ListNode next = current.next; //10
        current.next = prev;
        while(next != null){
            prev = current;
            current = next;
            next = current.next;
            current.next = prev;
        }
        System.out.println();
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}