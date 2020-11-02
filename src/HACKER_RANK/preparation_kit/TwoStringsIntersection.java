package HACKER_RANK.preparation_kit;

import java.util.HashSet;

public class TwoStringsIntersection {

    public static void main(String[] args) {
        boolean res = intersects("cat", "byh");
        System.out.println(res);
    }

    static boolean intersects(String a, String b) {
        HashSet<Character> first_string_chars_set = new HashSet<>();
        HashSet<Character> second_string_chars_set = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            first_string_chars_set.add(a.charAt(i));//add all unique chars of string to set
        }

        for (int j = 0; j < b.length(); j++) {
            second_string_chars_set.add(b.charAt(j));
        }

        first_string_chars_set.retainAll(second_string_chars_set);//if chars of first don't exist in second - they will be removed - sp only common stays

        if (!first_string_chars_set.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    static boolean intersects2(String a, String b) {
        HashSet<Character> first_string_chars_set = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            first_string_chars_set.add(a.charAt(i));//add all unique chars of string to set
        }

        for (int j = 0; j < b.length(); j++) {
            if (first_string_chars_set.contains(b.charAt(j))) {
                return true;//already in FIRST set ?
            }
        }
        return false;//no intersection
    }
}
