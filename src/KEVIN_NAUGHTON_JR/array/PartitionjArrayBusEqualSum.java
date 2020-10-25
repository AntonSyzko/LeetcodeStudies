package KEVIN_NAUGHTON_JR.array;

import java.util.HashMap;

/*
given nums 1 5 5 11 partition in two subarrays so that sum of nums are same
[1 5 5 ]  [11]
 */
public class PartitionjArrayBusEqualSum {

    public static void main(String[] args) {
      int[] nums = new int [] {1,5,5,11};
      boolean canPart = canPartition(nums);
        System.out.println(canPart);
    }

    static boolean canPartition(int[] nums){
        int total = 0;

        for(int num: nums){
            total+=num;
        }

        if(total%2 != 0){//if total IS divisible by 2 with REMAINDER - means not eqal - cant be equally partitioned in halves
            return false;
        }

        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    private static boolean canPartition(int[] nums, int index, int sumSoFar, int total, HashMap<String, Boolean> state) {

        String currentRepresentationOfIndexAndSum = index +""+sumSoFar;//string rep of ints aggregation 1+""+5 = "15"

        if(state.containsKey(currentRepresentationOfIndexAndSum)){//if this ints are in state already
            return state.get(currentRepresentationOfIndexAndSum);//just get result
        }
        //actual calc
        if(sumSoFar *2 == total){//if current sum times 2 = total = partition possible
            return true;
        }

        if(sumSoFar>total || index >= nums.length){//more than we need OR reached END
            return false;
        }
//recusively ask if can partition for NEXT index (index+1)  with OR without elemnt at index added to sum
        boolean foundPartition = canPartition(nums, index+1, sumSoFar,total, state)//without taking element at indx to sum
                ||//OR
                canPartition(nums, index+1, sumSoFar+nums[index], total, state);//taking element at index to sum

        state.put(currentRepresentationOfIndexAndSum, foundPartition);//dynamic programming - take to state for next time we see this combination (subproblem)

        return foundPartition;
    }
}
