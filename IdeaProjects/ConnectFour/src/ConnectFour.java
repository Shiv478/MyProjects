import java.util.*;
public class ConnectFour extends AbstractStrategyGame{
    private char[][] board;
    private Boolean isXTurn;
    public ConnectFour(){
        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_'}
        };
        isXTurn = true;
    }
    @Override
    public String instructions() {
        String instructions = "Player 1 Starts:\n" +
                "Player 1 is assigned the disc 'X'.\n" +
                "Player 2 is assigned the disc 'O'.\n\n" +
                "Players Take Turns:\n" +
                "On each turn, the current player selects a column to drop their disc.\n" +
                "THE COLUMN OPTIONS ARE 1 - 7 \n" +
                "The disc falls to the lowest available row within the selected column.\n\n" +
                "Valid Moves:\n" +
                "A move is valid only if the chosen column is not full.\n" +
                "If the column is full, the player must choose another column.\n\n" +
                "Winning Conditions:\n" +
                "Horizontally: Four discs in a row, side by side.\n" +
                "Vertically: Four discs in a column, one on top of another.\n" +
                "Diagonally: Four discs connected diagonally (either from bottom-left to top-right or bottom-right to top-left).\n";
        return instructions;

    }
    //Behavior: prints out the ConnectFour playing Board
    //Exceptions: None
    //Return: a big string
    //Parameters: None
    @Override
    public String toString() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String str = "_____________________________";
        str += "\n";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X'){
                    str += "| " + ANSI_RED + board[i][j] + ANSI_RESET + " ";
                }else if(board[i][j] == 'O'){
                    str += "| " + ANSI_GREEN + board[i][j] + ANSI_RESET + " ";
                }else{
                    str += "| " + board[i][j] + " ";
                }
            }
            str += "|";
            str += "\n";
        }
        str += "| 1 | 2 | 3 | 4 | 5 | 6 | 7 |";
        return str;
    }
    //Behavior: checks for a winner in the game by checking all conditions for a win
    //Exceptions: None
    //Return: a number for the winner (), a tie,
    //Parameters: None
    @Override
    public int getWinner() {
        for(int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
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
                    return -1;
                }
            }
        }
        return 0;
    }
    //Behavior: Return the player number
    //Exception: if the game finishes then it returns -1 for a tie
    //Return: returns integer
    //Parameter: None
    @Override
    public int getNextPlayer() {
        if (isGameOver()) {
            return -1;
        }
        return isXTurn ? 1 : 2;
    }
    //Behavior: takes in a column and adds it to the board. Column inputted with scanner is one
    //          more than where it will be placed in column
    //Exception: if column inputted is less than 1 or greater 7
    //Return: None
    //Parameter: input to get players moves
    @Override
    public void makeMove(Scanner input) {
        char turn = isXTurn ? 'X' : 'O';
        System.out.print("Enter column: ");
        int column = input.nextInt();
        column --;
        if(column > board.length || column < 0){
            throw new IllegalArgumentException("Invalid board position: " + (column + 1));
        }
        int row = -1;
        for(int i = board.length - 1; i >= 0; i--){
            if(board[i][column] == '_'){
                row = i;
                i = -1;
            }
        }
        makeMove(row,column, turn);
        isXTurn = !isXTurn;
    }
    //Behavior: takes in row and column and checks if row is valid
    //Exception:  if row is between 0 - 5
    //Return: None
    //Parameter: the row, column, and player making the move are the parameters

    //
    private void makeMove(int row, int col, char player) {
        if (row < 0 /*|| row >= board.length || col < 0 || col >= board[0].length*/) {
            throw new IllegalArgumentException("Invalid board position in column: " + (col + 1));
        }

        if (board[row][col] != '_') {
            throw new IllegalArgumentException("Space already occupied: " + row + "," + col);
        }
        board[row][col] = player;
    }
}
