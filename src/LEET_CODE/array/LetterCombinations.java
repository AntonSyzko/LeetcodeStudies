package LEET_CODE.array;

import java.util.LinkedList;
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
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        res.stream().forEach(System.out::println);
    }


    static List<String> letterCombinations(String number) {
        LinkedList<String> res = new LinkedList<>();

        if (number.length() == 0 || number == null) {
            return res;
        }

        res.add("");

        String[] char_map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int num = 0; num < number.length(); num++) {//traverse number
            System.out.println(" iteration:  " + num);

            int index = Character.getNumericValue(number.charAt(num));//index of each number in mapping

            System.out.println(" index in number:  " + index);

            //main here, from queue length for this iteration
            while (res.peek().length() == num) {//if from linked list length  = index

                String permutation = res.remove();//exctract whats in queue last , will be for index

                System.out.println(" existing permutation:  " + permutation);

                //               abc for 2 , def for 3
                for (char each : char_map[index].toCharArray()) {//each char deom mapping by index
                    //so after first will have a,b,c and here will make a+def , b + def, c +def

                    System.out.println(" char in mapping for index " + index + " is:  " + each);
                    res.add(permutation + each);//existing permutation + current char

                    System.out.println(" permutation + char:   " + permutation + each);
                }
            }

        }
        return res;
    }

}
