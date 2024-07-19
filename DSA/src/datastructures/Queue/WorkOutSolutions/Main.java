package datastructures.Queue.WorkOutSolutions;

import datastructures.Queue.Queue;

public class Main {
    public static void main(String[] args){
        Queue newQ = new Queue(5);
        newQ.printQueue();
        System.out.println();
        newQ.enqueue(10);
        newQ.printQueue();
        System.out.println();
        newQ.enqueue(20);
        newQ.printQueue();
        System.out.println();
        newQ.enqueue(30);
        newQ.printQueue();
        System.out.println();
        newQ.dequeue();
        newQ.printQueue();
    }
}
