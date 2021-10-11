package HACKER_RANK.arrays;

import java.util.Arrays;

public class LeftArrayRotation {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5};
        int[] res = rotateLEft(array, 2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(res));

    }

    static int[] rotateLEft(int[] array, int rotation_step){
        int size = array.length;
        int[] rotated = new int[size];

        int index = 0;
        int rotated_index = rotation_step;

        while (rotated_index < size){//populate rotated same as original
            rotated[index] = array[rotated_index];
            index ++;
            rotated_index ++;
        }

        rotated_index = 0;//reset rotated index to 0


        while (rotated_index < rotation_step){
            rotated[index] = array[rotated_index];
            index ++;
            rotated_index ++;
        }

        return rotated;
    }
}
