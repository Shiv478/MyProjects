package datastructures.DoublyLinkedList.D2;

import datastructures.DoublyLinkedList.DLinkedList;

public class Main {
    public static void main(String[] args){
        DLinkedList dll = new DLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.printList();
        System.out.println();
        dll.swapPairs();
        dll.printList();
    }
}
