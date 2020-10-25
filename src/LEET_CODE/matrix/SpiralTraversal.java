package LEET_CODE.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{1,2,3},
                                        {4,5,6},
                                         {7,8,9}
        };

        List<Integer> res = spiralTraversal(matrix);
        System.out.println(res);
    }


    static List<Integer> spiralTraversal(int [][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;

        //boundaries
        int rowBegin = 0;
        int rowEnd   = matrix.length-1;
        int colBegin = 0;
        int colEnd   = matrix[0].length-1;

        while (rowBegin <= rowEnd && colBegin <= colEnd){//limits

            for (int col = colBegin; col <= colEnd; col++) {//traverse row ( but indexes are of columns)
                res.add(matrix[rowBegin][col]);//so from this row - but columns indexes
            }
            rowBegin++;//level not neded anymore , move row

            for (int row = rowBegin; row <=rowEnd ; row++) {//traverse column but indexes are of rows
                res.add(matrix[row][colEnd]);
            }
            colEnd--;//shrink column - not needed levele anymore

            if(rowBegin <= rowEnd ){//double check - since ve have modified rowBegin before
                for (int col = colEnd; col >= colBegin ; col--) {//traverse row but column indexes
                    res.add(matrix[rowEnd][col]);
                }
            }
            rowEnd--;//move row

            if(colBegin <= colEnd){// double check since we  have modified the colEnd  before
                for (int row = rowEnd; row >= rowBegin ; row--) {//traverse cols but row indexes
                    res.add(matrix[row][colBegin]);
                }
            }
            colBegin++;//shrink col
        }

        return res;
    }

    //here matrix is square
    static int [][] spiralTraversalFillWithNs(int matrix_size){
        int [][] resMatrix = new int [matrix_size][matrix_size];
        if(matrix_size == 0) return resMatrix;

        //boundaries
        int rowBegin = 0;
        int rowEnd   = resMatrix.length-1;
        int colBegin = 0;
        int colEnd   = resMatrix[0].length-1;

        int fill_inCounter = 0;

        while (rowBegin <= rowEnd && colBegin <= colEnd){//limits

            for (int col = colBegin; col <= colEnd; col++) {//traverse row ( but indexes are of columns)
                resMatrix[rowBegin][col] = fill_inCounter++;//so from this row - but columns indexes
            }
            rowBegin++;//level not neded anymore , move row

            for (int row = rowBegin; row <=rowEnd ; row++) {//traverse column but indexes are of rows
                resMatrix[row][colEnd]= fill_inCounter++;
            }
            colEnd--;//shrink column - not needed levele anymore

            if(rowBegin <= rowEnd ){//double check - since ve have modified rowBegin before
                for (int col = colEnd; col >= colBegin ; col--) {//traverse row but column indexes
                    resMatrix[rowEnd][col]= fill_inCounter++;
                }
            }
            rowEnd--;//move row

            if(colBegin <= colEnd){// double check since we  have modified the colEnd  before
                for (int row = rowEnd; row >= rowBegin ; row--) {//traverse cols but row indexes
                    resMatrix[row][colBegin]= fill_inCounter++;
                }
            }
            colBegin++;//shrink col
        }

        return resMatrix;
    }
}
