package KEVIN_NAUGHTON_JR.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{1,2,3},
                                      {4,5,6},
                                      {7,8,9}
        };

        List<Integer> res = spiralMatrix(matrix);
        System.out.println(res);
    }

    static List<Integer> spiralMatrix(int [] [] matrix){
        List<Integer> res = new ArrayList<>();//res

        if(matrix == null || matrix.length == 0){
            return res;
        }

        int top_row = 0;
        int bottom_row = matrix.length-1;

        int left_col = 0;
        int right_col = matrix[0].length-1;

        int size = matrix.length * matrix[0].length;// boundaries check ( res array should never be more than matrix size)

        while (res.size() < size){
            //top row traversal ( including always boundaries check )
            for (int i = left_col; i <= right_col && res.size() < size ; i++) {
                res.add(matrix[top_row][i]);
            }
            top_row++;//not to include it again when we go  right column

            //right column traversal ( excluding first - since it is already in res ( see above line )
            for (int i = top_row; i <= bottom_row && res.size() < size ; i++) {
                res.add(matrix[i][right_col]);
            }
            right_col--;//not to include in bottom row

            //bottom row
            for (int i = right_col; i >= left_col && res.size() < size ; i--) {
                res.add(matrix[bottom_row][i]);
            }
            bottom_row--;//not to include in left column

            //left column traversal
            for (int i = bottom_row; i >= top_row && res.size() < size ; i--) {
                res.add(matrix[i][left_col]);
            }
            left_col++;//not to include in top row ( here the spiral shrinks actually , turns one level before top row and each time like this, ulitka )
        }
         return res;
    }
}
