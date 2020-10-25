package SULEIMANOV;

import java.math.BigInteger;
import java.util.Base64;

/*
0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/    64
 */
public class Base62Encode {

    public static void main(String[] args) {
        String hash62 = encodeBase62(83639963);
        System.out.println(hash62);

    }

    static String encodeBase62(int num) {
        final int base = 62;
        final String coders = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String hashRes = "";

        while (num > 0) {
            int rand = num % base;
            hashRes = coders.toCharArray()[rand] + hashRes;
            num /= base;

        }
        return hashRes;
    }


    static String encodeBase64(int num) {
        int base = 64;
        String coders = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        String hashRes = "";

        while (num > 0) {
            int rand = num % base;
            num /= base;
            hashRes = coders.toCharArray()[rand] + hashRes;
        }
        return hashRes;
    }
}
