import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String[][] arr = new String[5][5];
        arr[0] = new String[]{".", ".", "#", ".", "."};
        arr[1] = new String[]{".", "#", "#", "#", "."};
        arr[2] = new String[]{"#", "#", "#", "#", "#"};
        arr[3] = new String[]{".", "#", "#", "#", "."};
        arr[4] = new String[]{".", ".", "#", ".", "."};

        for(int i = 0; i<5; i++){
            for(int j =0; j<5; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println(Manhattancircle(5,5,arr));
    }
    public static String Manhattancircle(int n, int m, String[][] arr){

        PointLocation[] group = new PointLocation[n*m];
        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j].equalsIgnoreCase("#")) {
                    System.out.println(i + " " + j);
                    group[count] = new PointLocation(i, j);
                    count++;
                }
            }
        }
        if(count == 1){
            return group[0].toString();
        }
        int maxX = 0;
        int maxY = 0;
        int minX = n*m;
        int minY = n*m;

        for(int i = 0; i<count; i++){
            System.out.println(group[i]);
            maxX = Math.max(group[i].getX(),maxX);
            minX = Math.min(group[i].getX(), minX);
            maxY = Math.max(group[i].getY(),maxY);
            minY = Math.min(group[i].getY(), minY);
            System.out.println(maxX + " " + minX + " " + maxY + " " + minY);
        }

        int middle_x = (maxX+minX)/2;
        int middle_y = (maxY+minY)/2;
        return (middle_x + " " + middle_y);

    }
}
class PointLocation {
    private final int x_coordinate;
    private final int y_coordinate;
    PointLocation(int x, int y){
        this.x_coordinate = x;
        this.y_coordinate = y;
    }

    int getX(){
        return this.x_coordinate;
    }
    int getY(){
        return this.y_coordinate;
    }
    public String toString(){
        return this.x_coordinate + " " + this.y_coordinate;
    }


}