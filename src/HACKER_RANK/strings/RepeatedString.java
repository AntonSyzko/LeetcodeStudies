package HACKER_RANK.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Lilah has a string, S , of lowercase English letters that she repeated infinitely many times.

Given an integer, N, find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the stringS = "abcac"   and N = 10, the substring we consider is  "abcacabcac",
 the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.

 abcac -> inf times repeated "abcacabcac...." -> in first 10 letters -> a occurs 4 times
 */
public class RepeatedString {

    @Test
    public void test1() {
        String initial = "abcac";
        long occurencesOfA = repeatedString(initial, 10L);
        assertEquals(occurencesOfA, 4L);
    }

    @Test
    public void test2() {
        String initial = "aba";
        long occurencesOfA = repeatedString(initial, 10L);
        assertEquals(occurencesOfA, 7L);
    }

    @Test
    public void test3() {
        String initial = "a";
        long occurencesOfA = repeatedString(initial, 1000000000000L);
        assertEquals(occurencesOfA, 1000000000000L);
    }

    static long repeatedString(String str, long pref) {
        long res = 0L;
        //count occurrences of 'a' in intial string
        for (char each : str.toCharArray()) {
            if (each == 'a') {
                res++;
            }
        }

        long timesRepeat = pref / str.length();//times to repeat string
        long remainder = pref % str.length();//remainder of times repeat

        res = res * timesRepeat;//results in times in intial * times to repeat

        //if remainder left
        for (int i = 0; i < remainder; i++) {//traverse initial till remainder
            if (str.charAt(i) == 'a') {
                res++;
            }

        }
        return res;
    }
}
