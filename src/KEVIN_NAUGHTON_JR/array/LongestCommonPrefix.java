package KEVIN_NAUGHTON_JR.array;

/*
flow flower flight = fl
none = ""
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = {"flow", "flower","flight"};
        String longestCommonPrefix = longestPrefix(words);
        System.out.println(longestCommonPrefix);
    }

    //O(n) where n is num of ALL chars in all words, or O(m*n) where n - words - m - chars in each word
    static String longestPrefix(String[] words){
        String longestCommonRes = "";//res
        if(words == null || words.length==0){//pre -check
            return longestCommonRes;
        }

        int compareIndex = 0;//index to compare chars in words

        for (char ch : words[0].toCharArray()){//for every char in FISRT word of array
            //strat i=1 not to compare word ( index0 ) to itself since above for each loop has it already
            for (int i = 1; i < words.length ; i++) {//traverse ALL words of array starting from SECOND element

                if(compareIndex >= words[i].length() //if compare index > current iteration word length -> out of bounds
                        || //OR
                        ch != words[i].charAt(compareIndex)){// char from first word NOT matching current word char by compare index

                    return longestCommonRes;//return what we have so far already
                }
            }
            longestCommonRes += ch;//got here - jusr aggreagte chars - add to res
            compareIndex++;//raise compare index to proceed
        }

        return longestCommonRes;
    }
}
