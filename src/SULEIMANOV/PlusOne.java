package SULEIMANOV;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
      int[] digits = new int[] {1,2,9};
        System.out.println(Arrays.toString(digits));

        int[] res = plusOne(digits);
        System.out.println(Arrays.toString(res));

    }

    static int[] plusOne(int[] digits){
        int indexOfDigit = digits.length-1;//get index of LAST

        //case of 9 9 9
        while (digits[indexOfDigit]==9){//if last is 9
            digits[indexOfDigit]=0;//make it 0
            indexOfDigit--;//shift index LEFT

            if(indexOfDigit <0){//if it has reached -1
                digits = new int[digits.length+1];//make  new  array of +1 size
                digits[0]=1;//mark firts element [0] as 1 ( tenth carry )
                break;//exit of while - done with 9 case
            }
        }

        if (indexOfDigit>=0){//if nOT 9 and more or equal  0
            digits[indexOfDigit]++;//just increment
        }

        return digits;
    }
}


