package KEVIN_NAUGHTON_JR.misc;

import java.util.HashSet;
import java.util.Set;

/*
given array of unique sorted nums , find missing one
0, 1, 2, 4, 5    missing is 3
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{0,  1, 2, 4, 5};
        int missing = findMissingNumGausesLaw(nums);
        System.out.println(missing);
    }

    static int findMissingExtraMem(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer i : nums) {
            numsSet.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!numsSet.contains(i)) {//not in SET
                return i;//is missing
            }
        }
        return -1;
    }

    //natural order numbers    sum = (n * (n-1) )/2   ex( n= 4 ) :  0 1 2 3 = 4 * 3 / 2 = 6
    static int findMissingNumGausesLaw(int[] nums) {
        int sum = 0;

        for (Integer i : nums) {
            sum += i;
        }


        int n = nums.length + 1;//+1 to count in the very N


        return (n * (n - 1) / 2) - sum;//gausses sum - actual sum = missing

    }
}
