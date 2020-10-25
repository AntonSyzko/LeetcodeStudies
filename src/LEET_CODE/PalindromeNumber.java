package LEET_CODE;

public class PalindromeNumber {

    public static void main(String[] args) {

        boolean isPalindrome = isPalindrome2(1221);
        System.out.printf(" is palindrome %d - %b", 1221, isPalindrome);
        System.out.println(" \r\nis string a palindropme " + isPalindropmeString("race cAr"));
        System.out.println(" is string a palindropme " + isPalindropmeString("race a cAr"));

    }

    static boolean isPalindrome2(int numba) {
        if (numba == 0) return true;
        if (numba < 0 || numba % 10 == 0) return false;

        int reversed_half = 0;

        while (numba > reversed_half) {
            int pop_last_digit = numba % 10;
            numba = numba / 10;
            reversed_half = (reversed_half * 10) + pop_last_digit;
        }

        if (numba == reversed_half || numba == reversed_half / 10) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPalindrome(int numba) {
        if (numba == 0) return true;

        if (numba < 0 || numba % 10 == 0) return false;

        int reversed_half = 0;
        while (numba > reversed_half) {
            int pop_last_digit_of_the_number = numba % 10;
            numba /= 10;
            reversed_half = (reversed_half * 10) + pop_last_digit_of_the_number;
        }

        if (numba == reversed_half || numba == reversed_half / 10) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPalindropmeString(String input) {
        if(input == null) return false;

        if(input.length()==1) return true;

        input = input.trim().toLowerCase().replaceAll(" ","");//no spaces, all same case

        int start = 0;
        int end = input.length()-1;

        while (start<=end){//will stop at half - faster
            if(input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }

        return true;

        }
    }
