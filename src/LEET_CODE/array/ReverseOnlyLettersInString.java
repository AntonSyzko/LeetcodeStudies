package LEET_CODE.array;

import java.util.Stack;

/*
ab-tr*fg -> gf-rt*ba
 */
public class ReverseOnlyLettersInString {

    public static void main(String[] args) {


        String original = "ab-tr*fg";
        String reversed = reverseOnlyLettersUsingCounter(original);

        System.out.printf("original %s , reversed %s", original, reversed);
    }

    //using stack
    //O(1)   O(1)
    static String reverseOnlyLetters(String input) {

        Stack<Character> stack = new Stack<>();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {//if only letters
                stack.add(input.charAt(i));//last will be  on top of stack
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                res.append(stack.pop());//from top of stack - last letters will come first
            } else {
                res.append(input.charAt(i));//otherwise - non letters in order
            }
        }

        return res.toString();
    }

    static String reverseOnlyLettersUsingCounter(String input) {
        StringBuilder res = new StringBuilder();

        int index_from_end = input.length() - 1;//grabbing elements form the end

        for (int i = 0; i < input.length(); i++) {

            if (Character.isLetter(input.charAt(i))) {

                while (!Character.isLetter(input.charAt(index_from_end))) {//if from end char is not letter
                    index_from_end--;// ignore it - just traverse backward to letters
                }//othervise we are dealing with letter chars below

                res.append(input.charAt(index_from_end));//append letter char found from end of string

                index_from_end--;//traverse backwards continue

            } else {//if any non letters
                res.append(input.charAt(i));//just append as they appear
            }

        }
        return res.toString();
    }

}
