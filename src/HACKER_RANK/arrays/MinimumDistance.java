package HACKER_RANK.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
We define the distance between two array values as the number of indices between the two values.
 Given array with duplicates  , find the minimum distance between any pair of equal elements in the array.
  If no such value exists, print -1

  7 1 3 4 1 7
  7 to t = 5 - 0 = 5
  1 to 1 = 4 -1 = 3
  min(5,3) = 3
 */
public class MinimumDistance {

    @Test
    public void testNaive() {
        int[] nums = {7, 1, 3, 4, 1, 7};
        int min = minDistanceNaive(nums);
        assertEquals(3, min);

        int[] nums2 = {7, 1, 3, 4, 11, 71};
        int min2 = minDistanceNaive(nums2);
        assertEquals(-1, min2);
    }

    @Test
    public void test() {
        int[] nums = {7, 1, 3, 4, 1, 7};
        int min = minDistance(nums);
        assertEquals(3, min);

        int[] nums2 = {7, 1, 3, 4, 11, 71};
        int min2 = minDistance(nums2);
        assertEquals(-1, min2);
    }


    // o(n)
    static int minDistance(int [] nums){
        Map<Integer, Integer> map = new HashMap<>();// number vs it's index

        int minDistSoFar = Integer.MAX_VALUE;
        int prevIndex = 0;
        int currentIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if( map.containsKey(nums[i])){//is already in MAP - so - duplicate
                currentIndex = i;//currently here
                prevIndex = map.get(nums[i]);//stored before index
                minDistSoFar  = Math.min(minDistSoFar, currentIndex-prevIndex);//take MIN of curr and dist
            }

            map.put(nums[i], i);//store in MAP anyways always
            
        }
        return minDistSoFar == Integer.MAX_VALUE ? -1 : minDistSoFar;
        
    }


     // O (n^2)
    static int minDistanceNaive(int[] a) {

        int start = 0;
        int end = a.length - 1;
        int minSoFar = Integer.MAX_VALUE;

        //sliding window
        while (start <= a.length) {

            while (end > start) {
                if (a[start] == a[end]) {//same found
                    minSoFar = Math.min(minSoFar, end - start);
                }
                end--;// move sliding window end
            }

            end = a.length - 1;//reset end back to initial
            start++;//move start up 
        }


        return minSoFar == Integer.MAX_VALUE ? -1 : minSoFar;
    }
}
