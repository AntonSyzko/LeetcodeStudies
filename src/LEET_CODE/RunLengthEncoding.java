package LEET_CODE;

public class RunLengthEncoding {

    public static void main(String[] args) {

        String unencoded = "AAAABBBCCDAA";//4A3B2C1D2A
        System.out.println(encodeString(unencoded));
    }

    static String encodeString(String unencoded) {

        String encodedString = "";//res
        int count = 1;
        char currentChar = unencoded.charAt(0);

        //from 1 since we have  first in variable
        for (int i = 1; i < unencoded.length(); i++) {

            char nextChar = unencoded.charAt(i);

            if (nextChar == currentChar) {//same chars

                count++;//same count ++

            } else {//different chars

                encodedString += String.valueOf(count) + currentChar;//aggregate what we have  so far

                count = 1;//reset count to 1 ( new char is foind so it is 1 here already )

                currentChar = nextChar;//reset curr char to this here found new one
            }

        }

        //final aggregation
        encodedString += String.valueOf(count) + currentChar;

        return encodedString;

    }
}
