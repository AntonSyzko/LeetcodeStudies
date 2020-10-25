package LEET_CODE.array;

import java.util.Arrays;

/*
given array of nums - sort
put even in beginning, odd - after
 */
public class SortByParity {

    public static void main(String[] args) {
        int [] nums = new int [] {1,2,3,4};

        int [] sorted = sortByParity(nums);

        System.out.println(Arrays.toString(sorted));
    }

    //quick sort kind of approach
    static int[] sortByParity(int[] nums) {
        //sliding window
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            // = 1 -> odd     >    = 0 -> even
            if (nums[start] % 2 > nums[end] % 2){//if by start MOD 2 is bigger than by end mOD 2
                int temp = nums[start];//swap em
                nums[start] = nums[end];
                nums[end] = temp;
            }

            if(nums[start]%2 == 0) start++;//if by start index MOD 2 is 0 - means even - ignore, continue

            if( nums[end] % 2 ==1 ) end--;//if by end index MOD 2 = 1 - odd - ignore, it already in place
        }

        return nums;
    }
}
