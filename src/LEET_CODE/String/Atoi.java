package LEET_CODE.String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
String to integer
Igfnore whitespaces, non chars ignore
take to account +/- and Integer overflow

Input: str = "   -42"
Output: -42
Explanation: The first non-whitespace character is '-',
 which is the minus sign. Then take as many numerical digits as possible, which gets 42.

 Input: str = "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w',
which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.

Input: str = "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Therefore INT_MIN (−2^31) is returned.
 */
public class Atoi {

    @Test
    public void test() {
        int rees = convertStringToInteger("words and 987");
        assertEquals(0, rees);

    }


    static int convertStringToInteger(String input) {
        if (input == null || input.length() < 1) {
            return 0;
        }
        input = input.trim();

        boolean isPositive = input.startsWith("+");
        boolean isNegative = input.startsWith("-");

        int i = 0;//counter

        if (isNegative) {
            i++;
        } else if (isPositive) {
            i++;
        }

        double res = 0;

        while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
            res = res * 10 + (input.charAt(i) - '0');
            i++;
        }

        res = isNegative ? -res : res;

        if( res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if( res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) res;


    }
}
