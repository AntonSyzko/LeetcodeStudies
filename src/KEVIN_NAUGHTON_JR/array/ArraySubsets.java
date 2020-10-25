package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.List;

/*
given array of ints, find all possible subsets, power sets
123
1, 2 , 3 , 12, 23, 13, 123, []
 */
public class ArraySubsets {
    public static void main(String[] args) {


        List<List<Integer>> powerSets = subsets(new int[]{1,2,3});
        powerSets.stream().forEach(System.out::println);
    }

    //runtime 2 n
    //space O(n)
    static List<List<Integer>> subsets(int [] nums){

        List<List<Integer>> subsets = new ArrayList<>();//res

        generateSubsets(0, new ArrayList<Integer>(), nums, subsets);

        return subsets;
    }

    private static void generateSubsets(int indexInNums, ArrayList<Integer> currentSubset, int[] nums, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(currentSubset));//add current subset ( copy of it ) to results

        for (int i = indexInNums; i < nums.length ; i++) {//traverse nums

            currentSubset.add(nums[i]);//add current num to current subset

            generateSubsets(i+1, currentSubset,nums, subsets);//recursively on next i

            currentSubset.remove(currentSubset.size()-1);//remove LAST from current subset to get all possible power set permutation
        }
    }
}
