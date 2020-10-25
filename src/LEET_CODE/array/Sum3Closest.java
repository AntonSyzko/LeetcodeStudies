package LEET_CODE.array;

import java.util.Arrays;

/*
given array find three nums which in sum make closes to given target
-1,2,3,5,1  target = 3
closest -1 + 1 + 3
 */
public class Sum3Closest {
    public static void main(String[] args) {

        int[] nums = new int[]{-1, 2, 3,5,1};
        int closestThreeSum = threeSumClosest(nums, 3);
        System.out.println(closestThreeSum);
    }

    static int threeSumClosest(int[] array, int target) {
        int res = array[0] + array[1] + array[array.length - 1];//current temp res (of 1,2 and last elements ) - to compare with in future
        Arrays.sort(array);//for addition order

        for (int i = 0; i < array.length - 2; i++) {//length -2 cause we are  adding 3 numbers
            int second_pointer = i + 1;//second after first
            int last_pointer = array.length - 1;//last

            while (second_pointer < last_pointer) {
                int current_sum = array[i] + array[second_pointer] + array[last_pointer];//sum index first sec and last ( accordingly to loop move)

                if (current_sum > target) {//too large
                    last_pointer -= 1;//decrease last - cause we sorted array initially
                } else {
                    second_pointer += 1;//to small to target - increase second
                }

                //compare current sum with target diff and temporary initial sum with target i
                if (Math.abs(current_sum - target) < Math.abs(res - target)) {// closest to target comparising
                    res = current_sum;//reassign if needed
                }
            }
        }

        return res;
    }
}
