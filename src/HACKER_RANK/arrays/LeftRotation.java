package HACKER_RANK.arrays;

import java.util.Arrays;

/*
A left rotation operation on an array shifts each of the array's elements  unit to the left.
For example, if 2 left rotations are performed on array [1,2,3,4,5] , then the array would become [3,4,5,1,2].

Given an array  of  integers and a number, ,
 perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.
 */
public class LeftRotation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] res = rotateLEft(arr, 2);
        System.out.println(Arrays.toString(res));
    }


    static int[] rotateLEft(int[] array, int rotation_step) {
        int size = array.length;
        int[] rotated = new int[size];

        int index = 0;
        int rotated_index = rotation_step;

        while (rotated_index < size) {//populate rotated same as original for non shifting bits
            rotated[index] = array[rotated_index];
            index++;
            rotated_index++;
        }

        //index stays at future insertins position
        rotated_index = 0;//reset rotated index to 0


        while (rotated_index < rotation_step) {
            rotated[index] = array[rotated_index];
            index++;
            rotated_index++;//while condition updated here
        }

        return rotated;
    }

}
