package HACKER_RANK.preparation_kit;

import java.util.Arrays;

public class MarkAndToys {

    public static void main(String[] args) {

        System.out.println(maxNumOfToysOneCanBuyForGivenMoney(new int[]{1,2,3,4},7));
    }

    static int maxNumOfToysOneCanBuyForGivenMoney(int[] prices, int money){
        int max_num_of_toys = 0;
        Arrays.sort(prices);//this is the key point - since cheapest toys will come in consecuence - making quantity number max

        for(int i = 0; i < prices.length; i++){
            money -= prices[i];
            if(money<0) return max_num_of_toys;// no more cah for toys
            max_num_of_toys ++;
        }
        return max_num_of_toys;
    }
}
