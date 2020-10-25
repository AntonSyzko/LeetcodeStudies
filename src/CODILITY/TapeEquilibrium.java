package CODILITY;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibrium {


    @Test
    public void tapeEquilibriumTest() {
        int[] nums = new int[]{3,1,2,4,3};
        assertEquals(2, new TapeEquilibrium().tapeEquilibrium(nums));
    }

    public int tapeEquilibrium(int[] nums) {

        //initialize diff
        long difference = nums[0];


        //get difference for non divided array
        for (int i = 1; i < nums.length; i++) {
            difference += nums[i];
        }

        //min diff so far
        long minDifference = Math.abs(difference);

        //traverse
        for (int i = 1; i < nums.length ; i++) {
            difference = -2 * nums[i];
            minDifference = Math.min(minDifference, Math.abs(difference));
        }
        return (int) minDifference;
    }

}
