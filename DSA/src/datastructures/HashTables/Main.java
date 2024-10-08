package datastructures.HashTables;

public class Main {
    public static void main(String[] args){
        HashTable ht = new HashTable();
        ht.set("Why", 1000);
        ht.set("Bye", 2000);
        ht.set("Hello", 3000);
        ht.set("Kolavari", 4000);
        ht.set("Shiv", 5000);
        ht.printHashTable();
        System.out.println(ht.get("Shiv"));
        System.out.println(ht.keys());
    }
}
