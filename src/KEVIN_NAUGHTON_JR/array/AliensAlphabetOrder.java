package KEVIN_NAUGHTON_JR.array;

/*
given worlds ['words' , 'world', 'row' ] and alines alphabet ['fgfghhjtertrtjfghmjfnbm]
check if words are in lexicographical order
so each letter in next world is sorted alphabetically,
if first world is shorter thatn sec it is not lexicograp
 */
public class AliensAlphabetOrder {

    public static void main(String[] args) {

    }

    static boolean isAlienSorted(String[] words, String alien_order) {
        int[] alphabet = new int[26];              //O(1) constant time store matches
        for (int i = 0; i < alien_order.length(); i++) {
            alphabet[alien_order.charAt(i) - 'a'] = i;//of char value in ASCII - 'a'  to ints index
        }

        //comparing words in array
        for (int i = 0; i < words.length; i++) {//first word
            for (int j = i + 1; j < words.length; j++) {//next to first

                //min of two words, since no need to compare all chars, but only those in both words
                int min_world_of_two_length = Math.min(words[i].length(), words[j].length());
                for (int char_in_word = 0; char_in_word < min_world_of_two_length; char_in_word++) {//chars in word  traversing
                    char charFromFirstWord = words[i].charAt(char_in_word);
                    char charFromNextWord = words[j].charAt(char_in_word);

                    if (alphabet[charFromFirstWord - 'a'] < alphabet[charFromNextWord - 'a']) {//ASCII char is > - so OK
                        break; // OK break LETTERS iteration to next iteration of words LOOP
                    } else if (alphabet[charFromFirstWord - 'a'] > alphabet[charFromNextWord - 'a']) {
                        return false; // not OK , ASCII chars are not lex - false
                    } else if (char_in_word == min_world_of_two_length - 1 //so only when VERY LAST iteration - end of WORD LOOP
                            && words[i].length() > words[j].length()) {// if first word greater length that next - not lex
                        return false; // false
                    }
                }

            }
        }

        return true;//got here - OK
    }
}
