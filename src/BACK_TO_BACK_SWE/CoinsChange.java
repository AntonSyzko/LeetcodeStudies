package BACK_TO_BACK_SWE;

import java.util.Arrays;

public class CoinsChange {
    public static void main(String[] args) {
       int minCoins = leastCoins(new int[]{1,2,5},11);
        System.out.println(minCoins);
    }

    static int leastCoins(int[] coins, int amount) {
        // This table will store the answer to our sub problems
        int[] dp = new int[amount + 1];

        // Initialize the dp table
        Arrays.fill(dp, amount + 1);

    /*
      The answer to making change with minimum coins for 0
      will always be 0 coins no matter what the coins we are
      given are
    */
        dp[0] = 0;

        // Solve every subproblem from 1 to amount
        for (int subamount = 1; subamount <= amount; subamount++) {
            // For each coin we are given
            for (int coin = 0; coin < coins.length; coin++) {
                // If it is less than or equal to the sub problem amount
                if (coins[coin] <= subamount) {
                    // Try it. See if it gives us a more optimal solution
                    dp[subamount] = Math.min(dp[subamount], dp[subamount - coins[coin]] + 1);
                }
            }
        }

    /*
      dp[amount] has our answer. If we do not have an answer then dp[amount]
      will be amount + 1 and hence dp[amount] > amount will be true. We then return -1.
      */

    //  Otherwise, dp[amount] holds the answer
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
