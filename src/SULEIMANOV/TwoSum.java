package SULEIMANOV;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }


    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);//populate map - key : number : val - it's index in array
        }

        for (int j = 0; j < nums.length; j++) {
            int neededDifference = target - nums[j];

            if (map.containsKey(neededDifference) // diff in map AND
                    && map.get(neededDifference) != j) {//NOT to count itself since we iterate through entire MAP again
                return new int[]{j, map.get(neededDifference)};
            }
        }

        throw new IllegalArgumentException(" no solution");
    }
}
