package KEVIN_NAUGHTON_JR;

public class RevereseOnlyLettersInSTring {

    public static void main(String[] args) {

        String initial = "123ab-cd*";
        String reversed = reverseOnlyLetters(initial);
        System.out.println(reversed);
    }

    static String reverseOnlyLetters(String input){
        char [] characters = input.toCharArray();
        int start = 0;
        int end = input.length()-1;

        while (start < end){
            while (start< end && !Character.isLetter(input.charAt(start))){
                start++;
            }

            while (end > start && !Character.isLetter(input.charAt(end))){
                end--;
            }

            char temp = characters[start];
            characters[start++] = characters[end];
            characters[end--] = temp;

           // start++;
           // end--;

        }
        return new String(characters);
    }


}
