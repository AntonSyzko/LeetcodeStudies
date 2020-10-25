package LEET_CODE.array;

import java.util.*;

/*
Given an array of integers, find all triplets in the array that sum up to a given target value.

In other words, given an array arr and a target value target, return all triplets a, b, c such that a + b + c = target.

Example:

Input array: [7, 12, 3, 1, 2, -6, 5, -8, 6]
Target sum: 0

Output: [[2, -8, 6], [3, 5, -8], [1, -6, 5]]
 */
public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 12, 3, 1, 2, -6, 5, -8, 6};
        int target = 0;
        List<Integer[]> res = threeNumBerSumSlidingWindow(nums, target);
        for (Integer[] e : res) {
            System.out.println(Arrays.toString(e));
        }

    }

    static List<Integer[]> threeNumBerSumSlidingWindow(int[] nums, int sum_target) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(nums);//sorting is must for sliding window

        for (int i = 0; i < nums.length; i++) {
            int start_index = i + 1;//two pointers sliding window starts within a loop , so that 3 elemnts participate
            int end_index = nums.length - 1;

            while (start_index < end_index) {
                if (nums[i] + nums[start_index] + nums[end_index] == sum_target) {
                    result.add(new Integer[]{nums[i], nums[start_index], nums[end_index]});
                    start_index++;//to continue searching
                    end_index--;
                }
                if (nums[i] + nums[start_index] + nums[end_index] < sum_target) {//too small
                    start_index++;
                } else {///too big
                    end_index--;
                }
            }
        }

        return result;
    }

    static List<Integer[]> threeSumUsingSet(int[] nums, int sum_target) {

        List<Integer[]> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int current_complement = sum_target - nums[i];//diff between target and current element

            Set<Integer> existingNums = new HashSet<>();//rest of the nums storage set

            for (int j = i + 1; j < nums.length; j++) {//iterate through through the rest of nums after outer loop
                if (existingNums.contains(current_complement - nums[j])) {//if diff between current complement and current num[j] is in set
                    res.add(new Integer[]{nums[i], nums[j], current_complement - nums[j]});//ok add to res
                } else {
                    existingNums.add(nums[j]);//not - add to set and  continue
                }
            }
        }
        return res;
    }
}
