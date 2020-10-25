package LEET_CODE.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static void main(String[] args) {

        int [] array = new  int [] {2,7,6,1,8,-1};
        int [] resMapa = twoNumberHashMap(array, 9);
        int [] res = foundTwoSumNumbers(array, 9);
        System.out.println(Arrays.toString(res));
    }

    //O(n) - map - space, runtime O(1) - get from mao, store to map
    static int[] twoNumberHashMap(int [] array, int sum_target){
        Map<Integer,Integer> array_value_to_index_mapper = new HashMap<>();//storage maps array value to it's index location

        for(int i = 0 ; i < array.length; i++){//iterate over array
            int complement = sum_target - array[i];//complement = difference between our sum sum_target and current element in array
            if(array_value_to_index_mapper.containsKey(complement)){// if needed  target is in mapper
                return new int [] {array_value_to_index_mapper.get(complement), i};//retrun index of found complement and current index
            } else{
                array_value_to_index_mapper.put(array[i],i);//otherwise - store current array value to it's index
            }
        }
        return new  int []{};// nothing worked
    }


    /*
    There is another approach which works when you need to return the numbers instead of their indexes. Here is how it works:
    This approach is called the two-pointer sliding window approach. It is a very common pattern for solving array related problems.
     */
    //Time complexity: O(n*log(n)) , where n - elements in array, n*log n = sorting
    static int [] foundTwoSumNumbers(int [] numbers, int target_sum){
        Arrays.sort(numbers);//sorting is essential here
        int start_index = 0;//sliding window
        int end_index = numbers.length-1;

        while (start_index < end_index){
            if(numbers[start_index] + numbers[end_index] == target_sum){//match
                return new int [] {numbers[start_index], numbers[end_index]};
            }else if(numbers[start_index] + numbers[end_index] < target_sum){//less then match
                start_index++;//increase lower bound
            }else {//bigger than match
                end_index--;// otherwise decrease higher bound
            }
        }

        return new int [] {};
    }
}
