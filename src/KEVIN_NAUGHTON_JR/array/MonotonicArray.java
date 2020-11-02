package KEVIN_NAUGHTON_JR.array;

/*
monotonic is increasing OR decreasing ( >=, <=)
1, 2, 3, 3, 4   - increasing
4,4,3,2,1 - decreasing
1, 1, 1, = increasing or decreasing - monotonic
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3};
        boolean isMono = isMonotonicArray(nums);
        System.out.println(isMono);
        nums = new int[]{1, 1, 1};
        isMono = isMonotonicArray(nums);
        System.out.println(isMono);
    }


    static boolean isMonotonicArray(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }

            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        return decreasing || increasing;
    }
}
