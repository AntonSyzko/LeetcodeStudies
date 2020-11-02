package KEVIN_NAUGHTON_JR.array;

import java.util.HashMap;
import java.util.Map;

/*
given array [3,2,3] - find out majority occurred element
majority if occurred more than length/2  times
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int major = findMajority(nums);
        System.out.println(major);
    }


    //occurrences to map, traverse, check if val in map > length/2
    static int findMajority(int[] nums) {
        if (nums.length == 1) {//one element in array
            return nums[0];
        }

        Map<Integer, Integer> occurrencesCountMap = new HashMap<>();// element - times occured

        for (int n : nums) {//traverse nums

            if (occurrencesCountMap.containsKey(n) //if in map
                    &&//and
                    occurrencesCountMap.get(n) + 1 > nums.length / 2) {//times occurred +1 ( for current iteration ) > len/2

                return n;

            } else {//not in map yet

                occurrencesCountMap.put(n, occurrencesCountMap.getOrDefault(n, 0) + 1);//add 1 to existing , or inti with 1

            }
        }
        return -1;//no majority ( no one length/2 times occurred )
    }
}
