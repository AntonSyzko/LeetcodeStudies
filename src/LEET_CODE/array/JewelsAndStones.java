package LEET_CODE.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAABBBB";
        int jewels_count = countJewelsInStonesSet(jewels, stones);
        System.out.println(jewels_count);
    }

    static int countJewelsInStones(String jewels, String stones) {
        int jewels_counter = 0;

        for (int stone = 0; stone < stones.length(); stone++) {
            if (jewels.indexOf(stones.charAt(stone)) > -1) {
                jewels_counter++;
            }
        }
        return jewels_counter;
    }

    // runt O(m + n ) jewels and stones  
    static int countJewelsInStonesSet(String jewels, String stones) {
        int res = 0;

        Set<Character> jewelsSet = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            jewelsSet.add(c);
        }
        for (char c : stones.toCharArray()) {
            if (jewelsSet.contains(c)) {
                res++;
            }
        }
        return res;
    }
}
