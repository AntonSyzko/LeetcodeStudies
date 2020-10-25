package LEET_CODE.array;

import java.util.Stack;

/*
given string number 123451 and k number to delete
return number with smallest possible number after deletion
1231  k = 2  res = delete 2 3 = 11

GREEDY approach - use stack - store nums on stack and when on top of stack is MORE than current - delete
thus smaller walues vill stay
 */
public class RemoveKDigits {
    public static void main(String[] args) {
      String res = removeKDigits("1231",2);
        System.out.println(res);

        String res2 = removeKDigits("1111",3);
        System.out.println(res2);
    }

    static String removeKDigits(String number, int k){
        int size = number.length();

        if(size == k) return "0";//edge case delete all from num = 0

        Stack<Character> stack = new Stack<>();//greedy approcah use it

        int counter = 0;//to trace population of stack in bounds of length

        while (counter< size){

            //GREEDY LOGIC HERE
            while (k >0 //still smth to delete
                    && !stack.isEmpty() //still smth in stack
                    && stack.peek() > number.charAt(counter))//what is currently on top of stack is MORE than given number
            {
                stack.pop();//delete , we need SMALLER numbers on stack at the END, bigger - delete
                k--;//one deletion done - decrease K
            }

            //stack actual population
            stack.push(number.charAt(counter));

            counter++;
        }

        //case of 1111
        while (k>0){ //if aftre above deleteions still smth on stack , meaning nothing was MORE then current values of num
            stack.pop();//just delete
            k--;//deleted - decrease k
        }

        StringBuilder sb = new StringBuilder();//result holder

        while (!stack.isEmpty()){//whats left on stack is oir result
            char current_char = stack.pop();
            sb.append(current_char);
        }

        //trim leading ZEROS
        while (sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }


        sb.reverse();//reverse since stack was LIFO

        return sb.toString();
    }
}
