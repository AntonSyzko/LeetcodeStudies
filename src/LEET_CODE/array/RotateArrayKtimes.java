package LEET_CODE.array;

import java.util.Arrays;

public class RotateArrayKtimes {
    public static void main(String[] args) {
        int [] ara = new int []{1,2,3,4,5,6,7};
        rotate(ara,3);
        System.out.println(Arrays.toString(ara));
    }

    static void rotate(int [] aray, int k){
        k = k % aray.length;//cause may be smaller than aray length
        reverse(aray, 0, aray.length-1);//reverse ALL
        reverse(aray, 0, k-1);//reverse from 0 to k
        reverse(aray, k, aray.length-1);//reverse tail 
    }

    private static void reverse(int[] aray, int start, int end) {
        while (start< end){
            int temp = aray[start];
            aray[start] =aray[end];
            aray[end] = temp;
            start++;
            end--;
        }
    }
}
