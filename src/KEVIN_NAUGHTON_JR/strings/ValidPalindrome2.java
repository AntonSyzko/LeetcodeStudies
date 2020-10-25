package KEVIN_NAUGHTON_JR.strings;

/*
given string check for palindrome
can remove ONE char
 */
public class ValidPalindrome2 {

    public static void main(String[] args) {

        String input = "abca";
        boolean isPalindrome = validPalindrome(input);
        System.out.println(isPalindrome);
    }


   // runtime O(n)
     //   space O(1)
    static boolean validPalindrome(String input) {
        if (input == null//maybe return false for null
                || input.length() == 1) {//base check
            return true;
        }

        int start = 0;//sliding window pointers
        int end = input.length() - 1;

        while (start < end) {//slide window inside

            if (input.charAt(start) != input.charAt(end)) {//if non equal chars met
                return
                        //check string starting from START + 1 - so skipping this START char , everything after it check
                        isPalindrome(input, start + 1, end)
                        || // OR
                       //check string starting from END -  1 - so skipping this END char , everything after it check
                        isPalindrome(input, start, end - 1);
            }

            start++;//move vindow , can do it with ++
            end--;
        }

        return true;//got here - simple palindrome, since no diff chars met , no subPalindrome removal was needed
    }

    //check substrings for palindrome
    private static boolean isPalindrome(String input, int start, int end) {
        while (start < end) {//sliding window

            if (input.charAt(start) != input.charAt(end)) {//non equal chars met
                return false;//no need to proceed, we  can remove ONE char and we have done it already prior to this point
            }

            start++;//move sliding window inside, cad do it withh ++
            end--;
        }
        return true;
    }
}
