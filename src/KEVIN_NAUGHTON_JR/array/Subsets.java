package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
given 123 generate all subsets
1 2 3 12 23 123 []
 */
public class Subsets {

    public static void main(String[] args) {
       List<List<Integer>> res = generateAllSubsets(new int [] {1,2,3});
        System.out.println(Arrays.toString(new List[]{res}));
    }


    static List<List<Integer>> generateAllSubsets(int [] nums ){
        List<List<Integer>> subsets = new ArrayList<>();//res

        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);// rec func

        return subsets;

    }

    private static void generateSubsets(int indexInNums , int[] nums, List<Integer> currentSubset, List<List<Integer>> subsets) {
        System.out.println("start of rec\r\n " + Arrays.toString(new List[]{currentSubset}));

        subsets.add(new ArrayList<>(currentSubset));//add current to subsets straight away
        for (int i = indexInNums; i < nums.length ; i++) {//iterate from index on
            currentSubset.add(nums[i]);//add current element to current subset
            generateSubsets(i+1,nums, currentSubset,subsets);//recusively add all next to index (i+1)
            currentSubset.remove(currentSubset.size()-1);//remove one  before last
        }

    }
}
