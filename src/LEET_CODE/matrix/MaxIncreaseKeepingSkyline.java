package LEET_CODE.matrix;

/*
given grid of heigths of buildings
you may increase each building
but keep the skyline of the city, means max in row and max in colums stays same
solutio - increase by what is diff between current max row or max col - current heigth

grid is square
 */
public class MaxIncreaseKeepingSkyline {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 3},
                {2, 3, 1},
                {0, 2, 4}
        };

        int maxIncerse = maxIncrease(grid);
        System.out.println(maxIncerse);
    }


    static int maxIncrease(int[][] grid) {
        int res = 0;
        int grid_len = grid.length;

        int[] max_row_val = new int[grid_len];
        int[] max_col_val = new int[grid_len];

        for (int row = 0; row < grid_len; row++) {
            for (int col = 0; col < grid_len; col++) {

                max_row_val[row] = Math.max(max_row_val[row], grid[row][col]);
                max_col_val[col] = Math.max(max_col_val[col], grid[row][col]);
            }
        }

        
        for (int row = 0; row < grid_len; row++) {
            for (int col = 0; col < grid_len; col++) {

                res += Math.min(max_row_val[row], max_col_val[col]) - grid[row][col];
            }
        }

        return res;
    }
}
