package LEET_CODE.array;

/*
flow flower flight = fl
none = ""

approach - take longest as prefix
compare other words to prefix - if NO match - deacrease the prefix by 1 char - compare - >
decrease again if needed till match ( or none ) found
 */

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};
        String longestCommonPrefix = longestPrefix(words);
        System.out.println(longestCommonPrefix);
    }

    //O(n) where n is num of ALL chars in all words, or O(m*n) where n - words - m - chars in each word
    static String longestPrefix(String[] words) {
        if (words == null || words.length == 0) return "";//pre cehck


        String prefix = words[0];//first word entire as prefix to begin

        for (int word = 1; word < words.length; word++) {//starting from second word traverse
            //no mathc gives -1
            while (words[word].indexOf(prefix) != 0) {//if occurence of prefix in current iteration word is not 0
                prefix = prefix.substring(0, prefix.length() - 1);//resize prefix - delete LAST char from it
            }
        }
        return prefix;
    }
}