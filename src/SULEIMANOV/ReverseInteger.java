package SULEIMANOV;

/*
given 32 bit integer reverse
mind only 32 bit ints - if overflows return 0
-2 ^ 31  to 2 ^ 31 -1
if leading zero scrap

123 - 321
120  - 21
 */
public class ReverseInteger {

    public static void main(String[] args) {


        int res = reverse(123);
        System.out.println(res);

        int res2 = reverse(120);
        System.out.println(res2);

        int res3 = reverse(1233231565);//owerflow
        System.out.println(res3);
    }


    static int reverse(int num) {
        int result = 0;
        while (num != 0) {
            int pop = num % 10;
            num = num / 10;

            //EDGE CASES OF OWERFLOW

//if res > MAX INT ( before future * 10 we check , so /10 OR res = MAX/10 AND pop ( we gonna add next) is more than 7 - owerflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
//if res < MIN INT ( before future * 10 we check , so /10 OR res = MAX/10 AND pop ( we gonna add next) is more than 8 - owerflow

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop > 8)) {
                return 0;
            }

            //aggregate *10 + cutted off pop
            result = result * 10 + pop;

        }
        return result;
    }


}
