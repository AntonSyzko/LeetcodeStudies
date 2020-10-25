package HACKER_RANK.matrix;

public class ConnectedCells {
    public static void main(String[] args) {
      int[][] matrix = new int [][]{
              {1,1,0,0},
              {1,0,0,0},
              {0,0,1,1},
              {1,0,1,1}
      };
      int maxRegionSize = getBiggestRegion(matrix);
        System.out.println(maxRegionSize);
    }

    static int getBiggestRegion(int[][] matrix) {
        int maxRegion = 0;//init res

        /* may use boolen matrix for already checked
        int rows = matrix.length;
        int columns = matrix[rows].length;
        boolean[][] alreadyChecked = new boolean[rows][columns];
         */

        for (int row = 0; row < matrix.length; row++) {//taverse
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==1){//cells with 1
                    int currentRegionSize = getCurrentRegionSize(matrix, row, col);//each cell check
                    maxRegion = Math.max(currentRegionSize, maxRegion);
                }
            }
        }
        return maxRegion;
    }

    //DFS
    private static int getCurrentRegionSize(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {//boundaries, base case
            return 0;
        }

        if (matrix[row][col] == 0){//zeros ignored
            return 0;
        }

        //mark current as 0 - not to check in next iterations (mind size = 1 below) will cover current
        matrix[row][col] = 0;//boolean array may be used insted if not willing to modify original array
        int size=1;//size for current is 1

        for (int currentRow = row -1; currentRow <= row+1 ; currentRow++) {//adjacent rows above to cuur and below
            for (int currentCol = col-1; currentCol <= col +1; currentCol++) {//adjacent col up left and right
                if(currentRow != row || currentCol != col){//don't count itself (may omit - but faster)
                    size += getCurrentRegionSize(matrix, currentRow, currentCol);//recursion
                }
            }
        }
        return size;
    }
}
