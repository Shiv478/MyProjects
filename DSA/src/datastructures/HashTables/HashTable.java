package datastructures.HashTables;


public class HashTable {
    private int size = 7;
    private Node[] dataMap;
    public HashTable(){
        dataMap = new Node[size];
    }
    class Node{
        private String key;
        private int value;
        private Node next;
        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public void printHashTable(){
        for(int i = 0; i<size; i++){
            Node temp = dataMap[i];
            System.out.println(i + ": ");
            while(temp != null){
                System.out.print("{" + temp.key + " = " + temp.value + "} ");
                temp = temp.next;
            }
        }
    }

    public int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i<key.length(); i++){
            int asciNum = keyChars[i];
            hash  = (hash + asciNum * 26) % size;
        }
        System.out.println(hash);
        return hash;
    }
}