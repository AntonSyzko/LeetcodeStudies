package LEET_CODE.array;

import java.util.HashSet;

/*
count unique morse code representations of english words
morse will give combination of - and .
count only uniques
 */
public class MorseCodeTransformations {

    public static void main(String[] args) {
        String[] words = new String[]{"gig", "zen","msg","gin"};
        int uniques = uniqueMorseCodeRepresentations(words);//2 of them --...-.  and --...--.
        System.out.println(uniques);
    }

    static int uniqueMorseCodeRepresentations(String [] words){

        HashSet<String> unique_codes = new HashSet<>();

        //dynamic programming - array of positions of letters
        final String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.." };

        for (String word : words){
            StringBuilder transformation = new StringBuilder();

            for( char current_char_in_word : word.toCharArray()){
                transformation.append(MORSE[current_char_in_word-'a']);//position in MORSE array of ASSCII val of current char ( -'a', which will give number of ASCII val )
            }

            unique_codes.add(transformation.toString());
        }
        return unique_codes.size();
    }
}
