package datastructures.DoublyLinkedList.WorkoutSolutions;

public class Main {
    public static void main(String[] args){
        DLL myDll = new DLL(7);
        myDll.append(4);
        myDll.append(3);
        myDll.append(5);
        myDll.append(2);
        myDll.append(1);
        myDll.append(7);
        myDll.printList();
        myDll.remove(3);
        System.out.println();
        myDll.printList();
    }


}
