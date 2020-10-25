package SULEIMANOV;

public class PalindromeNumber {
    public static void main(String[] args) {
        boolean isPalindrowm = isPalindrome(121);
        System.out.println(isPalindrowm);

         isPalindrowm = isPalindrome(120);
        System.out.println(isPalindrowm);

         isPalindrowm = isPalindrome(-121);
        System.out.println(isPalindrowm);
    }

    static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;//-121 isno tpal by default
        }

        if (num % 10 == 0 && num != 0) {//last 0 is not pal anyways BUT 0 iself is PAL !!!
            return false;
        }


        int invertedNum = 0;
        int copyOfNum = num;//carry copy to maintain original input

        while (copyOfNum != 0) {
            invertedNum = invertedNum * 10 + copyOfNum % 10;//each time * 10 to move number + MOD popped
            copyOfNum = copyOfNum / 10;//every time decrease
        }

        return invertedNum == num;//just compare inverted and original
    }
}
