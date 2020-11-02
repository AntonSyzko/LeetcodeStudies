package LEET_CODE.array;

/*
given worlds ['words' , 'world', 'row' ] and alines alphabet ['fgfghhjtertrtjfghmjfnbm]
check if words are in lexicographical order
so each letter in next world is sorted alphabetically,
if first world is shorter thatn sec it is not lexicograp

 */
public class AllienAlphabet {

    public static void main(String[] args) {
        String[] words = {"world", "row"};
        String alienAlphabetOrder = "fgfghhjtertrtjfghmjfnbm";

       boolean isSorted = isAlienSorted(words, alienAlphabetOrder);
        System.out.println(isSorted);
    }


    static int[] char_map = new int[26];

    static boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < order.length(); i++) {
            char_map[order.charAt(i) - 'a'] = i;//populate char map by order of char and position in alphabet
        }

        for (int i = 1; i < words.length; i++) {
            if (compareTwoWords(words[i - 1], words[i]) > 0) {//compare both words char by char next to each other ( i-1, i)

                return false;
            }

        }

        return true;

    }

    static int compareTwoWords(String word1, String word2) {
        int indexWord1 = 0;
        int indexWord2 = 0;
        int char_compare_val = 0;

        while (indexWord1 < word1.length() && indexWord2 < word2.length() && char_compare_val == 0) {

            char_compare_val = char_map[word1.charAt(indexWord1)-'a'] - char_map[word2.charAt(indexWord2)-'a'];

            indexWord1++;
            indexWord2++;
        }

        if (char_compare_val == 0) {//char val not changed - so all were same within length
            return word1.length() - word2.length();//length diff is the answer
        } else {
            return char_compare_val;//res
        }
    }
}
