package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.List;

/*
given numbers 2-9 inclusive - calculate all possible letter representations
line a phone numbers map to
1 - nothing
2 - a b c
3 -d e f
and so on

23 = ad ae af bd be bf cd ce cf
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {

        List<String> res = letterCombinationsForPhoneNum("23");
        res.stream().forEach(System.out::println);
    }

    static List<String> letterCombinationsForPhoneNum(String number) {
        List<String> res = new ArrayList<>();
        if (number == null || number.length() == 0) {
            return res;
        }

        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationsRecursive(res,number, "",0, mapping);

        return res;

    }

    private static void letterCombinationsRecursive(List<String> res, String number, String current, int index, String[] mapping) {

        //recusrion base case
        if(index == number.length()){ //if index equals all nums length - nothnig to continue
            res.add(current);//add current
            return;
        }

        String letters = mapping[number.charAt(index)-'0'];//exctract from mappings array current number as int (index in array are ints )

        for (int letter = 0;  letter < letters.length(); letter++){//traverse mapping cell
                                                 // cur + each letter of a mapp cell     // raise index to chek all nums
            letterCombinationsRecursive(res, number,current+letters.charAt(letter),index+1, mapping);
        }
    }
}
