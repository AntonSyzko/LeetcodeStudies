package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
given infinite number of coins of certain value and target amount -
calculate smallest amount of coins needed to form the target or return -1
dynamic programming - break to smallest and use chunks
 */
public class CoinsChange {

    public static void main(String[] args) {
//        int[] coins = new int[]{1, 2, 5};
//        int target = 11;
//        int num_of_coins_needed = coinsChange(coins, target);
//        System.out.println(num_of_coins_needed);

        List<Integer> ini = new ArrayList<>();
        ini.add(1);
        ini.add(5);
        ini.add(10);


        List<Integer> coinsss = getFewestCoinsForAmount(ini,10);
        System.out.println(coinsss);
    }

    // runtime O( coins * amount )  , space  O( amount)
    static int coinsChange(int[] coins, int amount) {
        Arrays.sort(coins);//speed up average  case, optimization to stop after amount exceeded see below

        //dynamic programming - here alla the variations for sub amount stored
        int[] dynamic_storage = new int[amount + 1];//cause we are 0 based so +1

        Arrays.fill(dynamic_storage, amount + 1);//pre-fill
        dynamic_storage[0] = 0;//to form 0 cents - 0 coins needed

        for (int sub_amount = 0; sub_amount <= amount; sub_amount++) {//all sub amoints : 1.2.3.4 cents etc .....

            for (int the_coin = 0; the_coin < coins.length; the_coin++) {

                // if nominal of current coins is less than amount
                if (coins[the_coin] <= sub_amount) {
                    dynamic_storage[sub_amount] =
                            Math.min(//min of 
                                    dynamic_storage[sub_amount],//current amount as we go
                                    1 + //since we are taking away one coin
                                            dynamic_storage[//from this very dynamic array - calculated before
                                                    sub_amount //subamount we are calculating for
                                                            - coins[the_coin]]);//minus current to loop  coin value

                } else {//if nominal of current coin is higher than amount
                    break;//stop looping - cause we are sorted - all following are higher also and cannot be used to form amount anyways
                }
            }
        }

        return dynamic_storage[amount] > amount ? -1 : dynamic_storage[amount];//if only higher nominals got to dynamic array - so cant form amount(ret: - 1)


    }


    static List<Integer> getFewestCoinsForAmount(List<Integer> coins, int amount) {
        Collections.sort(coins);

        int[] dynamic_storage = new int[amount + 1];

        List<Integer> res = new ArrayList<>();

        Arrays.fill(dynamic_storage, amount + 1);
        dynamic_storage[0] = 0;

        for (int sub_amount = 0; sub_amount <= amount; sub_amount++) {

            for (int the_coin = 0; the_coin < coins.size(); the_coin++) {

                // if nominal of current coins is less than amount
                if (coins.get(the_coin) <= sub_amount) {
                    dynamic_storage[sub_amount] = Math.min(dynamic_storage[sub_amount], 1 + dynamic_storage[sub_amount - coins.get(the_coin)]);


                } else {//if nominal of current coin is higher than amount
                    break;//stop looping - cause we are sorted - all following are higher also and cannot be used to form amount anyways
                }
            }

        }
        System.out.println(coins);

        int ways = dynamic_storage[amount] > amount ? -1 : dynamic_storage[amount];


                res.add(coins.get(ways));


        return res;

    }
}
