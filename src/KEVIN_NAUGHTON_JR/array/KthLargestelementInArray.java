package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/*
given array of nums and k
return kth largest element in array
5 6 2 1 4 3 , k=2
res = 5
 */
public class KthLargestelementInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 3, 6};
        int kThLargest = kthLargestMinHeap(nums, 2);
        System.out.println(kThLargest);
    }

    // O(N*logN)
    static int kthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);//logN
        return nums[nums.length - k];
    }

    //add to MIN HEAP, then remove K times
    static int kthLargestMinHeap(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//mim heap will contain from smallest to largest

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {//exceeded k
                minHeap.remove();//remove from head - smallest
            }
        }
        return minHeap.remove();//highest remained, first Kth, last the very largest 
    }
}
