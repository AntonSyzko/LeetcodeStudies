package LEET_CODE.array;

import java.util.stream.IntStream;

/*
given array 2 3 1 2 4 3 and number 7
find the min length  subarray with sum values >= number
4 + 3 = 7 , so length of array is 2
 */
public class MinSizeSubarraySum {

    public static void main(String[] args) {
        int[] array = IntStream.of(2,3,1,2,4,3).toArray();
        int target = 7;
        int res = minSubarrayLength(target, array);
        System.out.println(res);
    }

    static int minSubarrayLength(int target_sum, int [] array){
        int result_length = Integer.MAX_VALUE;//min - so MAX to begin
        int current_sum = 0;//sum as we  traverse and compare
        int left_pointer = 0;//left pointer

        for (int i = 0; i < array.length ; i++) {//i here is another left  pointer
            current_sum += array[i];//aggregate  current sum +=

            while (current_sum >= target_sum){//if current sum is bigger or equals

                //min of current subarray length ( current index +1 - left pointer ( 0 at the beginning )
                result_length = Math.min(result_length, i + 1 - left_pointer);

                //decrease current sum - exctract left pointer index element
                current_sum = current_sum - array[left_pointer];

                left_pointer ++;//raise left pointer
            }
        }

        return (result_length!=Integer.MAX_VALUE)? result_length : 0 ;
    }
}
