package LEET_CODE.array;

import java.util.Arrays;

public class TwoSumTwo {

    public static void main(String[] args) {

        int [] array = new  int [] {1,2,4,6,70};
        int target = 9;

        int [] res = sumTo(array, target);
        System.out.println(Arrays.toString(res));
    }

    static int[] sumTo(int[] input, int target){

        int lower = 0;
        int higher = input.length-1;

        while (lower <= higher){
             int current_sum = input[lower] + input[higher];

             if(current_sum == target){
                 return new int [] {lower +1, higher +1};
             } else if ( current_sum < target){
                 lower ++;
             } else if ( current_sum > target){
                 higher --;
             }
        }

        return new int [] {0,0};
    }
}
