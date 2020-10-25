package LEET_CODE;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsFromString {

    public static void main(String[] args) {

        System.out.println(removeVowels("anton"));
    }

    static String removeVowels(String input) {
        StringBuilder sb = new StringBuilder();

        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        for (char each : input.toCharArray()) {
            if (!vowelsSet.contains(each)) {
                sb.append(each);
            }
        }

        return sb.toString();
    }
}
