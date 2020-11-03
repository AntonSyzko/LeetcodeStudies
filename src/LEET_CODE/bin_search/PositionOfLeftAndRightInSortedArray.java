package LEET_CODE.bin_search;

/*
1 2 3 8 8 9
[3, 4]
 1 2 3 5 5 5 6
 [3 ,5 ]
 */

import java.util.Arrays;

public class PositionOfLeftAndRightInSortedArray {

    public static void main(String[] args) {
   int [] arra = new int [] {1,2,3,5,5,5,12};
   int [] arrayOfStartAndEndIndexes = searchRange(arra, 5);
        System.out.println(Arrays.toString(arrayOfStartAndEndIndexes));
    }


    static int [] searchRange(int [] array, int target){
        int[] result = new int [2];
        result[0]= findFirstOccurence(array,target);//leftmost occurrence of target
        result[1] = findLastOccurence(array, target);//rightmost occurrence of target

        return result;
    }
    
    //find the LEFTMOST occurrence of target
    private static int findFirstOccurence(int[] array, int target) {
        int index = -1;

        int start = 0;
        int end = array.length-1;

        while (start <= end){
            int midpoint = start + ( end - start)/2;

            if( array[midpoint] >= target){ //!!! >= since we move on with equal targets ( 5, 5, 5 )
                end = midpoint-1;
            }else {
                start = midpoint+1;
            }

            if(array[midpoint] == target){//match
                index = midpoint;//index of first ( leftmost occurrence )  is here
            }
        }
        return index;
    }

//find the RIGHTMOST occurence of target in array
    private static int findLastOccurence(int[] array, int target) {
        int index = -1;

        int start = 0;
        int end = array.length-1;

        while (start <= end){
            int midpoint = start + ( end - start)/2;

            if(array[midpoint] <= target ){//!!! <= - equals since we ok with same ( 5, 5, 5)
                start = midpoint +1;
            }else {
                end = midpoint-1;
            }

            if( array[midpoint]==target){//match
                index = midpoint;//rightmost index is here
            }
        }

        return index;
    }
}
