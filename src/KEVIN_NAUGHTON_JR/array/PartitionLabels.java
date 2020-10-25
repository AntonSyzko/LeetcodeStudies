package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.List;

/*
given string
make partitions so that each letter can occur only in one partition
ababbcdcdefef
res ababb  cdcd efef

basically start char - it;s last occurence in string is the end of partition
unless smth within this has occured after ( ababb ) - last b was after a, so end of pertitoon moved one digit up

 */
public class PartitionLabels {

    public static void main(String[] args) {
   String input = "ababbcdcdefef";

   List<Integer> partitions = partitions(input);

        System.out.println(partitions);
    }


    // time O(n) 2*n = 2 ignore   space O(1) 26 spopts for chars
    static List<Integer> partitions(String input){
        List<Integer> partitionLengths = new ArrayList<>();//res

        int[] lastIndexesOfCharOccurence = new int [26];

        //dynamic prog - store last occurences of each char in string in array , alphabet
        for(int i = 0; i < input.length(); i++){
            lastIndexesOfCharOccurence[input.charAt(i)-'a'] = i;//ASCCI char diff to it's index
        }

        int start_partition = 0;

        while (start_partition < input.length()){
   //partition ends when last occurence of starting char was met
            int end_of_partition = lastIndexesOfCharOccurence[input.charAt(start_partition)-'a'];//from alphabet's index of last occurence

            int next_char = start_partition;//next to start comparing
//check if any char withinh pertition occures after the current END, if so - move end to that char
            while (next_char != end_of_partition){
                end_of_partition = Math.max(end_of_partition,lastIndexesOfCharOccurence[input.charAt(next_char)-'a']);//if curr char is further than initial pertiton END
                next_char++;//increment next to traverse within the  current partition , to reach the while condition exit
            }
//next was where we ended , so end - start ( always start of partiton ) + 1 ( cauze we are zero based )
            partitionLengths.add(next_char - start_partition + 1);//store current partition in res
            start_partition = next_char +1;//start of the NEXT partition here, we ended at NEXT - so add 1 to start NEW partition

        }

        return partitionLengths;
    }
}
