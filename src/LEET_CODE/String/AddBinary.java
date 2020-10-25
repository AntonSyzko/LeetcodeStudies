package LEET_CODE.String;

/*
GIVEN BINARY STRINGS
0101 0011

calculate sum
 */

public class AddBinary {
    public static void main(String[] args) {
        String res = addBinary("11", "1");
        System.out.println(res);
    }

    static String addBinary(String first, String second) {
        StringBuilder sb = new StringBuilder();

        int firstRearIndex = first.length() - 1;//index from end
        int secRearIndex = second.length() - 1;

        int tenthCarry = 0;

        while (firstRearIndex >= 0 || secRearIndex >= 0) {//traverse
            int sum = tenthCarry;//init with carry and carry adds each time iteration

            if (firstRearIndex >= 0) {//boundaries pre check always
                sum += first.charAt(firstRearIndex) - '0';//add to sum last significant index - '0'= number ( '1'-'0'=1, '0'-'0'=0)
                firstRearIndex--;//decrement
            }

            if (secRearIndex >= 0) {//boundaries pre check always
                sum += second.charAt(secRearIndex) - '0';//add to sum last significant index - '0'= number ( '1'-'0'=1, '0'-'0'=0)
                secRearIndex--;//decrement
            }

            sb.append(sum % 2);//append MOD 2, 2 MOD 2 = 0, 1 MOD 2 = 1, 0 MOD 2 = 0
            tenthCarry = sum / 2;// 2 / 2 = 1 to carry , rest = 0 1/2 = 0, 0/2 = 0


        }

        if (tenthCarry != 0) {//if  carry left after last iteration
            sb.append(tenthCarry);//add it
        }
        return sb.reverse().toString();//reverse cause we were adding to start
    }
}
