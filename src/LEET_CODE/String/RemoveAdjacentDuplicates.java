package LEET_CODE.String;

/*
given a  string remove adjacent duplicates
abbaca
bb - remove, aaca - aa remove - aca
 */
public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
     String res = removeDuplicates("abbaca");
        System.out.println(res);
    }

    static String removeDuplicates(String input){

        char[] stack = new char[input.length()];//to store elements as we add them as we traverse
        int indexInStack = 0;//pointer to top of stack

        for (int i = 0; i < input.length(); i++){//traverse input

            char currentChar = input.charAt(i);

            if(indexInStack > 0 //if smth in stack at all AND
                    && stack[indexInStack-1] ==  currentChar){ // on top of stack equals current char
                indexInStack --;//decrement top of stack - kind of remove element ( although it stays )
            }else {
                stack[indexInStack] = currentChar;//push to stack
                indexInStack++;//increase top
            }
        }

        return new String(stack,0, indexInStack);//answer as string from char array
    }
}
