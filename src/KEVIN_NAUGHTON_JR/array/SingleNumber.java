package KEVIN_NAUGHTON_JR.array;

import java.util.HashSet;
import java.util.Set;

/*
given array of nums where all nums appear twice except only one, find that ONE
[2,2,1]
return 1
 */
public class SingleNumber {
    public static void main(String[] args) {
  int uniqueSingle = findSingleNum(new int [] {2,2,1});
        System.out.println(uniqueSingle);
    }

    static int findSingleNum(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer i : nums) {
            if (numsSet.contains(i)) {
                numsSet.remove(i);
            } else {
                numsSet.add(i);
            }
        }

        for (Integer i : numsSet) {
            return i;
        }

        return -1;
    }
}
