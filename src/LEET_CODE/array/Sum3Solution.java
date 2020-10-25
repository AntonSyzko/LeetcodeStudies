package LEET_CODE.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
given array find 3 digits that add up to 0
dont count in duplicate triplets, res are uniques

-1 0 1 2 - 1 - 4

res  -1 0 1  and  -1 -1 2

 */
public class Sum3Solution {

    public static void main(String[] args) {
      List<List<Integer>> res = threeSum(new int []{-1,0,1,2,-1,-4});
      res.stream().forEach(System.out::println);
    }

    static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);//sort for two sliding window move inwards

        List<List<Integer>> resTriplets = new LinkedList<>();//res

       // traverse array comparing element and two from next
        for (int i = 0; i < nums.length - 2; i++) {//-s - since we adding THREE digits
            //first    OR following AND NON DUPLICATES
            if (i == 0 || (i > 0    &&  nums[i] != nums[i - 1])) {
                //internal TWO SUM sliding window
                int low_index = i+1;//next to i
                int high_index = nums.length-1;//last of array
                int sum_diff = 0-nums[i];//diff between 0 and our iteration one ( sum adds to 0 )

                while (low_index<high_index){//bounds
                    //two of sliding wndow ADD to zero
                    if(nums[low_index] + nums[high_index] == sum_diff){
                        resTriplets.add(Arrays.asList(nums[i],nums[low_index],nums[high_index]));//add to res

                        while (low_index<high_index && nums[low_index]==nums[low_index+1]){//skip duplicates in traversion by LOW
                            low_index++;
                        }
                        while (low_index<high_index && nums[high_index]==nums[high_index-1]){//skip duplicates by HIGH
                            high_index--;
                        }
                        low_index++;//raise HIGH
                        high_index--;//raise LOW

                        //if sum of two in sliding window is MORE than diff we need to zero
                    }else if(nums[low_index] + nums[high_index] > sum_diff){
                        high_index--;//decrease HIGH
                    }else {//nums[low_index] + nums[high_index] < sum_diff
                        low_index++;//increase low if sum is lower than we need to add to 0
                    }
                }
            }

        }

        return resTriplets;
    }
}
