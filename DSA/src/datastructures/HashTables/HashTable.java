package datastructures.HashTables;


import java.util.ArrayList;

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
    public void set(String key, int value){
        int location = hash(key);
        Node current = dataMap[location];
        if(current == null){
            dataMap[location] = new Node(key, value);
        }else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(key, value);
        }
    }

    public int get(String key){
        int location = hash(key);
        if(dataMap[location] == null){
            return 0;
        }
        else{
            Node current = dataMap[location];
            while(current != null){
                if(current.key.equalsIgnoreCase(key)){
                    return current.value;
                }
                current = current.next;
            }
        }
        return 0;
    }
    public void printHashTable(){
        for(int i = 0; i<size; i++){
            Node temp = dataMap[i];
            System.out.print(i + ": ");
            while(temp != null){
                System.out.print("{" + temp.key + " = " + temp.value + "} ");
                temp = temp.next;
            }
            System.out.println();
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
    public ArrayList<String> keys(){
        ArrayList<String> keys = new ArrayList<>();
        for(int i = 0; i<size; i++){
            Node temp = dataMap[i];
            while(temp != null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }
}