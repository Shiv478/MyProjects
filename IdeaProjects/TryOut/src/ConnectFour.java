import java.util.Scanner;
/*/////////////////////////////////////////////////////////////////
    MAKE SURE TO JUST CHECK WHETHER THERE IS A WIN IN THE SOUTH WEST, SOUTH, SOUTH EAST, AND EAST
    THIS IS BECAUSE THE OTHER DIRECTIONS ARE JUST OPPOSITES IN THE SAME LINE
*//////////////////////////////////////////////////////////////////
public class ConnectFour{
    private char[][] board;
    private Boolean XTurn;
    public ConnectFour(){
        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'}
        };
        XTurn = true;
    }

    public String instructions() {
        return "";
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                str += " " + board[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    public int getWinner() {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                //char pointer = board[i][j];
                /*if((i+3) < board.length){
                    //CHECKS THE WEST AREA
                    if((j-3)>=0){
                        //CHECK SOUTH WEST
                        if((board[i + 1][j - 1] == board[i + 2][j - 2]) && (board[i + 1][j - 1] == board[i + 3][j - 3]) && (board[i + 1][j - 1] != '_')){
                            return board[i][j] == 'X' ? 1 : 2;
                        }
                    }
                    //CHECK SOUTH
                    if((board[i + 1][j] == board[i + 2][j]) && (board[i + 2][j] == board[i + 3][j]) && (board[i + 1][j] != '_')){
                        System.out.println("Happened");
                        return board[i][j] == 'X' ? 1 : 2;
                    }
                    //CHECKS EAST AREA
                    if((j+3) < board.length){
                        //CHECK SOUTH EAST
                        if((i+3) < board.length){
                            if((board[i+1][j+1] == board[i+2][j+2]) && (board[i+2][j+2] == board[i+3][j+3]) && (board[i+3][j+3] != '_')){
                                return board[i][j] == 'X' ? 1 : 2;
                            }
                        }
                    }
                }
                //CHECK EAST
                if((j+3) < board.length){
                    if((board[i][j+1] == board[i][j+2]) && (board[i][j+2] == board[i][j+3]) && (board[i][j+3] != '_')){
                        return board[i][j] == 'X' ? 1 : 2;
                    }
                }
                */
                //CHECK SOUTH EAST
                if((i+3) < board.length && j+3 < board.length){
                    if((board[i+1][j+1] == board[i+2][j+2]) && (board[i+2][j+2] == board[i+3][j+3]) && (board[i][j] == board[i+1][j+1]) && (board[i+3][j+3] != '_')){
                        return board[i][j] == 'X' ? 1 : 2;
                    }
                }
                //CHECK SOUTH
                if((i+3) < board.length){
                    if((board[i + 1][j] == board[i + 2][j]) && (board[i + 2][j] == board[i + 3][j]) && (board[i][j] == board[i+3][j]) && (board[i + 1][j] != '_')){
                        return board[i][j] == 'X' ? 1 : 2;
                    }
                }
                //CHECK SOUTH WEST
                if((i+3)<board.length && (j-3) >= 0){
                    if((board[i+1][j-1] == board[i+2][j-2]) && (board[i+1][j-1] == board[i+3][j-3]) && (board[i][j] == board[i+1][j-1]) && (board[i+1][j-1] != '_')){
                        return board[i][j] == 'X' ? 1 : 2;
                    }
                }
                //CHECK EAST
                if(j+3 < board.length){
                    if((board[i][j+1] == board[i][j+2]) && (board[i][j+2] == board[i][j+3]) && (board[i][j] == board[i][j+1]) && (board[i][j+3] != '_')){
                        return board[i][j] == 'X' ? 1 : 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '_') {
                    // unfilled space; game not over
                    return 0;
                }
            }
        }
        return -1;
    }

    public int getNextPlayer() {
        return 0;
    }
    public void makeMove(Scanner input) {
        char turn = XTurn ? 'X' : 'O';
        System.out.print("Enter column: ");
        int column = input.nextInt();
        int row = -1;
        for(int i = board.length - 1; i >= 0; i--){
            if(board[i][column] == '_'){
                row = i;
                i = -1;
            }
        }
        makeMove(row,column, turn);
        XTurn = !XTurn;
    }
    private void makeMove(int row, int col, char player) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            throw new IllegalArgumentException("Invalid board position: ," + col);
        }

        if (board[row][col] != '_') {
            throw new IllegalArgumentException("Space already occupied: " + row + "," + col);
        }
        board[row][col] = player;
    }
}
