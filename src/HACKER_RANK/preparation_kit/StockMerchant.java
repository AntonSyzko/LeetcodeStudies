package HACKER_RANK.preparation_kit;

import java.util.HashSet;
import java.util.Set;

public class StockMerchant {
    public static void main(String[] args) {
        int[] socks = new int [] {1,1,1};
        int res = numberOfPairs(5, socks);
        System.out.println(res);

    }

    static int numberOfPairs(int num_of_socks, int [] stock){

        if (stock.length == 0) return 0;

        int num_pairs = 0;
        Set<Integer> pair_counter = new HashSet<>();

        for(int i =0 ; i <  stock.length; i++){
            if(!pair_counter.contains(stock[i])){
                pair_counter.add(stock[i]);
            } else {
                num_pairs ++;
                pair_counter.remove(stock[i]);
            }
        }

        return num_pairs;

    }
}
