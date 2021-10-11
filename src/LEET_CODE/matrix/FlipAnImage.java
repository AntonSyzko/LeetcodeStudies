package LEET_CODE.matrix;

import java.util.Arrays;

/*
given an grid
reverse and invert it's rows values

[1,0,0] -> reveresed -> [0,0,1]  -> invert [1,1,0]
[0,1,0]                 [0,1,0]            [1,0,1]

 */
public class FlipAnImage {

    public static void main(String[] args) {
        int [][] image = new int [][] {
                {1,0,0},
                {0,1,0}
        };
        System.out.println(Arrays.deepToString(image));
        int [][] reversedAndInverted = reverseIndInvertGrid(image);
        System.out.println(Arrays.deepToString(reversedAndInverted));
    }
    static int[][] reverseIndInvertGrid(int [][] image){

        for (int row = 0; row <  image.length; row++) {
            //sliding window moving inwards
            int start = 0;
            int end = image[row].length-1;

            while (start <= end){// <= since odd length might occur

                //if diff - no need since reverse and invert will result in absoluteluy same
                if(image[row][start] == image[row][end]){//if same - invert and reverse
                    image[row][start] = 1 - image[row][end];//invert ( case 0: 1- 0 = 1 ; case 1: 1 -1 = 0)
                    image[row][end] = image[row][start];//reverse
                }
                start++;//raise start and end
                end--;
            }
        }
        return image;
    }
}
