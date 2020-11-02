package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
[1,2,2,1]  and [2,2]
res [2]

[4,9,5]  and [9,4,9,8,4]
res [9,4]

find intersection

res contains ONLY UNIQUE
res in ANY ORDER



 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] a1 = new int[]{4, 9, 5};
        int[] a2 = new int[]{9, 4, 9, 8, 4};

        int [] intersection = intersectionOfTwoArrays(a1, a2);
        System.out.println(Arrays.toString(intersection));
    }

    static int[] intersectionOfTwoArrays(int[] arr1, int[] arr2) {

        Set<Integer> set1 = new HashSet<>();//guarantees uniques
        for (int each : arr1) {//all uniques from 1 array
            set1.add(each);
        }

        Set<Integer> intersection_set = new HashSet<>();//unique same in BOTH arrays
        for (int each : arr2) {
            if (set1.contains(each)) {//if in first set
                intersection_set.add(each);//add to intersection
            }
        }

        int[] res = new int[intersection_set.size()];

        int index = 0;

        for (int sameInBoth : intersection_set) {//traverse intersection SET
            res[index++] = sameInBoth;
        }

        return res;
    }
}
