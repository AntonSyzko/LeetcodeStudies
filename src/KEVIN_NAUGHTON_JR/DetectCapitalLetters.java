package KEVIN_NAUGHTON_JR;

import java.util.stream.Stream;

/*
valid USA - all caps
usa - non cap
Usa - only first cap
 */
public class DetectCapitalLetters {
    public static void main(String[] args) {

        System.out.println(isCorrectCapitalisztion("USA"));
        System.out.println(isCorrectCapitalisztion("usa"));
        System.out.println(isCorrectCapitalisztion("Usa"));
        System.out.println(isCorrectCapitalisztion("usA"));


    }

    static boolean isCorrectCapitalisztion(String word){
        int capitalsCount = 0;


        for(int i = 0; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))) capitalsCount++;
        }

        return capitalsCount == word.length() || capitalsCount == 0 || capitalsCount == 1 && Character.isUpperCase(word.charAt(0));
    }
}
