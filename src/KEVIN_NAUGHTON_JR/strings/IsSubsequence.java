package KEVIN_NAUGHTON_JR.strings;

/*
return bool if given string is subsequence of another
subsequence is when all the chars ( can be none ) in given appear in same relative order as in another

ace  ancle  true
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String given = "ace";
        String template = "ancle";
        boolean isSubsequence = isSubsequence(given, template);
        System.out.println(isSubsequence);
    }

    static boolean isSubsequence(String given, String template){
        if(given.equals(""))  return true;//if given is NONE - is OK, since nothing to compare with is OK

        int given_traverse_index = 0;//to go through given and match order

        //comparing with index guarantees that relative order is preserved
        //since we increase given index and template as we go by ++
        for (int i = 0; i < template.length() ; i++) {
            //if char occured in this iteration  in given and template same
            if(given.charAt(given_traverse_index)==template.charAt(i)){
                given_traverse_index++;//just increase given index
            }

            //when given index reached the VERY length of given string - IT'S OVER - DONE
            //no need to traverse the template anymore ( it can be up to 500000)
            if(given_traverse_index>=given.length()){
                return true;
            }
        }

        return false;//got here - order was not same or chars did not met
    }
}
