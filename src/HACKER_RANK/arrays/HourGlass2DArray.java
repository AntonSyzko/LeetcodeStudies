package HACKER_RANK.arrays;

//max value in cell 9
//max width 6 max heigh=th 6
//9 9 9 0 0 0
//0 9 0 0 0 0
//9 9 9 0 0 0
public class HourGlass2DArray {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9, 9, 9, 0, 0, 0},
                {0, 9, 0, 0, 0, 0},
                {9, 9, 9, 0, 0, 0},
                {9, 8, 9, 0, 0, 0},
                {0, 8, 0, 0, 0, 0},
                {9, 7, 9, 0, 0, 0}
        };
        findMaxHourGlass(matrix);

    }

    static void findMaxHourGlass(int[][] matrix) {
        int max_hourglass_sum = -63;
        int rows_length = matrix.length;
        int cols_length = matrix[0].length;

        for (int horizontal = 0; horizontal < rows_length - 2; horizontal++) {// rows legth -2 =cause we are adding 2 elements - so not out of bounds
            for (int vertical = 0; vertical < cols_length - 2; vertical++) {//columns length - 2
                int current_hourglass_sum = matrix[horizontal][vertical] + matrix[horizontal][vertical + 1] + matrix[horizontal][vertical + 2]
                                                                         + matrix[horizontal + 1][vertical+1]
                                          + matrix[horizontal + 2][vertical] + matrix[horizontal + 2][vertical + 1] + matrix[horizontal + 2][vertical + 2];

                if (current_hourglass_sum > max_hourglass_sum) {
                    max_hourglass_sum = current_hourglass_sum;
                }


            }

        }

        System.out.println(max_hourglass_sum);
    }
}
