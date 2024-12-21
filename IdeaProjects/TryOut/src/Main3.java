import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        ConnectFour board = new ConnectFour();
        System.out.println(board);
        while(board.getWinner() != -1 && board.getWinner() != 1 && board.getWinner() != 2) {
            Scanner scanner = new Scanner(System.in);
            try {
                board.makeMove(scanner);
            } catch (IllegalArgumentException ex) {
                System.out.println("**Illegal move: " + ex.getMessage());
            }
            System.out.println(board.toString());
        }
        System.out.println(board.getWinner());
    }
}
