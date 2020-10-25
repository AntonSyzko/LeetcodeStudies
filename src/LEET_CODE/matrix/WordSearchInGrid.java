package LEET_CODE.matrix;

/*

given grid of chars - letters find out if provided word can be  constructed of adjacent letters
only letters from UP DOWN, LEFT, RIGHT  ... NO diagonal

 */
public class WordSearchInGrid {

    public static void main(String[] args) {

        char[][] board = new char [][]{
                {'A','B','C'},
                {'D','B','F'},
                {'G','A','I'}
        };
        String word = "ABBA";

        boolean res = wordExistsInGrid(board, word);
        System.out.println(res);
    }

    //this to mark as already visited, since going UP DOWN RIGHT LEFT the ROW and COL not to check chars already checked
    static boolean visited[][];

    static boolean wordExistsInGrid(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        //borad of visited cells, speed up recursion, not to visit what jas been already visited
        visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {//traverse rows
            for (int col = 0; col < cols; col++) {//traverse cols
                if (word.charAt(0) == board[row][col] // start searching when first occurence of word start char  found in grid
                        && //AND
                        searchWord(row, col, 0, word, board)) {//rest of chars are there adjacently !!!
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(int row, int col, int indexInWord, String word, char[][] board) {
        if(indexInWord == word.length()){//if recursion moved index to = words length without throwing false - OK
            return true;//base case
        }

        if(row <0 //bounds - row does not go out of bord LEFT
                ||
                row >= board.length //bounds - row does not go out of bord RIGHT
                ||
                col < 0 //bounds - col does not go out of bord UP
                ||
                 col >= board[row].length //bounds - col does not go out of bord DOWN
                ||
                word.charAt(indexInWord) != board[row][col] // char at index DOES NOT EXISTS in board att all
                ||
                visited[row][col]) // if cell has already been visited (true )
        {
            return false;
        }


//this particular cell marked as visited, so that ROW and COLS going UP DOWN RIGHT LEFT not to check it- optimization
        visited[row][col]= true;


       // very recursice searches
        if(
                searchWord(row-1, col, indexInWord+1, word, board)//ROW at LEFT
        ||
        searchWord(row+1, col, indexInWord+1, word, board)//ROW at RIGHT
        ||
        searchWord(row, col-1, indexInWord+1, word, board)//COL at UP
        ||
        searchWord(row, col+1, indexInWord+1, word, board))
        {//COL DOWN
            return true;
        }

//mark back as not visited , since next char will be different and we will look again throughout entire board
        visited[row][col]=false;

        return false;
    }
}
