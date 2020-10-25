package KEVIN_NAUGHTON_JR.matrix;

/*
x..x
...x
...x

x - is battleship, count em all
 */
public class CountBattleShips {

    public static void main(String[] args) {
        String[][] board = {
                  {"x", ".", ".", "x"}
                , {".", ".", ".", "x"}
                , {".", ".", ".", "x"}
        };

        int numOfShips = countBattleshipsNoRecursion(board);
        System.out.println(numOfShips);
    }


    static int countBattleshipsNoRecursion(String[][] board) {
        int numberOfShips = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals(".")) {// . not ships -ignore
                    continue;
                }
                //we came from above as we traverse, so > 0 since we cannot come above zeros row
                if(row >0 && board[row-1][col].equals("x")){
                    continue;//ignore if coming from above and facing x
                }
                //we came from left as we traverse, so > 0 since we cannot come left to  zeros column
                if(col >0 && board[row][col-1].equals("x")){
                    continue;//ignore if coming from left and facing x
                }
                //here we only meet one essential X , all adjacent will be ignored in ifs above
                numberOfShips++;

            }

        }
        return numberOfShips;
    }

    static int countBattleships(String[][] board) {
        int numberOfShips = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals("x")) {
                    numberOfShips++;
                    sinkThisNAdSurroundingShips(board, row, col);//recusively check this and all 4 adjacent cells and sink ships
                }

            }

        }
        return numberOfShips;
    }

    private static void sinkThisNAdSurroundingShips(String[][] board, int row, int col) {
        if (row < 0 || row >= board.length //if row cells are out of bounds
                || col < 0 || col >= board[row].length //if column cells are aout of bounds
                || board[row][col] != "x") {//if cell val is not X

            return;//base case
        }


        board[row][col] = ".";//sink ship , not to check it againin on next traversal and avoid eternal loop

        //recursively check all adjacent rows and cols
        sinkThisNAdSurroundingShips(board, row + 1, col);//check row above
        sinkThisNAdSurroundingShips(board, row - 1, col);//check row below
        sinkThisNAdSurroundingShips(board, row, col + 1);//check column at right
        sinkThisNAdSurroundingShips(board, row, col - 1);//check column at left

    }
}
