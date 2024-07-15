package datastructures.DoublyLinkedList.WorkoutSolutions;

public class DLL {
    private Node head;
    private Node tail;
    private int length;



    class Node{
        int value;
        Node next;
        Node prev;
        Node(int value){
            this.value = value;
        }
    }



    public DLL(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //adds new things to the list//

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            length += 1;
        }
    }

    //prints the list//

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }



    public Node removeLast(){
        if(length == 0) {
            return null;
        }
        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }else {
            tail = tail.prev;
            temp.prev = null;
            tail.next = null;
        }
        length--;
        return temp;
    }



    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }



    public Node removeFirst(){
       Node temp = head;
       if(length == 0){
           return null;
       }else if(length == 1){
           head = null;
           tail = null;
       }else {
           head = head.next;
           head.prev = null;
           temp.next = null;
       }
       length--;
       return temp;
    }



    public Node get(int index){
      if(index>=length || index<0){
          return null;
      }
      Node temp = head;
      if(index<= length/2) {
          for (int i = 0; i < index; i++) {
              temp = temp.next;
          }
      }else {
          temp = tail;

          for (int i = length-1; i > index; i--) {
              System.out.print(i + " ");
              temp = temp.prev;
          }
          System.out.println();
      }
      return temp;
    }


    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }else{
            return false;
        }

    }


    /*public void insert(Node newNode, int index){
        Node prev = get(index - 1);
        if(prev != null) {
            newNode.next = prev.next;
            prev.next = newNode;
        }else{

        }
    }*/
    public boolean insert(int index, int value){
        if(index <0 || index>length) return false;
        if(index == 0){
            prepend(value);
            length++;
            return true;
        }
        if(index == length){
            append(value);
            length++;
            return true;
        }else {
            Node newNode = new Node(value);
            Node prev = get(index - 1);
            Node next = prev.next;
            newNode.next = next;
            next.prev = newNode;
            prev.next = newNode;
            newNode.prev = prev;
        }
        length++;
        return true;
    }



    public boolean remove(int index){
        if(index<0 || index>= length) return false;
        Node temp = head;
        if(index == 0){
            head = head.next;
            head.prev = null;
            temp.next = null;
            length--;
            return true;
        }
        if(index == length - 1){
            temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            length--;
            return true;
        }
        Node current = get(index);
        Node before = current.prev;
        Node after = current.next;
        before.next = after;
        after.prev = before;
        current.next = null;
        current.prev = null;
        length--;
        return true;

    }



    public void getHead(){
        System.out.println("Head: " + head.value);
    }
    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }
    public void getLength(){
        System.out.println("Length: " + length);
    }
}
