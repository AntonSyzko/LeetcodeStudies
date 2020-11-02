package KEVIN_NAUGHTON_JR.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
1234 - false
1231 - true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arra = new int[]{1, 2, 3, 1};
        boolean dupls = containsDuplicate(arra);
        System.out.println(dupls);
        boolean contsansWithDist = containsDuplicateWithDistance(arra, 3);
        System.out.println(contsansWithDist);
    }

    static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    static boolean containsDuplicateWithDistance(int[] nums, int distance) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current) && i - map.get(current) <= distance) {
                return true;
            } else {
                map.put(current, i);
            }
        }
        return false;
    }
}
