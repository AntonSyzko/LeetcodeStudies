package KEVIN_NAUGHTON_JR.array;

public class ValidAnagram {

    public static void main(String[] args) {
        boolean anagram = isValidAnagram("anagram","nagaram");
        System.out.println(anagram);
        anagram = isValidAnagram("car","cat");
        System.out.println(anagram);
    }

    static boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()){//different length apriori not an anagram
            return false;
        }

        int [] alphabet = new int [26];//store occurences of each letter in strings

        for (int charac = 0; charac < s.length(); charac++) {//any string since length is same
            alphabet[s.charAt(charac)-'a']++;//traversing first increase occurences
            alphabet[t.charAt(charac)-'a']--;//traversing sec decrease
            //if anagram res will be zero (0) +1 : -1 = 0
        }

        for (int letterOccurences : alphabet){//cheack alphabet
            if(letterOccurences !=0){//not a zero - means some lettrs occured more in either of the strings
                return false;
            }
        }
        return true;//got here - true
    }
}
