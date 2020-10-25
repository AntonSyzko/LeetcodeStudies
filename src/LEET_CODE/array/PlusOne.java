package LEET_CODE.array;

import java.util.Arrays;

/*
leetcode 66
given array of digits representing num
1 2 5 - add 1 = 1 2 6
1 3 9 - add 1 will result 1 4 0
999 add 1 = 1 0 0 0
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] res1 = plustOne(new int[]{1,2,3});
        int[] res2 = plustOne(new int[]{1,3,9});
        int[] res3 = plustOne(new int[]{9,9,9});

        System.out.println(Arrays.toString(res1) + " \r\n" + Arrays.toString(res2) + "\r\n" + Arrays.toString(res3));

    }

    static int[] plustOne(int[] digits){
        int index = digits.length-1;//index from end

        while (index >= 0){//till reached start

            if(digits[index] != 9){//current by index from end is NOT 9 ( nine)
                digits[index] = digits[index]+1;//add ONE to it
                return digits;//all good retrun
            }

            //was 9
            digits[index]=0;// so adding 1 will give 10 - carry 1, and current will be ZERo anyways
            index--;//rollback iteration since we need to add our carry 1 to previous itration
        }

        //if here carry still exists
        int[] res_for_carry_extended = new int[digits.length+1];//resize array
        res_for_carry_extended[0]=1;//since carry exceeded existing intial array - add 1 to leading position (999 + 1 = 1 000 )
        return res_for_carry_extended;

    }
}

