package datastructures.Pointers;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        map1.put("value", 11);
        map2 = map1;
        map1.put("Girrafe", 15);
        map2.put("value", 12);
        System.out.println(map1);
        System.out.println(map2);
    }

}
