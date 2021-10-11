package MULTI_LANG_SOLUTIONS;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TwoSum {

    @Test
    public void test() {
        int[] nums = new int[]{2, 5, 7, 3};
        int[] res = TwoSum.twoSum(nums, 9);
        int[] expected = new int[]{2, 7};
        System.out.println(Arrays.toString(res));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> diffToTargetMap = new HashMap<>();//key ->  diff to target : value -> index

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            if (diffToTargetMap.containsKey(current)) {
                res[0] = i;
                res[1] = diffToTargetMap.get(nums[i]);
            } else {
                diffToTargetMap.put(target - nums[i], i);
            }
        }
        return res;
    }
}
