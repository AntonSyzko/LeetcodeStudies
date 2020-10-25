package LEET_CODE.array;

/*
given array  1 3 6  nad num k = 3
one may substract any num in range of K so that min diff between all nums in array
1 +3  3 +1  6 -2 = 4 4 4
diff = 0
 */
public class SmallestRangeDiff {

    public static void main(String[] args) {
     int minRange = minRange(new int [] {1,3,6}, 3);
        System.out.println(minRange);
    }


    static int minRange(int[] nums, int K) {
        int min_val = nums[0];
        int max_val = nums[0];

        for (int i = 0; i < nums.length; i++) {
            min_val = Math.min(min_val, nums[i]);
            max_val = Math.max(max_val, nums[i]);
        }

        if (min_val + K >= max_val - K) {
            return 0;
        } else {
            return (max_val - K) - (min_val + K);
        }
    }
}
