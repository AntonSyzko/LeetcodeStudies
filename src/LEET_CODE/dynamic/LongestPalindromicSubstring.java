package LEET_CODE.dynamic;

/*
Given a string s, find the longest palindromic substring in s.

Example:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        String input = "babad";
        String logestPalindromeSubstring = findLongestPalindromicSubstring(input);
        System.out.println(logestPalindromeSubstring);
    }

    private static String findLongestPalindromicSubstringDynamic(String input) {
        if(input.isEmpty()) {
            return "";
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];

        for(int j = 0; j < n; j++) {
            palindrom[j][j] = true;
            for(int i = 0; i < j; i++) {
                if(input.charAt(i) == input.charAt(j) && (j-i <= 2 || palindrom[i+1][j-1])) {
                    palindrom[i][j] = true;
                    if(j-i+1 > longestSoFar) {
                        longestSoFar = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return input.substring(startIndex, endIndex+1);
    }

    // non dynamic O(n2)
    private static String findLongestPalindromicSubstring(String input) {
        if( input == null ||input.length()<1)  return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i <input.length() ; i++) {
            int len1 = expandFromMiddle(input, i, i);//same case abba
            int len2 = expandFromMiddle(input, i ,i+1);//uneven cases racecar

            int longestLen = Math.max(len1, len2);//one will be correct - it's max will become longest

            if(longestLen > end - start){
                start = i - ((longestLen-1)/2);//setting strat
                end   = i + (longestLen/2);    // setting end
            }
        }

        return input.substring(start, end+1);//+1 indexes matter
    }

    private static int expandFromMiddle(String input, int left, int right){
        if(input == null ||left > right) return 0;// precheck

        while (left >= 0 && right <input.length() && //bounds
                input.charAt(left)==input.charAt(right)){ // expanding from miidle and chars equals
            left++;//if booleans OK - just expand
            right--;
        }

        return right - left - 1;//at tend - just index of start of longest
    }

    }
