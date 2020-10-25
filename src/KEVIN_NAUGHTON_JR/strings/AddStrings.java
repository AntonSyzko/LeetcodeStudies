package KEVIN_NAUGHTON_JR.strings;

/*
given two nums as strings - return sum
mind carry - perenos of 10
12 + 100 = 112
 */
public class AddStrings {

    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "123";

        String sum = sumTwoStringNumbers(num1, num2);
        System.out.println(sum);
    }

    static String sumTwoStringNumbers(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int num1_from_end = num1.length() - 1;//starting from the end of number - since we always start adding last digits from number
        int num2_from_end = num2.length() - 1;//we add starting from 1 to 10 to 100 to 1000 and so on ...., from the END
        int tenth_carry = 0;//tenths perenos

        while (num1_from_end >= 0 || num2_from_end >= 0) {//while any of two nums still >= zero

            int current_sum = tenth_carry;//start sum = carry = 0

            if (num1_from_end >= 0) {//cause nums can be non equal , so need to check separately each loop run
                current_sum += num1.charAt(num1_from_end) - '0';//ASCII diif to cha '0' - will give Int representation of string num
                num1_from_end--;//decremet to move from the end of num to start
            }

            if (num2_from_end >= 0) {//cahcek each time, nums are not necessarily equal
                current_sum += num2.charAt(num2_from_end--) - '0';//ASCII diff to char '0' = int of num '5' - '0' = 5
            }

            res.append(current_sum % 10);//appending ONLY last of sum, not carrying CARRY - CARRY will go to next computation
            tenth_carry = current_sum / 10;//carry is how much more then 9 we have to carry on ex: ( 12 + 10) = 22 / 10 = 2 carry is 2


            if (tenth_carry != 0) {//if at the end carry still has carried
                res.append(tenth_carry);//just add - this will increase num by level from 10 to 100  or from 100 to 1000
            }
        }

        return res.reverse().toString();//since we have started from the end - our result is reversed - correct num - is viseversa

    }
}
