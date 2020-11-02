package KEVIN_NAUGHTON_JR.strings;

/*
letters coded to digits
a - 1
b-2
...
z- 26

find num of ways to decode word

12 - ways 2
AB - 1 + 2
or L = 12
 */
public class NumWaysToDecodeString {

    public static void main(String[] args) {
        int waysToDecode = waysToDecode("12");
        System.out.println(waysToDecode);
    }

    static int waysToDecode(String input) {
        //stores ways to decode occurences of chars by length
        int[] dynamic_programming_array = new int[input.length() + 1];//+1 is to count zero index
        dynamic_programming_array[0] = 1;//one way to decode of length 1
        dynamic_programming_array[1] = input.charAt(0) == '0' ? 0 : 1;//if sec char is zero - zero ways to decode

        //first 0 and 1 are already covered above
        for (int i = 2; i <= input.length(); i++) {

            int oneDigit = Integer.parseInt(input.substring(i - 1, i));
            int twoDigits = Integer.parseInt(input.substring(i - 2, i));

            if (oneDigit >= 1) {//if equals or less than 1 - we have already covered it in our DP array (dp[0], dp[1])
                dynamic_programming_array[i] += dynamic_programming_array[i - 1];//+= to add previous counts
            }
            // two digits is MAX in our case since alphabet is 26
            if (twoDigits >= 10 && twoDigits <= 26) {//range of >10 and < 26 no three digits or more in alphabet
                dynamic_programming_array[i] += dynamic_programming_array[i - 2];
            }
        }
        return dynamic_programming_array[input.length()];
    }
}
