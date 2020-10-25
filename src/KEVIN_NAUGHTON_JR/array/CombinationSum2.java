package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
given array aof candidates and tartet to from sum from candidates
no duplicates

 */
public class CombinationSum2 {

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{1, 2, 3}, 3);
        res.stream().forEach(System.out::println);
    }


    //space O(n)   run O(2n)
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        findCombinationToSum(candidates, 0, target, new ArrayList<Integer>(), res);//recusive

        return res;
    }

    private static void findCombinationToSum(int[] candidates, int indexInCandidates, int target, ArrayList<Integer> current, List<List<Integer>> res) {

        if (target == 0) {//base case we exctracted all and reached zero , means all extractions added together are target
            res.add(new ArrayList<>(current));//add to res since this combiantion was equal  target
            return;
        }

        if (target < 0) {//reached below zero in our extractions - getv out
            return;
        }


        for (int i = indexInCandidates; i < candidates.length; i++) {
            if (i == indexInCandidates || //if first ever iteration OR
                    candidates[i] != candidates[i - 1]) {//non duplicates following each other

                current.add(candidates[i]);//takin in
                findCombinationToSum(candidates, indexInCandidates + 1, target - candidates[i], current, res);
                current.remove(current.size() - 1);//taking out
            }
        }
    }
}
