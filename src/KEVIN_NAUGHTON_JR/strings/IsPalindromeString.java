package KEVIN_NAUGHTON_JR.strings;

/*
ignore all NON alpha numberic chars - compare ONLY by char or digit
ignore case , all lower

 */
public class IsPalindromeString {

    public static void main(String[] args) {
        String sentecne = "A man, a plan, a canal: Panama";
        boolean isPalindrope = isPalindrome(sentecne);
        System.out.println(isPalindrope);

        String sentecne2 = "for you";
        boolean isPalindrope2 = isPalindrome(sentecne2);
        System.out.println(isPalindrope2);
    }


    static boolean isPalindrome(String input) {
        int start = 0;//sliding window
        int end = input.length() - 1;

        while (start < end) {//check window boundaries

            //always precheck boundaroies
            while (start < end && !Character.isLetterOrDigit(input.charAt(start))) {//not alpha numneric at start
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(input.charAt(end))) {//non alpha numeric at end
                end--;
            }

            if (start < end // if still in boundaries
                    && Character.toLowerCase(input.charAt(start++)) != Character.toLowerCase(input.charAt(end--))) {//non mathcing chars
                return false;
            }
        }

        return true;//got here true
    }
}

