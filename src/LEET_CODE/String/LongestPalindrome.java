package LEET_CODE.String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
given string of lowercase chars finf the LENGTH of longest palindrome can be mnade of theese

abccccdd - > 4 of c , 2 of d , and 1 of a or b , so ->
d c c a c c d
 */
public class LongestPalindrome {

    @Test
    public void test() {
        int res = longestPalindrome("abccccdd");
        assertEquals(res, 7);
    }


    static int longestPalindrome(String str) {

        int[] char_counts = new int[128];//all chars numbers

        for (char ch : str.toCharArray()) {
            char_counts[ch]++;//store occurrences of particular chars by ASCII  numbers ( a - cell 97 - times 1(++) )
        }

        int res = 0;

        for (int ch_count : char_counts) {
            //floor division (3/2 = 1 * 2 = 2 ) , so 1 remains
            res += ch_count / 2 * 2;
            
            if (res % 2 == 0 && ch_count % 2 == 1) {//if no remainder in cuurent res, BUT curr count has remainder
                res += 1;//add
            }
        }

        return res;
    }
}
