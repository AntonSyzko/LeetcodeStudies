package LEET_CODE.array;

import java.util.Stack;

/*
2[ac]21[bd]
acacbdbdbdbd........
 */
public class DecodeString {
    public static void main(String[] args) {
        String encoded = "2[ac]10[t]";
        String decoded = decode(encoded);
        System.out.println(decoded);
    }

    static String decode(String encoded) {
        String decoded = "";
        Stack<Integer> counts = new Stack<>();
        Stack<String> innerStrings = new Stack<>();
        int index = 0;

        while (index < encoded.length()) {
            if (Character.isDigit(encoded.charAt(index))) {//if number
                int count = 0;
                while (Character.isDigit(encoded.charAt(index))) {//case of non single like 20 23 5000
                    count = 10 * count + (encoded.charAt(index) - '0');
                    index +=1;
                }
                counts.push(count);

            } else if (encoded.charAt(index) == '[') {
                innerStrings.push(decoded);
                decoded = "";
                index +=1;
            } else if (encoded.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(innerStrings.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(decoded);
                }
                decoded = temp.toString();
                index +=1;
            } else {
                decoded += encoded.charAt(index);
                index +=1;
            }

        }
        return decoded;

    }

}
