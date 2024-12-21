import java.util.*;
public class tryOut {
    public static void main(String[] args) {
        int rows = 80, columns = 5;
        int[][] marks = new int[rows][columns];

        // initializing the array elements using for loop
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                marks[i][j] = i + j;
            }
        }

        // printing the first three rows of marks array
        System.out.println("First three rows are: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf(marks[i][j] + " ");
            }
            System.out.println();
        }
        List<Integer> list = spiralOrder(marks);
        System.out.println(list.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int x = 0;
        int y = 0;
        int ycount = matrix.length;
        int xcount = matrix[0].length;
        System.out.println(xcount + " " + ycount);
        while (list.size() < matrix[0].length * matrix.length) {
            //add all x's
            //for loop for going down y values at fixed x
            //add all x's at y - level
            //add all x's at y - level
            if (i % 4 == 0) {
                for (int j = 0; j < xcount - 1; x++, j++) {
                    list.add(matrix[y][x]);
                }
                System.out.println(x);
                y++;
                xcount--;
                ycount--;
            } else if (i % 4 == 1) {
                System.out.println(x + " " + y);
                System.out.println(ycount);
                for (int j = 0; j < ycount - 1; y++, j++) {
                    System.out.println(x + y);
                    list.add(matrix[y][x]);
                }
                x--;
                ycount--;
            } else if (i % 4 == 2) {
                for (int j = 0; j < xcount - 1; x--, j++) {
                    list.add(matrix[y][x]);
                }
                y--;
                xcount--;
                ycount--;
            } else {
                for (int j = 0; j < ycount - 1; y--, j++) {
                    list.add(matrix[y][x]);
                }
                x++;
                ycount--;
            }
            i++;
        }
        return list;

    }
}

