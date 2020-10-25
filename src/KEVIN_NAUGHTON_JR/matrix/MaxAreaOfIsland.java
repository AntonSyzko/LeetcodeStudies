package KEVIN_NAUGHTON_JR.matrix;

/*
given a grid , find max area island

0 1 0 0
0 1 1 0
0 0 0 0
1 1 0 0

3 is max , counts in only vertical or horizontal . NO diagonal
 */

public class MaxAreaOfIsland {

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

    static int maxAreaOfIsland(int[][] matrix) {

        int max_area = 0;//res

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {//traverse rows
            for (int col = 0; col < cols; col++) {//traverse columns

                if (matrix[row][col] == 1) {//when found first ISLAND == 1
                    max_area = Math.max(max_area, DFS(matrix, row, col));
                }
            }
        }
        return max_area;
    }


    private static int DFS(int[][] matrix, int row, int col) {
        //bounds
        if (row < 0 // ABOVE row in bounds
                ||
                row >= matrix.length // below row in bounds
                ||
                col < 0 // column at left in bounds
                ||
                col >= matrix[row].length // column at right in bounds
                ||
                matrix[row][col] == 0) // if cell value IS  zero (0) - NOT an island
        {
            return 0;
        }

        //SINK this island for NOT TO COUNT for it afterwards, - it is already belonging to ISLAND
        matrix[row][col] = 0;


        int area_count = 1;//since we have checked for ZERO above , here is definitely island = 1

        area_count += DFS(matrix, row - 1, col);//check rows ABOVE
        area_count += DFS(matrix, row + 1, col);//check rows BELOW
        area_count += DFS(matrix, row, col - 1);//check COLUMS LEFT
        area_count += DFS(matrix, row, col + 1);//check colums RIGHT

        //shorter way
//        area_count =1+ DFS(matrix, row - 1, col) + DFS(matrix, row + 1, col) +
//                DFS(matrix, row, col - 1) + DFS(matrix, row, col + 1);

        return area_count;//return aggregated search SUM


        //shorter way
//        return DFS(matrix, row - 1, col) + DFS(matrix, row + 1, col) +
//                DFS(matrix, row, col - 1) + DFS(matrix, row, col + 1) +1;

    }
}

