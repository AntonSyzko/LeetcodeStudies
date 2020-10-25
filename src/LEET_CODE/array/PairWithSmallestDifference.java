package LEET_CODE.array;

import java.util.Arrays;

/*
Given two non-empty arrays of integers, find the pair of values (one value from each array) with the smallest (non-negative) difference.

Example

Input: [1, 3, 15, 11, 2], [23, 127, 235, 19, 8]

Output: [11, 8]; this pair has the smallest difference.
 */
public class PairWithSmallestDifference {

    public static void main(String[] args) {
        int[] a1 = new int[]{-1, 5, 10, 20, 28, 3};
        int[] a2 = new int[]{26, 134, 135, 15, 17};

        int[] pair = findSmallestDifferencePair(a1, a2);
        System.out.println(pair[0] + " " + pair[1]);
    }

    //Time complexity: O(mlog(m) + nlog(n)) where m - first array , n - second , log(n) -is for sorting , n - while loop
    public static int[] findSmallestDifferencePair(int[] array1, int[] array2) {

        Arrays.sort(array1);//speed up naive approach where just two for loops used
        Arrays.sort(array2);

        double smallestDifference = Double.MAX_VALUE;//res diff
        int[] smallestDiffPair = new int[2];//very res

        int start_of_array1_pointer = 0;//sliding window approach pointers
        int start_of_array2_pointer = 0;

        while (start_of_array1_pointer < array1.length && start_of_array2_pointer < array2.length) {//bounds of loop
            double current_diff = Math.abs(array1[start_of_array1_pointer] - array2[start_of_array2_pointer]);//curr diff
            if (current_diff < smallestDifference) {//if curr more than double min or prev smallest
                smallestDifference = current_diff;//reassign
                smallestDiffPair[0] = array1[start_of_array1_pointer];//populate res
                smallestDiffPair[1] = array2[start_of_array2_pointer];
            }

            // move starts of loop to get smallest
            if (array1[start_of_array1_pointer] < array2[start_of_array2_pointer]) {//to iterate onwards
                start_of_array1_pointer++;
            } else {
                start_of_array2_pointer++;
            }
        }

        return smallestDiffPair;
    }


}
