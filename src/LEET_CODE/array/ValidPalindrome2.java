package LEET_CODE.array;

/*
racecar - palindrome
racetcar - invalid but you can delete ONE charcter - t - racecar - palindrome

 */
public class ValidPalindrome2 {

    public static void main(String[] args) {
        String str = "raceTcar";
        boolean isPalindroome = validPalindromeWithOnePossibleDeletion(str);
        System.out.println(isPalindroome);
    }

    static boolean validPalindromeWithOnePossibleDeletion(String str){
        int start_pointer = 0;
        int end_pointer = str.length()-1;

        while (start_pointer <= end_pointer){
            if(str.charAt(start_pointer) != str.charAt(end_pointer)){
                return normalPalindromeCheck(str, start_pointer+1, end_pointer) //chop of from start pointer ON substring , so deleting ONE char
                        || // OR - so ONLY either one will do
                       normalPalindromeCheck(str, start_pointer, end_pointer-1);//chop of from end pointer DOWN substring , so deleting ONE char
            }

            //move pointers inwards
            start_pointer++;//stat UP
            end_pointer--;// end DOWN
        }
        return true;
    }

    //regulatr palincropme check
    static boolean normalPalindromeCheck(String str, int startFrom, int endWith){
        int start_from_pointer = startFrom;
        int end_with_pointer = endWith;

        while (start_from_pointer <= end_with_pointer){
            if(str.charAt(start_from_pointer) != str.charAt(end_with_pointer)){
                return false;
            }
            //move pointers inwards
            start_from_pointer++;//strt up
            end_with_pointer--;//end down
        }

        return true;//got here OK
    }
}
