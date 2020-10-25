package LEET_CODE.array;

import java.util.Arrays;

/*
given array of 2n ints, group ints into n pairs , which makes sum 9 a, b ) as large as possible

1 4 3 2

n = 2 - pairs of 2
1,2    3, 4
min(1,2)  + min(3,4) = 4
 */
public class ArrayPartition {

    public static void main(String[] args) {
        int res = arrayPairSum(new int [] {1,4,3,2});
        System.out.println(res);
    }

    static int arrayPairSum(int[] nums){
        int sum = 0;
        Arrays.sort(nums);//gropus mins straight away

        for(int i = 0; i < nums.length-1; i +=2){//jumps of 2
            sum += nums[i];//already mins by sorting and pairs in jumps of 2
        }

        return sum;
    }
}
