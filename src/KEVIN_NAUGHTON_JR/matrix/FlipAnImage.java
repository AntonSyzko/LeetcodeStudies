package KEVIN_NAUGHTON_JR.matrix;

import java.util.Arrays;

/*
given image matrix

flip each row horizontally :  1 1 0 = 0 1 1
after invert each row:        0 1 1 = 1 0 0
 */
public class FlipAnImage {

    public static void main(String[] args) {
        int[][] image = new int [][]{
                {1,1,0},
                {0,0,1}
        };
        int[][] flipped = flipAndInvertImage(image);
        System.out.println(Arrays.deepToString(flipped));
    }

    static int[][] flipAndInvertImage(int[][] image) {

        for (int row = 0; row < image.length; row++) {//traverse rows
            int left = 0;//leftmost row
            int right = image[row].length - 1;//rightmost row

            //flip horizontally each row
            while (left < right) {//traversein row
                int temp = image[row][left];//swap fro flipping horizontally
                image[row][left] = image[row][right];
                image[row][right] = temp;
                left++;//moveleft up
                right--;//right down
            }

            for (int col = 0; col < image[row].length; col++) {//traverse colums
                image[row][col] = image[row][col] == 1 ? 0 : 1;//invert
            }
        }
        return image;
    }

}
