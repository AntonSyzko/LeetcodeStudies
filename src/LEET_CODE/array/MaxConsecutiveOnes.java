package LEET_CODE.array;

/*
This problem can be solved using the two pointer sliding window technique.

Initialize two pointers (indexes): left = 0 and right = 0.
Initialize a variable numConversions to keep track of the number of conversions done from 0 to 1.
Iterate over the array until the right index reaches the end of the array.
If a[right] == 0, then we need to flip this element to 1 to obtain a contiguous subarray of 1s.
Therefore, we increment the numConversions value.
If numConversions is greater than the number of allowed conversions, then we can’t proceed,
and we must shift our window by incrementing left index until numConversions becomes equal to the number of allowed conversions.
In every iteration, we check if the current length of longest contiguous subarray of 1s is greater than the previous value,
and we set the longest length accordingly.
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = findMaxConsecutiveOnes(a, k);
        // System.out.printf("Length of longest contiguous subarray containing only 1s = %d", result);

        int[] nums3 = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int res3 = maxConsecutive3(nums3, 2);
        System.out.println(res3);
    }


    private static int findMaxConsecutiveOnes(int[] a, int k) {
        int maxOnes = Integer.MIN_VALUE;
        int numConversions = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < a.length; right++) {

            if (a[right] == 0) {
                numConversions++;
            }

            while (numConversions > k) {
                if (a[left] == 0) {
                    numConversions--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }

    static int maxConsecutive(int[] nums) {
        int max = 0;//start with zero
        int current_num_of_ones = 0;

        for (int i = 0; i < nums.length; i++) {//traverse

            if (nums[i] == 1) {//curent is 1
                current_num_of_ones += 1;//add to current ones count
                max = Math.max(max, current_num_of_ones);//chose beetween curr max and overal max so far
            } else {//current is 0
                current_num_of_ones = 0;//reset count of noes to 0 back
            }
        }
        return max;

    }

    static int maxConsecutive3(int[] nums, int k) {
        int slidingPointer1 = 0;
        int slidingPointer2 = 0;

        while (slidingPointer1 < nums.length) {
            if (nums[slidingPointer1] == 0) {//met zero
                k--;//decrement K
            }

            if (k < 0) {//exhausted zeros
                if (nums[slidingPointer2] == 0) {//if zero by second pointer
                    k++;//increment k back
                }
                slidingPointer2++;//increment pointer 2
            }
            slidingPointer1++;//always increment pointer 1 to finish while
        }

        return slidingPointer1 - slidingPointer2;//difference is answer
    }


}
