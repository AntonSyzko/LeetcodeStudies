package KEVIN_NAUGHTON_JR.array;

import java.util.stream.IntStream;

/*
given array of ints find mountain
12321 - true / \  increasing then decreasing OK
355- false /  only increasing
321 - false \  only decreasing
111 false - flat
 */
public class ValidateMountain {

    public static void main(String[] args) {
        int[] nums = IntStream.of(1, 2, 3, 2, 1).toArray();
        boolean isMountain = hasMountain(nums);
        System.out.println(isMountain);

        int[] nums2 = IntStream.of(3, 5, 5).toArray();
        boolean isMountain2 = hasMountain(nums2);
        System.out.println(isMountain2);

        int[] nums3 = IntStream.of(3, 2, 1).toArray();
        boolean isMountain3 = hasMountain(nums3);
        System.out.println(isMountain3);

        int[] nums4 = IntStream.of(1, 1, 1, 1).toArray();
        boolean isMountain4 = hasMountain(nums4);
        System.out.println(isMountain4);
    }


    //runtime O(n)
    //space O(1) no extra memory
    static boolean hasMountain(int[] nums) {

        int pointer = 0;//comparing one to next elemnets in array pointer

        while (pointer < nums.length //bounds
                && pointer + 1 < nums.length //bounds
                && nums[pointer] < nums[pointer + 1])//if current el is less then next
        {
            pointer++;//it's increasing so raise the pointer
        }

        if (pointer == 0 //if pointer never raised - means never has any increase , meanse ONLY DECREASING \
                || //OR !!!
                pointer + 1 >= nums.length)//if pointer +1 = lenth of all nums - means ONLY INCREASING /
        {
            return false;//invalid then
        }

        //while pointer still in bounds
        while (pointer < nums.length && pointer + 1 < nums.length) {
            //if current el is less or = then next to it
            if (nums[pointer] <= nums[pointer + 1]) {// !!!! mind ++ not to get to infinite loop in while
                return false;//invalid
            }
            pointer++;//not to get to infinite loop in while,     can put to  nums[pointer++ + 1]
        }

        return true;//got here OK
    }
}
