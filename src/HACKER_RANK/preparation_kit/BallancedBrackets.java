package HACKER_RANK.preparation_kit;

import java.util.Stack;

public class BallancedBrackets {

    public static void main(String[] args) {
        String input = "{}[]()";
        boolean res = isBalanced(input);

        System.out.println(" ballanced ? : " + res);
    }

    static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){

            if(input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{'){
                stack.push(input.charAt(i));
            } else{
                if (stack.isEmpty()) return false;

                   char currentChar =  stack.pop();
                   if(input.charAt(i)  == '}' && currentChar != '{'){
                       return   false;
                   }
                    if(input.charAt(i)  == ')' && currentChar != '('){
                        return   false;
                    }
                    if(input.charAt(i)  == ']' && currentChar != '['){
                        return   false;
                    }
                }
            }


        return stack.isEmpty();
    }
}
