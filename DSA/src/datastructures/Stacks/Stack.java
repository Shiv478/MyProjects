package datastructures.Stacks;

class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
}
public class Stack{
    private Node top;
    private int height;
    public Stack(int top){
        this.top = new Node(top);
        height = 1;
    }
    public void printStack(){
        System.out.println("_________");
        Node current = top;
        while(current != null){
            //System.out.println(current.value);
            System.out.println("|   " + current.value +  "   |");
            System.out.println("---------");
            current = current.next;
        }

    }
    public void append(int value){
        Node newTop = new Node(value);
        if(height == 0){
            top = newTop;
        }
        newTop.next = top;
        top = newTop;
    }

    public void getTop(){
        System.out.println(top.value);
    }
    public void getHeight(){
        System.out.println(height);
    }


}
