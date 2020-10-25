package KEVIN_NAUGHTON_JR.matrix;

/*
given grid params , robot can move only down and right
find num of unique path to get from top left to down right corner
start - since 1 way to get to cell at right  or down, left or up at first row and col per se

dynamic programming - store in each cell max steps to get to it, last is your answer
1 1 1
1 0 0
1 0 0

1 1 1
1 2 3
1 3 6
 */
public class UniquePaths {

    public static void main(String[] args) {
        int uniqs = uniquePaths(3, 3);
        System.out.println(uniqs);
    }

    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //since there is ONLY 1 way to get to ROW at UP or DOWN to given in first row
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;//fill ALL first ROWS with 1
        }
        //since there is ONLY 1 way to get to COL at right or left to given in fist COL
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;//fill ALL first COLS with 1
        }

        //diagonals are sum of row ABOVE + col LEFT
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {

                dp[row][col] =
                        dp[row - 1][col] // row ABOVE
                                +        // and
                                dp[row][col - 1];//COL at left
            }
        }

        return dp[m - 1][n - 1];
    }
}
