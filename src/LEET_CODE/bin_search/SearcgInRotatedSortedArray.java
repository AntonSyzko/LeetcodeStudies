package LEET_CODE.bin_search;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/*
array is sorted but shifted
12345  - > 34512

find in it log(n)
 */
public class SearcgInRotatedSortedArray {
    @Test
    public void test() {
        int[] nums = {3, 4, 5, 1, 2};
        int res = searchInRotatedArray(nums, 4);
        assertEquals(1, res);
    }

    static int searchInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        //bin earch to find pivot
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left;//curr start
        left = 0;
        right = nums.length - 1;

        //target > pivot
        if (target >= nums[start] && target <= nums[right]) {
            left = start;//search only after start
        } else {
            right = start;//search only before start
        }

        //bin serach but with new LEF and  RIGHT according to prev found PIVOT (Start )
        while (left <= right) {
            int mid = left + (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;//not found

    }
}
