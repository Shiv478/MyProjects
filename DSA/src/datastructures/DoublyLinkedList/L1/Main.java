package datastructures.DoublyLinkedList.L1;

public class Main {
    public static void main(String[] args){
        DLinkedList Dll = new DLinkedList(4);
        Dll.append(3);
        Dll.append(2);
        Dll.append(1);
        Dll.printList();
        Dll.swapFirstLast();
        System.out.println("-----------------------");
        Dll.printList();
    }
}
