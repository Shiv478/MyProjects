package datastructures.BinaryTrees;

public class Main {
    public static void main(String[] args){
        BinaryTrees bt = new BinaryTrees();
        System.out.println(bt.insert(47));
        bt.insert(21);
        bt.insert(76);
        bt.insert(18);
        bt.insert(27);
        bt.insert(52);
        bt.insert(82);
        bt.printRoot();
        System.out.println();
        System.out.println(bt.contains(27));
        System.out.println(bt.contains(100));
    }
}
