package LEET_CODE;


public class ReverseInteger {

    public static void main(String[] args) {
        int resversed = reverseInteger(-128);
        System.out.println(resversed);

    }

    static int reverseInteger(int input) {
        if (input <= 9 && input >= -9) return input;

        int res = 0;
        int pop = 0;

        while (input != 0) {
            pop = input % 10;
            input /= 10;

            if (res >= Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            if (res <= Integer.MIN_VALUE && pop < -8) {
                return 0;
            }
            res = (res * 10) + pop;
        }
        return res;
    }
}
