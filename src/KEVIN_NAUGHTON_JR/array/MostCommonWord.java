package KEVIN_NAUGHTON_JR.array;

/*
given a paragraph of text, find most commonly occurred word
ignore banned words, ignore case, all non letters,
give result in lower case

Hit the ball, BALL was hit.
banned hit
res ball
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {

    public static void main(String[] args) {
        String res = mostCommonWorld("Hit the ball, BALL was hit.", new String[]{"hit"});

        System.out.println(res);
    }

    static String mostCommonWorld(String paragraph, String[] banned) {

        HashSet<String> bannedWords = new HashSet<>();//banned as set

        Arrays.stream(banned).map(bannedWords::add);//populate set of banned

        //Collections.addAll(bannedWords, banned);//same for set population

        HashMap<String, Integer> counts = new HashMap<>();//occurrences of words met to number of times

        // ignore non letters(, . -) , to lower and split paragraph by " "
        for (String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {

            if (!bannedWords.contains(word)) {//if not in banned set
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        String res = "";//initial fake res

        for (String key : counts.keySet()) {//from keys of occurrences map

            //first time check fake res ""
            // OR if all next occurrence of key is higher than previous
            if (res.equals("") || counts.get(key) > counts.get(res)) {
                res = key;//then key is what met more frequently
            }
        }
        return res;
    }
}
