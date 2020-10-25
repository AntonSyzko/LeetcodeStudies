package KEVIN_NAUGHTON_JR.misc;

public class PowerOfTwo {
    public static void main(String[] args) {
        boolean res = isPowerOfTwo(16);
        System.out.println(res);
         res = isPowerOfTwo(17);
        System.out.println(res);
    }


    static boolean isPowerOfTwo(int num){
        int i = 1;

        while (i < num){
            i = i*2;
        }
        return i == num;
    }
}
