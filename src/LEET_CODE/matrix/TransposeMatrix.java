package LEET_CODE.matrix;

import java.util.Arrays;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},
                                     {4, 5, 6}};


        int[][] transposedResult = transposeMatrix(matrix);
        for( int [] each: transposedResult){
            System.out.println(Arrays.toString(each));
        }

    }



    static int[][] transposeMatrix(int[][] initialMatrix) {
        int rows = initialMatrix.length;
        int cols = initialMatrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transposedMatrix[col][row] = initialMatrix[row][col];
            }
        }

        return transposedMatrix;
    }
}
