package HACKER_RANK.strings;

import java.util.Arrays;

/*
CAT ACT TAC CTA .... are anagrams
 */
public class Anagrams {
    public static void main(String[] args) {

        System.out.println(" anagrams ? " + isAnagram("CATy", "ACTy"));
        System.out.println(" anagrams ? " + isAnagramBySorting("CATVz", "ACTVz"));

    }

    static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) return false;//diff length - not anagrams per se

        first = first.replaceAll(" ", "").toLowerCase();//trim and ignore case
        second = second.replaceAll(" ", "").toLowerCase();

        int[] alphabet = new int[26];//placeholder for char occurences [2][4] - so first char 'a' occured two times , 'b' - four times etc ...

        for (int i = 0; i < first.length(); i++) {//loop trough first string
            char current_char = first.charAt(i);
            int index_of_current_char_in_alphabet = current_char - 'a';//diff between given char and 'a' gives diff  of ASCII values
            alphabet[index_of_current_char_in_alphabet]++;//store diff of ASCII value and increment number of times this char  occured in string
        }

        for (int j = 0; j < second.length(); j++) {
            char current_char = second.charAt(j);
            int index_of_current_char_in_alphabet = current_char - 'a';
            alphabet[index_of_current_char_in_alphabet]--;//decrement - so it occured in second string
        }

        for (int k = 0; k < 26; k++) {
            if (alphabet[k] != 0) return false;//if some  chars were in first but not in second - they left in alphabet and is not zero
        }

        return true;
    }


    static boolean isAnagramBySorting(String a, String b){
        if ( a.length() != b.length()) return  false;

        char[] a_chars= a.trim().toLowerCase().toCharArray();
        char[] b_chars = b.trim().toLowerCase().toCharArray();

        Arrays.sort(a_chars);//sorting puts chars in same order
        Arrays.sort(b_chars);

        return Arrays.equals(a_chars, b_chars);


    }
}
