package LEET_CODE.array;

/*
Given an array of integers, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaxContiguousSubarray {
    public static void main(String[] args) {
    int [] array = new int [] {-2,1,-3,4,-1,2,1,-5,4};
    int maxContiguousSubarraySum = findMaxSubarraySum(array);
        System.out.println(maxContiguousSubarraySum);
    }

    private static int findMaxSubarraySum(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0];
        int maxEndingHere  = nums[0];
        int currentStart = 0, maxStart = 0, maxEnd = 0;

        for(int i = 1; i < n; i++){
            if(maxEndingHere + nums[i] < nums[i]){//means previuos max ending was negative
                maxEndingHere = nums[i];//reassign then
                currentStart = i;//just a pointer index if needed
            }else {
                maxEndingHere = maxEndingHere + nums[i];
            }
            if(maxEndingHere> maxSoFar){
                maxSoFar = maxEndingHere;
                maxStart = currentStart;
                maxEnd = i;
            }
        }
        //    return new int[]{maxStart, maxEnd};  if need to  retund indexes
        return maxSoFar;
    }

    }
