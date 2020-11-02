package KEVIN_NAUGHTON_JR.array;

/*
given 7 nums as stock prices per day of week - calc max profit
cannot sell before buy
buying higher price than selling is LOSS

7 1 5 3 6 4
res= 6 - 1 = 5
 */
public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4,};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

        int maxMultProfit = maxProfitMultipleTimes(prices);
        System.out.println(maxMultProfit);
    }

    static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPriceSoFar = Integer.MAX_VALUE;//init mAX

        for (int price = 0; price < prices.length; price++) {//iterate through all prices of a week
            if (prices[price] < minPriceSoFar) {//if current is LESS then curr min
                minPriceSoFar = prices[price];//reassign MIN
            } else {//if current is not less than curr MIN
                //choose MAX of curr max so far and diff between curr price and curr min
                maxProfit = Math.max(maxProfit, prices[price] - minPriceSoFar);
            }
        }
        return maxProfit;
    }

    //buy sell every next day example - how much profit can make
    static int maxProfitMultipleTimes(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int accumulatedProfit = 0;
        for (int price = 0; price < prices.length - 1; price++) {
            if (prices[price] < prices[price + 1]) {//compare next to each other day prices
                accumulatedProfit += prices[price + 1] - prices[price];//aggregate if next is HIGHER than prev
            }
        }
        return accumulatedProfit;
    }
}
