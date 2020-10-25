package LEET_CODE.array;

import java.util.ArrayList;
import java.util.List;

/*
given range of int - find numbers that are self dividing

self dividing num is num taht is divisible by every digit it contains
not allowed to contain zero
 */
public class SelfDividingNumber {

    public static void main(String[] args) {

        System.out.println(selfDividingNumbers(1,22));
    }

    //alternative solutiion is to use ints each time deivide by ten , comparing remainder 
    static List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> res = new ArrayList<>();
        for (int num = left; num <= right; num++){
            if( isSelfDividing(num)) res.add(num);
        }

        return res;
    }

    private static boolean isSelfDividing(int num) {
        for(char ch : String.valueOf(num).toCharArray() ){
            if(ch == '0' || num % ( ch - '0') > 0 ) {
                return false;
            }
        }
        return true;
    }
}
