package LEET_CODE.array;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
given array of prices per day
7 1 5 3 9 6
find the max profit you can get by selling and buying the stock once
min 1   max after min 9  max profit = 8
 */
public class TimeToBuySellStock {

    public static void main(String[] args) {
        int [] prices = IntStream.of(7,1,5,3,9,6).toArray();
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

    }

    static int maxProfit(int[] prices){
        int min_val = Integer.MAX_VALUE;//holder of min - intially set to MAX as usual
        int max_profit = 0;//max profit holder

        for (int price = 0; price < prices.length; price++) {//traverse prices, indexes are days

            if(prices[price] < min_val){//if current day price is lower than current min

                min_val = prices[price];//set new MIN,  in other words - BUY on this day

      //othervise if current day price - min is more than current  max profit
            }else if( prices[price] - min_val > max_profit){

                max_profit = prices[price] - min_val;//set new MAX profit
                //in other words SELL on this day of week

            }
        }
        return max_profit;
    }
}
