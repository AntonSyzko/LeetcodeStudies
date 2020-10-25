package HACKER_RANK.preparation_kit;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        int[] arr = new int []{3,-7,0};
        int res_abs_min_diff = minimumAbsoluteDifference(arr);
        System.out.println(res_abs_min_diff);

    }

    static int minimumAbsoluteDifference(int [] array){
        int absolute_min_diff = Integer.MAX_VALUE;
        Arrays.sort(array);//thus we will have min elements next to each other - giving lowest possible diffs of them - no need to two for loops ( n^2 )

        for(int i = 0; i< array.length-1; i++){
            int current_min = Math.abs(array[i]-array[i+1]);
            absolute_min_diff = Math.min(absolute_min_diff,current_min);
        }
        return absolute_min_diff;
    }
}
