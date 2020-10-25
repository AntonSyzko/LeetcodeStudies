package LEET_CODE.miscelaneous;

import java.util.HashMap;
import java.util.HashSet;

/*
find most common wod in sentence, not include BANNED word in count
puctuation does NOT matter
return in lower case
 */
public class MostCommonWord {

    public static void main(String[] args) {
        String sentence = "Ball was hit twice, but BALL flew away, anyways !!!";
        String[] banned = {"hit","lol"};
        String most_occured = findMostCommonWord(sentence, banned);
        System.out.println(most_occured);
    }

    static String findMostCommonWord(String sentence, String[] banned){
        HashSet<String> banned_words = new HashSet<>();//store uniques banned
        HashMap<String , Integer> valid_words_count = new HashMap<>();//store occurences of each word

        for(String word : banned){//add to set
            banned_words.add(word);
        }//repelace         banned_words.addAll(Arrays.asList(banned));


        String[] words = sentence.toLowerCase().split("\\W+");//delete punctuation and make aray from sentence

        for (String word : words){
            if(!banned_words.contains(word)){//if not banned
                valid_words_count.put(word, valid_words_count.getOrDefault(word,0)+1);//ad to map
            }
        }

        int max = 0;
        String most_occured_word = "";

        for (String word : valid_words_count.keySet()){//traverse map key set
            if(valid_words_count.get(word) > max){//if occurence more than current MAX
                max = valid_words_count.get(word);//set NEW MAX
                most_occured_word = word;//this is currenclty most occured word
            }
        }


        return most_occured_word;
    }
}
