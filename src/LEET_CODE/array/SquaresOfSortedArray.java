package LEET_CODE.array;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {

        int[] unsquared = new int [] {-2,0,2};
        int [] squared_sorted = squares(unsquared);
        System.out.println(Arrays.toString(squared_sorted));
    }

    static int[] squares(int[] array) {
        int array_length = array.length;

        int positive_nums_pointer = 0;

        while (positive_nums_pointer < array_length && array[positive_nums_pointer] < 0) {
            positive_nums_pointer++;//thus we have our positives starting at this index
        }

        int negative_nums_pointer = 0;

        int[] sorted_squares_array = new int[array_length];//res
        int sorted_squares_counter = 0;//res increment

        while (negative_nums_pointer >= 0 && positive_nums_pointer < array_length) {

            if (array[negative_nums_pointer] * array[negative_nums_pointer] < array[positive_nums_pointer] * array[positive_nums_pointer]) {
                sorted_squares_array[sorted_squares_counter] = array[negative_nums_pointer] * array[negative_nums_pointer];
                negative_nums_pointer -= 1;//decrement negative pointer - move closer to zero
            } else {
                sorted_squares_array[sorted_squares_counter] = array[positive_nums_pointer] * array[positive_nums_pointer];
                positive_nums_pointer += 1;// increment positive to go to end of array
            }
            sorted_squares_counter += 1;//invrement res counter index
        }

        while (negative_nums_pointer >= 0) {//if smth left in negatives from previous while exited
            sorted_squares_array[sorted_squares_counter] = array[negative_nums_pointer] * array[negative_nums_pointer];
            negative_nums_pointer -= 1;//move on in negatives
            sorted_squares_counter += 1;//move  on in res
        }

        while (positive_nums_pointer < array_length) {//if smth left in positives from previous while exited
            sorted_squares_array[sorted_squares_counter] = array[positive_nums_pointer] * array[positive_nums_pointer];
            positive_nums_pointer += 1;//move  on in positives
            sorted_squares_counter += 1;//move on in res
        }
        return sorted_squares_array;
    }
}
