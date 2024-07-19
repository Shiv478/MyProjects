package datastructures.Stacks.WorkoutSolutions;

import datastructures.Stacks.Stack;

public class Main {
    public static void main(String[] args){
        Stack ns = new Stack(4);
        ns.push(5);
        ns.printStack();
        ns.getHeight();
        ns.pop();
        ns.printStack();
    }
}
