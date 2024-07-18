package datastructures.Stacks.WorkoutSolutions;

import datastructures.Stacks.Stack;

public class Main {
    public static void main(String[] args){
        Stack ns = new Stack(4);
        ns.append(5);
        ns.append(3);
        ns.printStack();
        ns.getHeight();
        ns.getTop();
    }
}
