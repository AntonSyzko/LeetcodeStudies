package LEET_CODE;

public class RunLengthEncoding {

    public static void main(String[] args) {

        String unencoded = "AAAABBBCCDAA";//4A3B2C1D2A
        System.out.println(encodeString(unencoded));
    }

        static String encodeString(String unencoded){
        String encodedString = "";
        int count = 1;
        char currentChar = unencoded.charAt(0);

        for(int i = 1; i < unencoded.length(); i++){
            char nextChar = unencoded.charAt(i);

            if(nextChar == currentChar){
                count ++;
            }else{

                encodedString += String.valueOf(count) + currentChar;
                count=1;
                currentChar = nextChar;
            }

        }

        encodedString += String.valueOf(count) + currentChar;

        return encodedString;

    }
}
