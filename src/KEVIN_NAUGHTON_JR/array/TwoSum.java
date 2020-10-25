package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
given array of nums [2,7,8,4,6] and target val = 9
return indicies of elements sum  matching number
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] sumTwo = twoSum(new int [] {2,7,6,4},9);
        System.out.println(Arrays.toString(sumTwo));
    }

    static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numToItsIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (numToItsIndexMap.containsKey(difference)) {
                res[0] = i;//index of current matching to add sum
                res[1] = numToItsIndexMap.get(difference);//index of prev stored diff
                return res;
            }
            numToItsIndexMap.put(nums[i], i);//put diffs to according index

        }
        return res;
    }
}
