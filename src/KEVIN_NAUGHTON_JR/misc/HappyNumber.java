package KEVIN_NAUGHTON_JR.misc;

import java.util.HashSet;

/*
happy num is when squares of all its digits added lead to 1
19 = 1^2 + 9^9 = 82
82 = 8^8 + 2^2 = 68
68 = 6^6 + 8^8 = 100
100 = 1^1 + 0^0 + 0^0 = 1
true
 */
public class HappyNumber {
    public static void main(String[] args) {
        boolean isHappy = isHappyNumber(19);
        System.out.println(isHappy);
    }


    static boolean isHappyNumber(int num){
        HashSet<Integer> seenSums = new HashSet<>();//to store calculated sums as we go

        while (num !=1){//1 is our goal

            int current = num;
            int sum = 0;

            while (current != 0){//exctract digits from current
                sum += (current%10) * (current%10);
                current /= 10;
            }

            if( seenSums.contains(sum)){//menas we  already seen this sum and we  rae in a loop, good bye
                return false;
            }

            seenSums.add(sum);//store calculated sum

            num = sum;//reassign num to sum and work with the new num
        }
        return true;//got here OK
    }
}
