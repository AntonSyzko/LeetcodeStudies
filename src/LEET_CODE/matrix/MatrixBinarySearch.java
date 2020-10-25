package LEET_CODE.matrix;

/*
given 2 d array - sorted - find element exists or no
in 2 d  - same approach as bin search , but start = 0 , end = rows*col-1;
 */
public class MatrixBinarySearch {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        boolean foundInMatrix = binSearchMatrix(matrix, 7);
        System.out.println(foundInMatrix);
    }

    static boolean binSearchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int colums = matrix[0].length;

        int start = 0;//bin search start
        int end = rows * colums - 1;//bin serach end - but for 2 D array rows * cols, -1 is for index 0 based

        while (start <= end) {

            int midpoint = start + (end - start) / 2;//int overflow case ocvered mid point
            //2 D array way to get middle, mid/col mid%col
            int midpoint_element = matrix[midpoint / colums] [midpoint % colums];

            //regular bin search way
            if (midpoint_element == target) {
                return true;
            } else if (midpoint_element > target) {
                end = midpoint - 1;
            } else if (midpoint_element < target) {
                start = midpoint + 1;
            }
        }
        return false;

    }

}

