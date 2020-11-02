package SULEIMANOV;

/*
flower fligh flow = fl
none = ""
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] words = new String[]{"flower", "flight", "flow"};
        String commonPrefLongest = longestCommonPrefix(words);
        System.out.println(commonPrefLongest);
    }

    static String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {//pre checks
            return "";
        }

        String result = words[0];//initially we take very first words as by default common prefix

        //traverse and compare currently common prefix with each word - if NO - decrement common by one from EMD
        for (int i = 0; i < words.length; i++) {

            //returns -1 if NO occurrence and > 0 for where occurred
            while (words[i].indexOf(result) != 0) {//while  MATCH is NOT  there
                result = result.substring(0, result.length() - 1);//decrement current common result - take ONE char from END
                if (result.isEmpty()) {//check if current res is not empty
                    return "";//if so - that is it ""
                }
            }
        }

        return result;//res
    }
}
