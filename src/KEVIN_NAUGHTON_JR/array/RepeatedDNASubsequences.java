package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
AACCTTAACCTTBG
AACC - repeated 2
TT repeated 2
 */
public class RepeatedDNASubsequences {
    public static void main(String[] args) {
        String dna = "AAAAACCCCCBBBBBAAAAACCCCCTTTTT";
        findRepeatedDNASequences(dna).forEach(System.out::println);
    }

    //O(n)  O(n)
    static List<String> findRepeatedDNASequences(String dna){
        List<String> res = new ArrayList<>();//res

        Map<String, Integer> seenDna = new HashMap<>();//store occurences of dna

        int subsequence_start = 0;

        while (subsequence_start + 10 <= dna.length()){//boundaries

            String dna_subsequence = dna.substring(subsequence_start, subsequence_start +  10);//++ can go here

            subsequence_start++;//increment start ( can go above )

            seenDna.put(dna_subsequence, seenDna.getOrDefault(dna_subsequence, 0)+ 1);//populate map

            if(seenDna.get(dna_subsequence)==2){// == 2 means we dont care how many times - more than 2 is enough to put to res
                res.add(dna_subsequence);
            }
        }

        return res;
    }
}
