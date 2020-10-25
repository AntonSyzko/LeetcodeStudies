package KEVIN_NAUGHTON_JR;

import java.util.HashMap;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canContain("aa","aab"));//true
        System.out.println(canContain("aaa","aab"));//false
        System.out.println(canContain("aa","bb"));//false



    }

    static boolean canContain(String ransom_note, String magazine) {
        HashMap<Character, Integer> counts = new HashMap<>();//count chars occurences

        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);//add incrementally or set to 0 if none found
        }

        for (char a : ransom_note.toCharArray()) {
            if (!counts.containsKey(a) || counts.get(a) <= 0) {//if no such a char in map or its count is 0 or less ( all used already )
                return false;
            }
            counts.put(a, counts.get(a)-1);//update map - take one occurence  of a char away (-1)
        }

        return true;

    }
}
