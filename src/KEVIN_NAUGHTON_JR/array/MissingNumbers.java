package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
[ 4 3 2 7 8 2 3 1 ]
some appear twice !
find missing from [1,n]
1 - 8 range, missing 5 and 6
do in O(n) time  complexity, so no sorting

so find missing in range from 1 to length inclusive
 */
public class MissingNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> res = findMissingNumbers(nums);
        res.stream().forEach(System.out::println);
    }


    static List<Integer> findMissingNumbers(int[] nums) {

        List<Integer> missingBNums = new ArrayList<>();//res

        Set<Integer> uniqueNums = new HashSet<>();//set uniques

        for (int n : nums) {
            uniqueNums.add(n);
        }

        for (int i = 1; i <= nums.length; i++) {//traverse range from 1 to N
            if (!uniqueNums.contains(i)) {// from range not in set
                missingBNums.add(i);//add to res
            }
        }

        return missingBNums;
    }
}
