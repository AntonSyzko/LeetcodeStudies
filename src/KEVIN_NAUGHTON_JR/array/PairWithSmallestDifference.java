package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;

/*
Given two non-empty arrays of integers, find the pair of values (one value from each array)
 with the smallest (non-negative) difference.

Example

Input: [1, 3, 15, 11, 2], [23, 127, 235, 19, 8]

Output: [11, 8]; this pair has the smallest difference.
 */
public class PairWithSmallestDifference {

    public static void main(String[] args) {
        int[] a1 = new int[] {-1, 5, 10, 20, 28, 3};
        int[] a2 = new int[] {26, 134, 135, 15, 17};

        int[] pair = findSmallestDifferencePair(a1, a2);
        System.out.println(pair[0] + " " + pair[1]);
    }

    //O(n^2)
    static int[] pairWithSmallestDiffNaive(int[] array1, int[] array2){
        double smallestDiff = Double.MAX_VALUE;
        int [] resPair = new int[2];

        for (int i = 0; i < array1.length ; i++) {
            for (int j = 0; j < array2.length ; j++) {
                double currentDiff = Math.abs(array1[i]-array2[j]);

                if(currentDiff < smallestDiff){
                    smallestDiff = currentDiff;
                    resPair[0] = array1[i];
                    resPair[1] = array2[j];
                }
            }
        }

        return resPair;
    }

    //O(m log(m) + n log(n))
    public static int[] findSmallestDifferencePair(int[] a1, int[] a2) {
        Arrays.sort(a1);//sort speeds up algo to log
        Arrays.sort(a2);

        double smallestDiff = Double.MAX_VALUE;
        int[] smallestDiffPair = new int[2];
        int i = 0, j = 0;

        while(i < a1.length && j < a2.length) {
            double currentDiff = Math.abs(a1[i] - a2[j]);
            if(currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestDiffPair[0] = a1[i];
                smallestDiffPair[1] = a2[j];
            }
            //slide window
            if(a1[i] < a2[j]) {//first less than sec
                i++;//raise first
            } else {
                j++;
            }
        }
        return smallestDiffPair;
    }


    }
