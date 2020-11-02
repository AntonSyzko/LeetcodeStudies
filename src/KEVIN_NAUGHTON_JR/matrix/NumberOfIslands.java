package KEVIN_NAUGHTON_JR.matrix;

/*
given a grid of 1 and 0  - find number of islands,

1 1 1 0
1 1 0 0
1 0 0 0
0 0 1 0
0 0 0 0
0 0 1 1

3 islands , island is adjacent 1
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0'},
                {'1', '0', '0', '0'},
                {'1', '0', '1', '1'},
        };

        int islandsInGrid = numOfIslands(grid);
        System.out.println(islandsInGrid);

    }

    static int numOfIslands(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int result = 0;

        for (int row = 0; row < matrix.length; row++) {//traversing grid rows

            for (int col = 0; col < matrix[row].length; col++) {//traversing columns

                if (matrix[row][col] == '1') {//we count only 1
                    result += DFS(matrix, row, col);//recursively aggregate += adjacent occurences of '1'
                }
            }
        }

        return result;
    }

    private static int DFS(char[][] matrix, int row, int col) {

        if (row < 0 // going UP in  grid bounds
                || row >= matrix.length  // going DOWN in grid  bounds
                || col < 0 // going LEFT in grid bounds
                || col >= matrix[row].length // goind RIGHT in grid bounds
                || matrix[row][col] == '0') { // met '0' - ignore - not an island
            return 0;//ignore - won't be added to result
        }

// RESET current '1' to '0', kinda REMOVE from grid ( sink the island ) - not to count for this already met one if future recursions
        matrix[row][col] = '0';

        DFS(matrix, row - 1, col);//UP the  grid
        DFS(matrix, row + 1, col);//DOWN the grid
        DFS(matrix, row, col - 1);//LEFT the grid
        DFS(matrix, row, col + 1);//RIGHT the grid

        //one occurrence of '1' for current recursive call - will be added to result
        //covers sinking island ( marking current 1 to 0 )
        return 1;
    }
}
