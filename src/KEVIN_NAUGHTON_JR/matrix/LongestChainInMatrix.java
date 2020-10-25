package KEVIN_NAUGHTON_JR.matrix;

import java.util.Arrays;
import java.util.Comparator;

/*
given matrix [[1,2] [2,3] [3,4]]
find longest consecutive chain
[1,2] [3,4] - length 2
 */
public class LongestChainInMatrix {

    public static void main(String[] args) {

        int[][] matrix = new int [][] {{1,2},{2,3},{3,4}};
        int res = findLongestConsecutiveChain(matrix);
        System.out.println(" res " + res);
    }

    static int findLongestConsecutiveChain(int[][] matrix) {
        int longest_consecutive_chain = 0;//res

        Arrays.sort(matrix, Comparator.comparingInt((int[] row) -> row[1]));//sort to have increasing order, sort by [1] , but [0] works also 

        int end_of_prev_row = Integer.MIN_VALUE;//temp end, starts even out of matrix with MIN val

        for (int i = 0; i < matrix.length; i++) {//traverse

            int start_of_next_row = matrix[i][0];//start starts as first row value i

            if (end_of_prev_row < start_of_next_row) {//actual comparising
                end_of_prev_row = matrix[i][1];//end gets assigned to what was start row's [1] , and start [0] will be increased bo FOR loop
                longest_consecutive_chain++;//res add
            }
        }

        return longest_consecutive_chain;
    }
}
