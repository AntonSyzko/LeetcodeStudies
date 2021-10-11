package LEET_CODE.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
pattern abba
word    cat dog dog cat
find if matches
 */
public class WordPatternMatch {


    @Test
    public void test() {
        boolean res = patternMatching("abba", "cat dog dog cat");
        assertTrue(res);
    }

    @Test
    public void test2() {
        boolean res = patternMatching("abba", "cat dog dog fish");
        assertFalse(res);
    }

    static boolean patternMatching(String pattern, String word) {
        String[] words = word.split(" ");

        if (pattern.length() != words.length) {//lengths are diff - wrong straight away
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {//traverse each char of pattern
            char current_char = pattern.charAt(i);//get current

            if (map.containsKey(current_char)) {//if in map

                if (!map.get(current_char).equals(words[i])) {// but NOT with this word in map
                    return false;//bad
                }

            } else {//not in map yet

                //if value(word) is in map already , but by KEY was not detected in above IF clause
                if (map.containsValue(words[i])) {
                    return false;//bad
                }
                map.put(current_char, words[i]);//add to map
            }
        }

        return true;//got here , OK, nice
    }
}
