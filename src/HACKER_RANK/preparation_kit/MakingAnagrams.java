package HACKER_RANK.preparation_kit;

public class MakingAnagrams {

    public static void main(String[] args) {

        int res = requiredDeletionsToMakeTwoStringsAnagram("cde","cdf");
        System.out.println(res);
    }

    static int requiredDeletionsToMakeTwoStringsAnagram(String a, String b){
        int min_deletions_required = 0;

        int [] a_frequencies = new int [26];// alphabet - all cointers ( 26 of them ) are set to zero
        int [] b_frequencies = new int [26];

        for(int i = 0; i < a.length(); i++){
            char current_char = a.charAt(i);
            int char_to_int = Character.getNumericValue(current_char);
            int position = char_to_int - Character.getNumericValue('a');
            a_frequencies[position]++;// increase occurence of the caharcter
        }

        for(int j = 0; j < b.length(); j++){
            char current_char = b.charAt(j);
            int char_to_int = (int)current_char;
            int position = char_to_int - (int)'a';
            b_frequencies[position] +=1;//same as ++ here
        }

        for( int k = 0; k < 26; k++){
            int diff = Math.abs(a_frequencies[k] - b_frequencies[k]);// 1 - 1 = 0 - so no diff will be added, but 1 -0 or 0 -1 is abs( 1 ) - so diff added
            min_deletions_required += diff;
        }

        return  min_deletions_required;
    }
}
