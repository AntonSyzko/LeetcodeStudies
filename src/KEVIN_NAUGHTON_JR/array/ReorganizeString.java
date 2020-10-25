package KEVIN_NAUGHTON_JR.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
reorganize string so that there are no two same adjacent chars
aab -> aba
if impossible - return emty string
aaab - > ""

GREEDY
 */
public class ReorganizeString {

    public static void main(String[] args) {


        String original = "aab";
        String reorganized = reorganizeString(original);
        System.out.println("original  : " + original + "\r\n reorganized: "+ reorganized);
    }

    static String reorganizeString(String original){
        Map<Character, Integer> chars_occurences_count = new HashMap<>();//map of occurences of each char <char, times_occured>
        for( char each_char : original.toCharArray()){
            chars_occurences_count.put(each_char, chars_occurences_count.getOrDefault(each_char,0)+1);//populate map
        }

        PriorityQueue <Character> max_heap = new PriorityQueue<>(//max occurences heap - for  GREEDY approach
                (ch, next_char) -> chars_occurences_count.get(next_char)-chars_occurences_count.get(ch));//max - so second - first , largets go first - greedy !!!

        max_heap.addAll(chars_occurences_count.keySet());//populate max heap

        StringBuilder result = new StringBuilder();

        while (max_heap.size() >1){//while smth before lats
            char current = max_heap.remove();//get from max heap - remove it
            char next_current = max_heap.remove();//get ( remove ) from heap
            result.append(current);
            result.append(next_current);

            chars_occurences_count.put(current,chars_occurences_count.get(current)-1);//refresh map - decrease of char occurence count -1
            chars_occurences_count.put(next_current, chars_occurences_count.get(next_current)-1);//refresh map - decrease of char occurence count -1

            if(chars_occurences_count.get(current)>0){//if still this char count more than 0
                max_heap.add(current);//update max heap - add char back to max heap
            }
            if(chars_occurences_count.get(next_current)>0){
                max_heap.add(next_current);//update heap if still in count map - add to max heap
            }
        }

        if(!max_heap.isEmpty()){//if heap still has smth
            char stillPresentCharInHeap = max_heap.remove();//withdraw
            if(chars_occurences_count.get(stillPresentCharInHeap) >1){//check counter map - how many of this chars are there still
                return "";//more than 1 - false - return empty string
            }
            result.append(stillPresentCharInHeap);//was last ( not more than one of this char in count map , OK just appned to reuslt
        }

        return result.toString();//OK
    }
}
