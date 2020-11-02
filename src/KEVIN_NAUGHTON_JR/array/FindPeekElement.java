package KEVIN_NAUGHTON_JR.array;

/*
given array 1231  - peek is 2nd  element (3)
1213564 - peak is either index  1 (2) or 5 ( 6)
 */
public class FindPeekElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int peak = findIndexOfPeakElement(nums);
        System.out.println(peak);
    }

    //binary search approach
    static int findIndexOfPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;//int overflow

            if (nums[mid] < nums[mid + 1]) {//if growing
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
