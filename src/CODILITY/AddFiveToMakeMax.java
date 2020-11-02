package CODILITY;


public class AddFiveToMakeMax {

    public static void main(String[] args) {
        int test = -999;
        int resFive = addedFive(test);
        System.out.println(resFive);
    }


    static int addedFive(int N) {
        boolean sign = N < 0;
        String resultAsString = "";

        if (!sign) {//positive  num
            String temp = String.valueOf(N);//int as string
            for (int i = 0; i < temp.length(); i++) {//traverse all characters
                int currentInt = Integer.parseInt(String.valueOf(temp.charAt(i)));//exctract current
                if (5 > currentInt) {// more than 5
                    resultAsString = temp.substring(0, i) + "5" + temp.substring(i);
                    break;
                }
            }

            if (resultAsString.length() == 0) {//was empty or 0
                resultAsString += "5";
            }

        } else {//negative num
            String temp = String.valueOf(N * -1);//extract num as string / make positive * -1
            for (int i = 0; i < temp.length(); i++) {
                int currentInt = Integer.parseInt(String.valueOf(temp.charAt(i)));
                if (5 < currentInt) {//less than 5
                    resultAsString = temp.substring(0, i) + "5" + temp.substring(i);
                    break;
                }


            }
        }

       //return minding sign
        return sign ? Integer.parseInt(resultAsString) * -1 : Integer.parseInt(resultAsString);


    }


}
