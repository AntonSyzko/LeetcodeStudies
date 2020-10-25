package LEET_CODE.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
given words apple facebook google amazon
and target worlds 'e' 'oo'

find subsets, subset is where tartget occured in wods ( count in char counts in target )
so amazon  and apple does not , since oo is specified
 */
public class WordSubsets {

    public static void main(String[] args) {
        String[] words = { "apple", "facebook", "google", "amazon", "leetcode" };
        String[] targets = {"e","oo"};

        List<String> res = wordSubsets(words,targets);
        res.stream().forEach(System.out::println);
    }

    static List<String> wordSubsets(String[] words, String [] targets){

        List<String> result = new ArrayList<>();

        int []max_target_char_frequencies = new int [26];//alphabet ocurrences of target chars

        for (int trgt = 0; trgt < targets.length; trgt++) {//traverse ALL the targets

            String current_target = targets[trgt];
            int[] current_char_frequencies = getCharFrequency(current_target);//curent chars in this target occurences

            for (int i = 0; i < 26 ; i++) {//for all cells in alphabet array

                //choose max between global max and current max FOR EACH char in alphabet
                max_target_char_frequencies[i] = Math.max(max_target_char_frequencies[i], current_char_frequencies[i]);

            }
        }

        //traverse all the words
        for (int word = 0; word < words.length; word ++) {
            String current_word = words[word];

            int [] char_count = getCharFrequency(current_word);//current wods chars alphabet ocurrences count

            boolean isValidCharOcurrenceNumber = true;//flag

            for (int i = 0; i < 26 ; i++) {//alphabet check for all chars in word
                //if max allowed ocurrence or EVERY char in alphabet ( counted from target )  is MORE then we have in current
                if(max_target_char_frequencies[i] > char_count[i]){
                    isValidCharOcurrenceNumber = false; // chars occured less in current wod than we need from target
                    break;//o need to continue - word is invald
                }
            }
            // if valid , so in current word number of target chars were at LEAST as in target ( or  more ok also ), but not LESS
            if( isValidCharOcurrenceNumber) {
                result.add(current_word);
            }
        }

        return result;
    }

    //alphabetic char ocuurences
    private static int[] getCharFrequency(String input){
        int[] result = new int[26];//alphabet chars occurences as int [1,2,0] [a-1, b-2, c-0 ]

        for (char ch : input.toCharArray()){
            result[ch-'a']++;//ASCII char - 'a' = number from 1 to 26 , put in array and  increase count
        }

        return result;
    }
}
