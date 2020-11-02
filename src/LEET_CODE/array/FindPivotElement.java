package LEET_CODE.array;

/*
array sum at left and right of pivot are same

find pivot index if exists
or -1dec
 */
public class FindPivotElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int pivot = findPivot(nums);
        System.out.println(pivot);
    }


    static int findPivot(int[] nums) {
        int total_sum = 0;

        for (int n : nums) {
            total_sum += n;
        }

        int left_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left_sum += nums[i - 1];//aggregate left sum, not counting current ( -1)
            }

            int right_sum = total_sum - left_sum;

            if (right_sum - nums[i] == left_sum) {//if right - current ( potential pivot) == left - so sums are equal at both sides of pivot
                return i;
            }
        }
        return -1;//no pivot
    }
}
