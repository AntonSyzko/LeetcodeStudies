package KEVIN_NAUGHTON_JR.strings;

/*
GIVEN BINARY STRINGS
0101 0011

calculate sum
 */
public class AddBinary {
    public static void main(String[] args) {

        String res = addBinary("1010", "1011");
        System.out.println(res);
    }

    static String addBinary(String firstNum, String secNum) {
        StringBuilder sb = new StringBuilder();

        int firstRearIndex = firstNum.length() - 1;//index of first string from end
        int secRearIndex = secNum.length() - 1;//sec from end

        int tenthCarry = 0;//carry tenth

        while (firstRearIndex >= 0 || secRearIndex >= 0) {//traverse going down to zero
            int sum = tenthCarry;//initially and at every iteration sum = carry

            if (firstRearIndex >= 0) {//bundaries pre-check always
                //add to sum from first, -'0' = real value('0'-'0'=0,'1'-'0'=1)
                sum += firstNum.charAt(firstRearIndex) - '0';
                 firstRearIndex--;//decrement index
            }

            if (secRearIndex >= 0) {
                //add to sum from second, -'0' = real value('0'-'0'=0,'1'-'0'=1)
                sum += secNum.charAt(secRearIndex) - '0';
                 secRearIndex--;//decrement index
            }

            //insert always to beginning ( offset 0 ) and what is left afetr MOD 2 ( 1 MOD 2 = 1, 0 MOD 2 = 0, 2 MOD 2 = 0 )
            sb.insert(0, sum % 2);

            tenthCarry = sum / 2;//carry  /2 : 2/2 = 1,   1/2 = 0,   0/2 = 0, so only 2/2 will be carried


        }
        if (tenthCarry > 0) {//if carry left after dealing with last most significant bit - carry it 
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
