package LEET_CODE.matrix;

/*
given a grid , find max area island

0 1 0 0
0 1 1 0
0 0 0 0
1 1 0 0

3 is max , counts in only vertical or horizontal . NO diagonal
 */
public class MaxAreaOfIslands {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0}
        };

        int maxAreaInGrid = maxAreaOfIsland(grid);
        System.out.println(maxAreaInGrid);
    }


    //cells to mark as seen , for recursion not to stack overflow, since visiting previously visited cells
    //while going LEFT RIGHT UP DOWN the grid
    static boolean seenAlreadyCells[][];



    static int maxAreaOfIsland(int[][] grid) {

        int max_area = 0;//res

        int rows = grid.length;
        int cols = grid[0].length;


//cells to mark as seen , for recursion not to stack overflow, since visiting previously visited cells
        //while going LEFT RIGHT UP DOWN the grid
        seenAlreadyCells = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {//traverse rows
            for (int col = 0; col < cols; col++) {//traverse cols

                max_area = Math.max(max_area, getArea(row, col, grid));//max of current max and current ongoing

            }
        }

        return max_area;
    }

    private static int getArea(int row, int col, int[][] grid) {

        if (row < 0 //if rows in boung going UP
                ||
                row >= grid.length // rows in bound going DOWN
                ||
                col < 0 // colum in bound going LEFT
                ||
                col >= grid[row].length // column in bound going RIGHT
                ||
                grid[row][col] == 0 // if current cell value is ZERO - is not what we want
                ||
                seenAlreadyCells[row][col])//if already checked ( so vas visited and did not count in )
        {
                         return 0;
        }


//mark as visited - so it's belonging to some ISLAND ALREADY OR WAS ZERO(0) AND WE SHOULD NOT CARE
        seenAlreadyCells[row][col] = true;

        //recursive calls
        return (1 + // since checked if values is zero (0) above - this cell is definitely 1
                getArea(row - 1, col, grid) + // row above
                getArea(row + 1, col, grid) +  // row below
                getArea(row, col - 1, grid) +  // column at left
                getArea(row, col + 1, grid)    // column at right
        );
    }
}
