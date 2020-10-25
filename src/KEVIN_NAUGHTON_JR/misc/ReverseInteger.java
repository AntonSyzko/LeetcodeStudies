package KEVIN_NAUGHTON_JR.misc;

/*
321 = 123
-321 = -123
120 = 21
if overflow int - return 0
 */
public class ReverseInteger {
    public static void main(String[] args) {
       int rev = reverseInt(123);
        System.out.println(rev);

         rev = reverseInt(-123);
        System.out.println(rev);

         rev = reverseInt(120);
        System.out.println(rev);

         rev = reverseInt(1234567897);
        System.out.println(rev);
    }


    static int reverseInt(int num) {
        boolean negative = false;

        if (num < 0) {
            negative = true;//set negative flag to TRUE
            num *= -1;//multiply -1 = makes positive
        }

        long reversed = 0;//res

        while (num > 0) {//till num
            reversed = (reversed * 10) + (num % 10);//tenth carrier + remainder of MOD 10
            num /= 10;//each step deivide num /10
        }

        if (reversed > Integer.MAX_VALUE) {//int overflow chack
            return 0;
        }
        return negative ? (int) (-1 * reversed) : (int) reversed;//if negative flag set = * -1 to have -
    }
}
