package HACKER_RANK.strings;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/*
Given a string s, find the length of the longest substring without repeating characters.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test() {
        String s = "abcabcbb";
        int res = longestSubstring(s);
        assertEquals(res, 3);
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        int res = longestSubstring(s);
        assertEquals(res, 1);
    }

    static int longestSubstring(String s) {

        // Base condition
        if (s == null || s.equals("")) {
            return 0;
        }

        // SLIDING WINDOW Starting window index
        int start = 0;
        // Ending window index
        int end = 0;

        // Maximum length of substring - RES
        int maxLength = 0;

        // This set will store the unique characters
        Set<Character> uniqueCharacters = new HashSet<>();


        // Loop for each character in the string
        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {//or contains and add in body
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());//store current MAX or prior MAX
            } else {
                //remove current to proceed as if it has not been there - to move window and check next variation
                uniqueCharacters.remove(s.charAt(start));
                start++;//move start and form next substring variation
            }
        }
        return maxLength;
    }
}
