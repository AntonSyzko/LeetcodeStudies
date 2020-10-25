package LEET_CODE.String;

import java.util.HashSet;

/*
given string  find longest substring where characters are not repeated
abcabcbb = 3 ( abc)
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int longestSub = longestNonRepeatingSubstring("abcabcbb");
        System.out.println(longestSub);
    }


    static int longestNonRepeatingSubstring(String input){
        int first_poinetr = 0;//sliding window
        int second_pointer= 0;
        int max = 0;//res

        HashSet<Character> charsOccuredUniquely = new HashSet<>();//store uniques

        while (second_pointer<input.length()){//traverse sliding window second moves first

            if(!charsOccuredUniquely.contains(input.charAt(second_pointer))){//not  in set ?
                charsOccuredUniquely.add(input.charAt(second_pointer));//add to set
                second_pointer++;//raise second poinetr
                max = Math.max(max, charsOccuredUniquely.size());//update max
            } else {//in set already ?
                //!!! max keeps whatever was max
                charsOccuredUniquely.remove(input.charAt(first_poinetr));//remove by first
                first_poinetr++;//raise first
            }
        }
        return max;
    }
}
