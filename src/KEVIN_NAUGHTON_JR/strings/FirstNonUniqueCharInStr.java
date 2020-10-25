package KEVIN_NAUGHTON_JR.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonUniqueCharInStr {

    public static void main(String[] args) {
        String str = "loveleetcode";
        int nonUniq = firstNonUniqueChar(str);
        System.out.println(nonUniq);

    }


    static int firstNonUniqueChar(String word){
        Map<Character, Integer> charToItsIndexMap = new HashMap<>();//chars to its index mapa

        for (int index = 0; index < word.length(); index++) {
            char current = word.charAt(index);
            if(!charToItsIndexMap.containsKey(current)){//not in map - unique
                charToItsIndexMap.put(current,index );//map to its index
            }else { // is in map - non unique
                charToItsIndexMap.put(current, -1);//assign just NEGATIVE -1
            }
        }

        int min = Integer.MAX_VALUE;//temp min

        for (char ch : charToItsIndexMap.keySet()){//traverse key set - all chars of mapa
            if(charToItsIndexMap.get(ch) > -1 //more than >  -1 - so only uniques
                    && charToItsIndexMap.get(ch) <  min){//and value is less then current min so far
                min = charToItsIndexMap.get(ch);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
