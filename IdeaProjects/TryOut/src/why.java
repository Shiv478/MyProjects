import java.util.*;
public class why {
    public static void main(String[] args) {
        System.out.println(recursiveExponent(3,4));
    }
    public static int recursiveExponent(int x, int n) {
        if(n == 1){
            return x;
        }
        return x * recursiveExponent(x,n-1);
    }
    public static void manipulateArray(int[] num){
        num[0] = 4;
    }
    static class Cool{
        String name;
        public Cool(String name){
            this.name = name;
        }
        public Cool(){
            this.name = "No Name";
        }
        public void printName(){
            System.out.println(this.name);
        }
    }
}
