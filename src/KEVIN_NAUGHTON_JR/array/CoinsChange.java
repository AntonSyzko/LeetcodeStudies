package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;

/*
given infinite number of coins of certain value and target amount -
calculate smallest amount of coins needed to form the target or return -1
DYnamic programming - break to samllest and use chunks
 */
public class CoinsChange {

    public static void main(String[] args) {
        int [] coins = new int [] {1,2,5};
        int target = 11;
        int num_of_coins_needed = coinsChange(coins, target);
        System.out.println(num_of_coins_needed);


    }

    // runtime O( coins * amount )  , sapce  O( amount)
    static int coinsChange(int[] coins, int amount){
        Arrays.sort(coins);//speed up average  case, optimization to stop after amount exceeded see below

        //dynamic programming - here alla the variations for sub amount stored
        int [] dynamic_storage = new int [amount+1];//cause we are 0 based so +1

        Arrays.fill(dynamic_storage, amount+1);//pre-fill
        dynamic_storage[0]=0;//to form 0 cents - 0 coins needed

        for( int sub_amount = 0; sub_amount <= amount ; sub_amount++){//all sub amoints : 1.2.3.4 cents etc .....
            for(int the_coin = 0; the_coin < coins.length; the_coin++){
                if(coins[the_coin] <= sub_amount){ // if nominal of current coins is less than amount
                    dynamic_storage[sub_amount] =
                            Math.min(//min of 
                                    dynamic_storage[sub_amount],//current amount as we go
                              1 + //since we are taking away one coin
                             dynamic_storage[//from this very dynamic array - calculated before
                                     sub_amount //subamount we are calculating for
                                     - coins[the_coin]]);//minus current to loop  coin value
                } else {//if nominal of current coin is higher than amount
                    break;//stop looping - cause we are sorted - all following are higer also and cannot be used to form amount anyways
                }
            }
        }

        return dynamic_storage[amount] > amount ? -1 : dynamic_storage[amount];//if aonly higher nominals got to dynamic array - so cant form amount - 1
    }
}
