package HACKER_RANK.matrix;

/*
hourglass
123
020
789
 */
public class DS_Hourglass {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1,2,3},{1,2,3},{1,2,3}};
        int max = hourGlassSum(matrix);
        System.out.println(max);
    }

    static int hourGlassSum(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int max_hour_glass = -63;// constraints ar <9>9 - so in hourglass is max 7 elements - 7*9 = 63

        for(int horizontal = 0; horizontal < rows-2; horizontal++){//rows - 2 = cause we are adding maximun 2 elements - so not to out of bounds ex
            for( int vertical = 0; vertical < cols-2; vertical++){// !! cols -2 same
                int current_hourglass_sum = matrix[horizontal][vertical] + matrix[horizontal+1][vertical]+matrix[horizontal+2][vertical]//123 - first row
                        +matrix[horizontal+1][vertical+1]+//2 - second
                        matrix[horizontal][vertical+2] + matrix[horizontal+1][vertical+2] + matrix[horizontal+2][vertical+2];//123 - third
                max_hour_glass = Math.max(max_hour_glass, current_hourglass_sum);

            }
        }

        return max_hour_glass;
    }
}
