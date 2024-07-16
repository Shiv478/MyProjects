package datastructures.DoublyLinkedList;

public class DLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node prev;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public DLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    public void swapFirstLast(){
        int num = 0;
        if(length >= 2){
            num = head.value;
            head.value = tail.value;
            tail.value = num;
        }

    }
    public void swap(Node N1, Node N2){
        Node temp = N1.prev;
        N1.prev = N1.next;
        N1.next = N2.next;
        if(N1.next!=null) {
            N1.next.prev = N1;
        }
        N2.next = N2.prev;
        N2.prev = temp;
        if(N2.prev != null) {
            N2.prev.next = N2;
        }
    }
    public boolean swapPairs(){
        Node P1S = head;
        Node P1E = P1S.next;
        if(length<2){
            return false;
        }else if(length == 2){
            swap(P1S,P1E);
            head = P1E;
            return true;
        }else if(length%2==0){

            //Made to keep the next node ready, for ability to traverse next list
            swap(P1S,P1E);
            //makes sure Linked List starts from the end of the second pair
            head = P1E;
            //System.out.println(P1S.value + " : Pair 1 Start");
            //System.out.println(P1E.value + " : Pair 2 Start");
            //System.out.println();
            P1S = P1S.next;
            P1E = P1S.next;
            // System.out.println(P1S.value + " : Pair 1 Start");
            //System.out.println(P1E.value + " : Pair 2 Start");
            swap(P1S,P1E);

            P1S = P1S.next;
            P1E = P1S.next;

            swap(P1S,P1E);


            /*for(int i = 0; i<iterations; i++){
                temp = P1E.next;
                swap(P1S,P1E);
                P1S.next = temp;
                temp.prev = P1S;
                P1S = P1S.next;
                P1E = P1S.next;
            }*/
            return true;
        }else{
            return true;
        }
    }

}




