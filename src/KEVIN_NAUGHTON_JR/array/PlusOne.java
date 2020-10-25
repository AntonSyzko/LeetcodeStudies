package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;

/*
[ 1, 2, 3 ] +1 = [1, 2, 4 ]
[9, 9, 9 ] +1 = [ 1, 0,0,0 ]
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] arra = new int [] {1,2,3};
        System.out.println(Arrays.toString(arra));

        int[] arraAddOne = addOneToArray(arra);
        System.out.println(Arrays.toString(arraAddOne));

        int[] arra2 = new int [] {9,9,9};
        System.out.println(Arrays.toString(arra2));

        int[] arraAddOne2 = addOneToArray(arra2);
        System.out.println(Arrays.toString(arraAddOne2));

    }

    static int [] addOneToArray(int [] digits){

        for (int i = digits.length-1; i >= 0 ; i--) {//traverse backwards
            if(digits[i]<9){//less than 9
                digits[i]++;//add one
                return digits;//eresult returned
            }
            digits[i]=0;////> 9 - set to  0 on next iteration one will be added
        }

        //case all 9
        int [] tenthCarriedArray = new int [digits.length+1];//new array with length +1 to original
        tenthCarriedArray[0]=1;//set first 9 added ) digit to 1
        return tenthCarriedArray;
    }
}
