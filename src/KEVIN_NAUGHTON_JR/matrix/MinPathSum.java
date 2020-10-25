package KEVIN_NAUGHTON_JR.matrix;

/*
given 2 D array find the min path sum to get to end ( bottom right row )
1 2 1
2 4 1
5 2 1

res = 1 + 2 + 1 + 1 + 1 = 6
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] matrix = new int [][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int minPathSum = minPathSum(matrix);
        System.out.println(minPathSum);
    }

    static int minPathSum(int [][] matrix){
        if(matrix == null || matrix.length ==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        //dynamic programming array - will store min path to get to current index
        int [][] dynamic_prog_array = new int[rows][cols];

        for (int row = 0; row < dynamic_prog_array.length; row++) {//traverse dynamic programm array
            for (int col = 0; col <  dynamic_prog_array[row].length; col++) {

                dynamic_prog_array[row][col]+= matrix[row][col];//initially populate with matrix value

                //recalculate to min path sum to get to current element index
                if(row > 0  && col > 0){//if comming from LEFT AND !!! from ABOVE

                    //choose MIN of two LEFT or ABOVE
                    dynamic_prog_array[row][col] += Math.min(dynamic_prog_array[row-1][col], dynamic_prog_array[row][col-1]);

                }else if( row > 0){//if coming from only  LEFT
                    dynamic_prog_array[row][col] += dynamic_prog_array[row-1][col];
                }else if(col > 0 ){//if coming from ONLY ABOVE
                    dynamic_prog_array[row][col] +=dynamic_prog_array[row][col-1];
                }
            }
        }
        //res is just value of dynamic programmin elemnt in needed cell, here needed is last cell, last row, last col
        return dynamic_prog_array[dynamic_prog_array.length-1][dynamic_prog_array[0].length-1];

    }
}
