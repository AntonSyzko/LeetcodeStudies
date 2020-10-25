package KEVIN_NAUGHTON_JR.matrix;

import java.util.Arrays;

/*
given matrix of pixels , flood fill all 4 adjacent to given row/col cells with new colour
and adjacent to newly coloured too
 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int [][]{
                {1,1,0,0},
                {1,1,0,0},
                {1,1,0,0}
        };
        System.out.println(Arrays.deepToString(image));
        int[][] newlyColoured= floodFill(image,0,0,5);
        System.out.println(Arrays.deepToString(newlyColoured));

    }

    static int[][] floodFill(int[][] image, int stratRow, int startCol, int newColor) {
        if (image[stratRow][startCol] == newColor) {
            return image;
        }

        fill(image, stratRow, startCol, image[stratRow][startCol], newColor);

        return image;
    }

    //shell func
    private static void fill(int[][] image, int stratRow, int startCol, int originalColor, int newColor) {
        //recusrion base case
        if (stratRow < 0 || stratRow >= image.length || // out of bounds rows
                startCol < 0 || startCol >= image[stratRow].length//out of bounds cols
                || image[stratRow][startCol] != originalColor) {//color mismatch, sonly paints adjacent of original color
            // if adjacent to 1 is 1 - gets repainted, otherwise skipped
            return;//end
        }

        image[stratRow][startCol] = newColor;//paint here
        fill(image, stratRow+1, startCol, originalColor, newColor);//rows below
        fill(image, stratRow-1, startCol, originalColor, newColor);//rows above
        fill(image, stratRow, startCol+1, originalColor, newColor);//colums to right
        fill(image, stratRow, startCol-1, originalColor, newColor);//colums to left


    }
}
