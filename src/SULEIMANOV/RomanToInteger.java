package SULEIMANOV;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        int res = romanToInt("IX");
        System.out.println(res);
         res = romanToInt("XII");
        System.out.println(res);
         res = romanToInt("XXIX");
        System.out.println(res);
    }

    static int romanToInt(String roman){
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I',1);
        dict.put('V',5);
        dict.put('X',10);//so on till 1000 ....

        int current = 0;
        int prev = 0;
        int total = 0;

        for (int i = 0; i < roman.length(); i++) {
            current = dict.get(roman.charAt(i));
            if(prev < current){
                total = total + current - (prev*2);
            }else {
                total += current;
            }
            prev = current;
        }

        return total;
    }
}
