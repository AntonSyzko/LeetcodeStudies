package LEET_CODE.String;

import java.util.ArrayDeque;
import java.util.Deque;

/*
3[a2[c]] = accaccacc
 */
public class DecodeString {
    public static void main(String[] args) {
        String encoded = "3[a2[c]]";

        String decoded = decodeString(encoded);
        System.out.println(decoded);
    }


    static String decodeString(String encoded) {
        Deque<Integer> numStack = new ArrayDeque<>();//stack of nums appeared
        Deque<String> strStack = new ArrayDeque<>();//stack of chars appeared
        StringBuilder tail = new StringBuilder();

        int len = encoded.length();

        for (int i = 0; i < len; i++) {
            char curr = encoded.charAt(i);

            if (Character.isDigit(curr)) {//if NUMBER
                int num = curr - '0';//num from char

                while (i + 1 < len && Character.isDigit(encoded.charAt(i + 1))) {//case of tenth, hundred nums
                    num = num * 10 + +encoded.charAt(i + 1);//aggreagte tenth or hundreds
                    i++;//iteration only for nums in case of  ex. 20 or 230 or smth ....
                }

                numStack.push(num);//store in nums stack

            } else if (curr == '[') {

                strStack.push(tail.toString());//whats in str so far  -> to stack
                tail = new StringBuilder();//recreate - so RESET str

            } else if (curr == ']') {

                StringBuilder temp = new StringBuilder(strStack.pop());// temp new from what's in stck so far
                int repeatedTimes = numStack.pop();//how many times str repeted

                for (int j = 0; j < repeatedTimes; j++) {//this many times append to temp
                    temp.append(tail);//temp will contain times appeared tail
                }
                tail = temp;//so now tail contains the WHLE with appeared times

            } else {// just a char

                tail.append(curr);//add to temp

            }
        }

        return tail.toString();
    }
}
