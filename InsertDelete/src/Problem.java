//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;
public class Problem {
    private static Node head;

    private static class Node {
        private int data;
        private Node next;
        private int index;

        private Node(int data, int index) {
            this.data = data;
            this.next = null;
            this.index = index;
        }
        private String print(){
            return (data + " " + index);
        }
    }

    public static Node insert( int insertNumber, int beforeThisnum) {
        Node current = head;
        Node placeholder = null;
        int count = 0;
        if(head.data == beforeThisnum){
            Node numberAdd = new Node(insertNumber,2);
            numberAdd.next = head;
            head = numberAdd;
            return head;
        }
        while(current.next != null){
            if((current.next.data == beforeThisnum) && (count == 0)){
                placeholder = current.next;
                current.next = new Node(insertNumber, 15);
                current.next.next = placeholder;
                count++;
            }else{
                current = current.next;
            }
        }

        return head;
    }

    public static Node delete(int numberDelete) {
        Node current = head;
        int count = 0;
        if (head.data == numberDelete) {
            return head.next;
        }
        while (current.next.next != null) {
            if ((current.next.data == numberDelete) && (count == 0)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/shivvinodshankar/Documents/JavaFiles/InsertDelete/src/Input.rtf";
        File file = new File(path);
        Scanner input = new Scanner(file);
        Scanner scan = new Scanner(System.in);
        //Problem List = new Problem();

        //Node current;
        Node current = head = new Node(input.nextInt(), 0);
        int i = 1;
        while(input.hasNextInt()){
            int num = input.nextInt();
            current.next = new Node(num, i);
            System.out.print(current.next.print() + " ");
            current = current.next;
            i++;
        }
        System.out.println();
        current = head;
        while(current!= null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        Node insertedNode = insert(0,3);
        while(insertedNode != null){
            System.out.print(insertedNode.data + " ");
            insertedNode = insertedNode.next;
        }
        System.out.println();
        Node deleteNode = delete(6);
        while(deleteNode != null){
            System.out.print(deleteNode.data + " ");
            deleteNode = deleteNode.next;
        }









    }
}