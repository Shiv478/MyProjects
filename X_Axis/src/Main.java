//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int ans = shortest_path(1,2,3);
        System.out.println(ans);
    }
    public static int shortest_path(int x1,int x2, int x3){
        int max = Math.max(x1,x2);
        max = Math.max(max, x3);
        int min = Math.min(x1,x2);
        min = Math.min(min, x3);
        return (max - min);
    }
}