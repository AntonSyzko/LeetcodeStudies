package LEET_CODE.array;

import java.util.Arrays;

/*
given char array and words - find out if words can be formed from chars
each char can be  used only ONCE for each word


 */
public class WordsFromChars {

    public static void main(String[] args) {
     String validCahrs = "atach";
     String[] wordsToForm = new String[]{"cat","hat","bt","tree"};

     int resWordsCanBEFormed = validCharCount(wordsToForm, validCahrs);

        System.out.println(resWordsCanBEFormed);
    }

    static int validCharCount(String[] words, String chars ){
        int valid_chars_length = 0;//res

        int [] alphabet_char_counts = new int[26];//alphabet count for char occurences

        for (char each: chars.toCharArray()){
            alphabet_char_counts[each-'a']++;//char - 'a'=number in alphabet from 0, ++ increases each time  occured
        }

        for(String word : words){//traverse all words

            int [] temp_char_count_copy = Arrays.copyOf(alphabet_char_counts, alphabet_char_counts.length);//use copy to decrement each time looking
            int valid_char_count_for_word = 0;//valid for current iteration word

            for (char eachInGivenWord : word.toCharArray()){

                if(temp_char_count_copy[eachInGivenWord-'a']>0){//if for current char in alphabet met
                    temp_char_count_copy[eachInGivenWord-'a']--;//decrease count, since ONCE already met
                    valid_char_count_for_word++;//increase valid for curent word met count
                }
            }

            if(valid_char_count_for_word == word.length()){//if valid count = lngth = means ALL chars were valid and word can be constructed
                valid_chars_length+=word.length();//add to res
            }
        }

        return valid_chars_length;
    }
}
