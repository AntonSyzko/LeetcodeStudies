package KEVIN_NAUGHTON_JR.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidAnagram {

    @Test
    public void testIsAnagram() {
        boolean anagram = isValidAnagram2("anagram", "nagaram");
        assertTrue(anagram);
    }

    @Test
    public void testIsNotAnagram() {
        boolean anagram = isValidAnagram2("car", "cat");
        assertFalse(anagram);
    }

    static boolean isValidAnagram(String s, String t) {
        if (s.length() != t.length()) {//different length apriori not an anagram
            return false;
        }

        int[] alphabet = new int[26];//store occurences of each letter in strings

        for (int charac = 0; charac < s.length(); charac++) {//any string since length is same
            alphabet[s.charAt(charac) - 'a']++;//traversing first increase occurences
            alphabet[t.charAt(charac) - 'a']--;//traversing sec decrease
            //if anagram res will be zero (0) +1 : -1 = 0
        }

        for (int letterOccurences : alphabet) {//cheack alphabet
            if (letterOccurences != 0) {//not a zero - means some lettrs occured more in either of the strings
                return false;
            }
        }
        return true;//got here - true
    }

    static boolean isValidAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] char_counts = new int[26];//occurences of each digit count

        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;//occured in first  ++
            char_counts[t.charAt(i) - 'a']--;// occured in second --
        }

        //after ++ and -- on each occurence of same char = res should be 0 for all
        return Arrays.stream(char_counts).allMatch(e -> e == 0);// none of occurences is != 0 , all zeros
    }

}
