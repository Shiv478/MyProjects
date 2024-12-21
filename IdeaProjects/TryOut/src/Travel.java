import java.util.*;

public class Travel {
    public static void travel(int x, int y) {
        // TODO: Your code here
        travel(x,y,new ArrayList<String>());
    }

    private static void travel(int x, int y, List<String> list){
        if((x == 0 && y == 0)){
            System.out.println(list);
        }
        else{
            if(x>=0 && y>=0) {
                list.add("E");
                travel(x - 1, y, list);
                list.removeLast();
                list.add("N");
                travel(x, y - 1, list);
                list.removeLast();
                list.add("NE");
                travel(x - 1, y - 1, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        travel(1, 2);
    }
}
