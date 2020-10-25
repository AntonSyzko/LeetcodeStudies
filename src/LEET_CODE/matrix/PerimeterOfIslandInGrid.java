package LEET_CODE.matrix;

/*
given matrix of 0 and 1 , where 1 island and 0 is wasser
calculte  perimeter of an island
each land cell equals 4 units of perimeter
adjacent land cells don count
0 1 0 0
1 1 0 0
0 1 0 0

perimtere is 10 = 4 + 4 +4  - 2 - 2 + 4 - 2
 */
public class PerimeterOfIslandInGrid {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,0,0},
                {1,1,0,0},
                {0,1,0,0}
        };

        int perimeter = perimieterOfisland(grid);

        System.out.println(perimeter);
    }

    static int perimieterOfisland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {//base check
            return 0;
        }

        int perimeter = 0;//res

        for (int row = 0; row < grid.length; row++) {//traverse rows
            for (int col = 0; col < grid[row].length; col++) {//traverse cols

                if (grid[row][col] == 1) {//if current cell is land
                    perimeter += 4;//add to perimeter res

                    if (row > 0 && grid[row - 1][col] == 1) {//if cell  of row to the LEFT is 1
                        perimeter -= 2;//decrement by 2, since current and cell at LEFT will have  -1 in perimeter accordingly
                    }

                    if (col > 0 && grid[row][col - 1] == 1) {//if cell  of row to the ABOVE is 1
                        perimeter -= 2;//decrement by 2, since current and cell at ABOVE will have  -1 in perimeter accordingly
                    }
                }


            }
        }

        return perimeter;
    }
}
