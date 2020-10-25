package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
given array of anagrams sort em together
     input
[eat tea eta nat tan bat]
    answer
[eat tea eta]
[nat tan]
[bat]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = {"eat","tea","eta","tan","nat","bat"};
        List<List<String >> groupedAnagrams = groupAnagrams(input);
        groupedAnagrams.stream().forEach(System.out::println);
    }


    //  O(N * M * logM)  N - max num ow words, M - largest size of word ( since we sorting )
    static List<List<String>> groupAnagrams(String[] input){

        List<List<String>> groupedAnagrams = new ArrayList<>();//res
        HashMap<String, List<String >> map = new HashMap<>();//map of sorted word to it's variations ( aet : [tea, eta,ate]

        for(String each : input){
            char[] characters = each.toCharArray();//to char to sort
            Arrays.sort(characters);//sort
            String sortedWord = new String(characters);//convert to string back

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());//sorted word to empty list for now here
            }

            map.get(sortedWord).add(each);//key - sorted word : ADD HERE value - current variation anagram ( each )
        }

        groupedAnagrams.addAll(map.values());//add all values ( array lists of variations by sorted word ) tp res

        return groupedAnagrams;//res
    }
}
