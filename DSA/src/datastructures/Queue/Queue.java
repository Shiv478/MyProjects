package datastructures.Queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;
    class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public Queue(int value){
        first = new Node(value);
        last = first;
        length = 1;
    }
    public void printQueue(){
        if(length == 0){
            System.out.println("Queue is empty");
        }else {
            Node current = first;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
        }
    }

    public void enqueue(int value){
        last.next = new Node(value);
        last = last.next;
        length++;
    }
    public Node dequeue(){
        if(length == 0) return null;
        Node temp = first;
        first = first.next;
        temp.next = null;
        return temp; 
    }

}
