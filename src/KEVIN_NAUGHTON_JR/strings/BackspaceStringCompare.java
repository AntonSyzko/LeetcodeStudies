package KEVIN_NAUGHTON_JR.strings;

import java.util.Stack;

/*
ab##  a#b# = "" = "" ->  same

abc# abcd## = "ab" = "ab" -> same
# - delete everything before
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
      boolean same = backspaceCompare("ab##","a#b#");
        System.out.println(same);

         same = backspaceCompare("abc#","abcd##");
        System.out.println(same);
    }

    static boolean backspaceCompare(String first, String second){
        Stack<Character> firstStack = new Stack<>();

        for (char each : first.toCharArray()){
            if(each != '#'){
                firstStack.push(each);
            }else if(!firstStack.isEmpty()){
                firstStack.pop();
            }
        }

        Stack<Character> secondStack  = new Stack<>();

        for (char each : second.toCharArray()){
            if(each != '#'){
                secondStack.push(each);
            }else if(!secondStack.isEmpty()){
                secondStack.pop();
            }
        }

        return firstStack.equals(secondStack);

    }
}
