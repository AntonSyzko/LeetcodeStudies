package KEVIN_NAUGHTON_JR.matrix;

/*
given matrix of letters , find if given word can be constructed
word can be  constructed if any adjacent cells ( horizontally or vertically ) which  are next to letter
contain the letter needed
lettrs ca NOT be used more than once

 */
public class WordSearchInMatrix {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a','b','c'},
                {'d','e','f'},
                {'x','y','z'}
        };
        String word = "deyz";//true
        boolean wordFound = wordExistsInGrid(board, word);
        System.out.println(wordFound);

        word="abet";//false
        wordFound = wordExistsInGrid(board, word);
        System.out.println(wordFound);


    }

    static boolean wordExistsInGrid(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0) //if fist char of word met in grid
                        && dfs(board, row, column, 0, word)) {//and DFS given true
                    return true;
                }
            }
        }
        return false;//got here - not found

    }

    private static boolean dfs(char[][] board, int row, int column, int count_of_checked_letter, String word) {
        //if count reached end of word length - all letters checked , no need to go on
        if (count_of_checked_letter == word.length()) {
            return true;
        }

        if (row < 0 //if going up - out of board
                || row >= board.length //if goind down out of grid
                || column < 0 //if goind left out of grid
                || column >= board[row].length // if goig right out of grid
                || board[row][column] != word.charAt(count_of_checked_letter)) {//if char at this position != next char in word
            return false;
        }

        char temp_to_use_char_once = board[row][column];//each char can be used ONLY once -
        board[row][column] = ' ';//so for this current - mark as ' ' not to use in further DFS

        //recursively check each adjacent row and column, increasing count for lettrs in word, to get NEXT letter of word each iteration
        boolean found = dfs(board, row + 1, column, count_of_checked_letter +1, word)//check next above
                ||
                dfs(board, row - 1, column, count_of_checked_letter+1, word)//check next below
                ||
                dfs(board, row, column + 1, count_of_checked_letter+1, word)//check next left
                ||
                dfs(board, row, column - 1, count_of_checked_letter+1, word);//check next right


        board[row][column] = temp_to_use_char_once;//bring back the ONLY ONCE char tem to passed vars

        return found;
    }
}
