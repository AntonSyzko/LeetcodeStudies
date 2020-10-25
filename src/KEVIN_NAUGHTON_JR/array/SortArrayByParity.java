package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;

/*
given array sort even odd

2 1 3 4
res = 2 4 1 3
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] resSorted = sortByParity(new int[]{2, 3, 1, 4});
        Arrays.stream(resSorted).forEach(System.out::print);
    }

    static int[] sortByParity(int[] array) {
        int insertIndex = 0;//future index to insert even elemnts

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {//search for even
                int temp = array[insertIndex];//store whats already by the index
                array[insertIndex] = array[i];//update it - insert this found even
                insertIndex++;//increment index - since we will continue
                array[i] = temp;//and in old index where we found even - insert prev index found elemet at
            }
        }

        return array;
    }
}
