package KEVIN_NAUGHTON_JR.strings;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
given char arry, sort by frequency of occurence

tree = eetr or eert
cause e ocurred twice in tree
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
      String sorted = sortByFrequncy("tree");
        System.out.println(sorted);
    }

    static String sortByFrequncy(String word){

        HashMap<Character, Integer> occurencesOfChars = new HashMap<>();//how many tomes each char occured

        for(char each : word.toCharArray()){//populate
            occurencesOfChars.put(each,occurencesOfChars.getOrDefault(each,0)+1);
        }

        //priority by max occurences of chars
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> occurencesOfChars.get(b)-occurencesOfChars.get(a));

        //add all map - will be sorted by max occured chars, !!! but no numbers of how many times- that is in MAP
        maxHeap.addAll(occurencesOfChars.keySet());//eert - but no numbers count

        //res
        StringBuilder sb = new StringBuilder();

        //while smth in max heap
        while (!maxHeap.isEmpty()){

            char current = maxHeap.remove();//withdraw from top - most occured
            //traverse MAP according to number of times this CURRENT char occured in MAP
            for (int i = 0; i < occurencesOfChars.get(current);i++){
                sb.append(current);//this many times of iterations -add to res
            }
        }

        return sb.toString();
    }
}
