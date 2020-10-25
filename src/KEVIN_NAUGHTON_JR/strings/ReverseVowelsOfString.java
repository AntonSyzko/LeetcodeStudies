package KEVIN_NAUGHTON_JR.strings;

import java.util.Set;

/*
reverse only vowels of given string
hello - holle
Y is now a wovel
 */
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String input = "hello";
        String reversedVowels = reversedVowels(input);
        System.out.println(reversedVowels);
    }


    //runtime O(n) n - length of string
    //dont be confused with while in while - still O(n)
    //space - set O(n)
    static String reversedVowels(String input){
        Set<Character> vowels = Set.of('A','a','E','e','I','i','O','o','U','u');//set of vowels
        char[] inputAsCharArray = input.toCharArray();//strings immutable - can NOT operate on very input

        int start_pointer = 0;
        int end_pointer = input.length()-1;

        while (start_pointer < end_pointer){//traverse condition

            while (start_pointer < end_pointer
                    && !vowels.contains(inputAsCharArray[start_pointer])){//reach vowel from left
                start_pointer ++;//set start here to work after
            }

            while (start_pointer < end_pointer
                    && !vowels.contains(inputAsCharArray[end_pointer])){//reach vowel from end
                end_pointer--;//set end here to operate after
            }

            //now with start and  end on VOWELS - operate - SWAP
            char temp = inputAsCharArray[start_pointer];
            inputAsCharArray[start_pointer] = inputAsCharArray[end_pointer];
            inputAsCharArray[end_pointer] = temp;

            //can be done with ++ and -- above
            start_pointer++;//move start to next char
            end_pointer--;//decrease end to before char

        }

        return new String(inputAsCharArray);
    }
}
