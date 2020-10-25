package LEET_CODE.QueueStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        boolean isValidPar = isValid("([)]");
        System.out.println(isValidPar);
    }

    public static boolean isValid(String str) {
        //validations
        Map<Character, Character> parenthesesMapping = new HashMap<>();
        parenthesesMapping.put('(', ')');
        parenthesesMapping.put('{', '}');
        parenthesesMapping.put('[', ']');


        Stack<Character> parenthesesStack = new Stack<>();


        for (int i = 0; i < str.length(); i++) {

            char current_char = str.charAt(i);


            if (parenthesesMapping.containsKey(current_char)) {//if current char is one of ([[ is in keys of map
                parenthesesStack.push(current_char);//add to stack
            } else {//char is not of map keys ( not ([{
                if (parenthesesStack.isEmpty()) {//stack is empty - and we have closing brackets - so INVALID straight away
                    return false;
                }

                char target = parenthesesStack.pop();//whats on top of stack

                if (!parenthesesMapping.containsKey(target) //not in KEYS
                        || //OR
                        parenthesesMapping.get(target) != current_char) {// in map by target key IS NOT current
                    return false;
                }
            }
        }

        //if smth left after all string traversed - means invalid
        if (!parenthesesStack.isEmpty()) {
            return false;
        }
        return true;//got here ok
    }

    public static boolean isValid2(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }


}
