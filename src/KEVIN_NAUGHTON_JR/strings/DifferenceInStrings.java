package KEVIN_NAUGHTON_JR.strings;

import java.util.HashMap;
import java.util.Map;

/*
given two Strings , where second is permutation of first with ONE extra element added
find the added element if exists
 */
public class DifferenceInStrings {

    public static void main(String[] args) {
        String first = "abc";
        String sec = "bca*";

        char diff = findDiffChar(first, sec);

        System.out.println(diff);
    }

    static char findDiffChar(String first, String sec) {
        Map<Character, Integer> charToOccurence = new HashMap<>();

        for (char ch : first.toCharArray()) {//traverse all chars in first
            charToOccurence.put(ch, charToOccurence.getOrDefault(ch, 0) + 1);//store occurences in map
        }



        for (char ch : sec.toCharArray()) {//traverse second

            if (!charToOccurence.containsKey(ch) //if char is NOT in map at all
                    || // OR
                    charToOccurence.get(ch) == 0) { // occured 0 times

                return ch;
            } else {
                charToOccurence.put(ch, charToOccurence.get(ch) - 1);//decrease occurence of a curr char from map
            }
        }

        return '!';
    }
}
