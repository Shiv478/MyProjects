package datastructures;

import java.util.*;

class LRUCache {
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Integer> hm = new HashMap<>();
    private int capacity = 0;
    private int removeNumber = 0;
    private int valueInt  = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hm.get(key) == null){
            return -1;
        }
        return hm.get(key);
    }

    public void put(int key, int value) {
        if(hm.size() == capacity){
            hm.remove(q.remove());
            removeNumber++;
            if(hm.containsKey(key)){
                hm.replace(key, value);
            }else{
                hm.put(key, valueInt);
                q.add(key);
                valueInt++;
            }

        }else{
            hm.put(key, valueInt);
            q.add(key);
            valueInt++;
        }
    }
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));   // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4

    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */