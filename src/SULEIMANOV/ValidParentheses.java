package SULEIMANOV;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
   String sentence = "({[]})";
   boolean isValid = isValid(sentence);
        System.out.println(isValid);
    }


    static boolean isValid(String sentence){
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(']','[');
        brackets.put('}','{');
        brackets.put(')','(');

        Stack<Character> stackOfOccuredBrakcets = new Stack<>();//add as we go

        for (int i = 0; i < sentence.length(); i++) {
            char current = sentence.charAt(i);

            if(!brackets.containsKey(current)){//if key is NOT in map
                stackOfOccuredBrakcets.push(current);//add to stack to check later math by KEY
            }else {
                char topFromStack = stackOfOccuredBrakcets.isEmpty() ? '?': stackOfOccuredBrakcets.pop();//get from TOP of ctack
                if(topFromStack != brackets.get(current)){//if it is NOT key:value match
                    return false;//false
                }
            }
        }
        return stackOfOccuredBrakcets.isEmpty();//at the end if EMPTY stack - all methced
    }
}
