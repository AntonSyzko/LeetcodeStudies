package LEET_CODE.array;

import java.util.HashMap;

/*
given array of ints find continuous subarray which sum equals to k
1 1 1    - subarrays are [] [11] [11] [111]
k = 2
res is [11] [11] = 2
continuous is  subarray whoose elements are next to each other
 */
public class SubarrayEqualsToK {
    public static void main(String[] args) {
     int[] nums = new int [] {1,1,1};
     int subsToK = subarraySum(nums, 2);
        System.out.println(subsToK);
    }

    static int subarraySum(int[] nums, int targetSum) {
        //map of how many times ongoind sum of elemnts occured
        HashMap<Integer, Integer> array_sums_occurences = new HashMap<>();
        array_sums_occurences.put(0,1);//initially sum of ZERO and it has been met ONCE , hence 0 -1
        int res = 0;
        int ongoingSum = 0;

        for (int i = 0; i< nums.length; i++){
            ongoingSum += nums[i];//aggreagte continuous subarray sum

            if(array_sums_occurences.containsKey(ongoingSum-targetSum)){//if diff from ongoing sum to target is in map
                res += array_sums_occurences.get(ongoingSum-targetSum);//add to res how many times it has occured
            }
            //add to map aggregating ongoing sum
            array_sums_occurences.put(ongoingSum, array_sums_occurences.getOrDefault(ongoingSum, 0)+1);
        }

        return res;
    }

}
