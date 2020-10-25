package LEET_CODE.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
given list of strings find common chars
if chars dupicate - give back the mininmum
bella label roller
e l l
 */
public class CommonChars {

    public static void main(String[] args) {
        String[] input = new String[]{"bella", "label","roller"};

        List<String> repeatedChars = commonChars(input);

        System.out.println(repeatedChars);
    }



    static List<String> commonChars(String [] input){

        List<String> res = new ArrayList<>();

        //alphabet occurences frequencies for each letter
        int [] min_frequencies = new int [26];

        //fill initially with MAX
        Arrays.fill(min_frequencies, Integer.MAX_VALUE);

        //for every string in array
        for(String current_string : input){
            //current for each string char frequencies
            int [] current_frequencies = new int[26];//all imitialized with 0

            for(char ch : current_string.toCharArray()){
  //ASCII val is INDEX here, value is times occured [1,2] means letter a occured 1, b - 2
                current_frequencies[ch - 'a']++;
            }
//compare global frequencies and current and choose minimum
            for (int i = 0; i < 26; i++) {
                //rest of unseen chars will be filled with zeros , since current frquencies were initialized with all zeros
                min_frequencies[i]= Math.min(min_frequencies[i], current_frequencies[i]);
            }
        }
//check every min freq and see if duplicates
        for (int i = 0; i < 26; i++) {
            //duplictes, triple
            while (min_frequencies[i]>0){
                res.add(""+ (char)(i+'a'));//to string and from char to ASCII
                min_frequencies[i]--;//met once - decrease
            }
        }

        return res;
    }
}
