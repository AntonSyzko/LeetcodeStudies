package HACKER_RANK.arrays;

public class PossibleSubarrays {

    public static void main(String[] args) {
        int [] array = new  int[] {1,-1,-2,6};
        sumOfNegativeSubarrays(array);
    }


    /*
    calculate summ of negative subarrays
    three loops needed to go over all possible variations of array
    i:  1 - 2 - 3
    j       1 -2
    k   1   2  3

     */

    static void sumOfNegativeSubarrays(int[] array) {
        int negative_arrays_sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int current_sum = 0;
                for (int k = i; k <= j; k++) {
                    current_sum += array[k];
                }

                if (current_sum < 0) {
                    negative_arrays_sum++;
                }
            }
        }
        System.out.println(negative_arrays_sum);
    }
}
