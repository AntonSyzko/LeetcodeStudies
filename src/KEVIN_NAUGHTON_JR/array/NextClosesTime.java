package KEVIN_NAUGHTON_JR.array;

import java.util.HashSet;

/*
given time HH:MM  form the next closes time by REUSING !!!  the current digits
valid 01:34  12 :09
invalid 1:34   12:9

so reusing 19:34 - 19:39
 */
public class NextClosesTime {

    public static void main(String[] args) {

        String time = "19:34";
        String nextTime = nextClosestTime(time);
        System.out.println(nextTime);
    }

    static String nextClosestTime(String time){

        int minutes = Integer.parseInt(time.substring(0,2)) * 60;//substracted hours from input and convert to mins by *6 0
        minutes += Integer.parseInt(time.substring(3));  // add reminder minutes

// store all digits from input to validate is next generated time has digits ONLY  from input to be REUSED
        HashSet<Integer> digits = new HashSet<>();

        for(char ch : time.toCharArray()){
            digits.add(ch - '0');//substracting char 9 - char 0 = int 9, : is 58 - 0 = 10 in chars ( ignore it )
        }

        while (true){//do it till possible to reuse

            //get next time in minutes
            minutes = (minutes+1) //we are  increasing time by one  minute get the next closes time
                    % (24 * 60);//here we check if boundaries like 23:59 go to 00:00 and 12:59 go to 01:00

            //form new time after increasing by 1 minute
            int [] nextTime = {                                        // ex fort 19:34
                      minutes / 60 /10     // hours left digit                like 1
                    , minutes / 60 % 10   // hours right  digit               like 9
                    , minutes % 60 / 10   // minutes left digit                 like 3
                    , minutes % 60 % 10    // mins right digit                     like 4
            };

            boolean isValid = true;//if reusable

            loop:for (int digit : nextTime){ //check every digit in new generated time after adding 1 minute to initial
                    if(!digits.contains(digit)){//if  does not exist in our input digits, NOT REUSABLE - add 1 minute and continue checking
                        isValid = false;//NOT REUSABLE - add 1 minute and continue checking
                        break loop;//stop iterating this incremented by 1 minute time array and form new by adding 1 more minute anch check against it
                }
            }
            if(isValid){//if last is true passed - jsut output res
                return String.format("%02d:%02d", minutes /60,  minutes % 60);//here while true breaks also
            }
        }
    }
}
