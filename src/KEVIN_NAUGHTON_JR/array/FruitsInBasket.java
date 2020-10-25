package KEVIN_NAUGHTON_JR.array;

import java.util.HashMap;

/*
given array of fruits , find max fruits to fit in 2 baskets
only one type of fruit can go to basket

1 2 3 2 2
res = 4 ( 2 +2 )
 */
//this one is not optimal , uses hash map - more space - see nick whyte sliding window
public class FruitsInBasket {

    public static void main(String[] args) {

        int maxFruitsInTwoBaskets = maxFruits(new int[]{1, 2, 3, 2, 2});
        System.out.println(maxFruitsInTwoBaskets);
    }

    static int maxFruits(int [] fruits){
        if( fruits == null || fruits.length==0){
            return 0;
        }

        int max = 1;//checked for nothing above - so anyways 1

        HashMap<Integer, Integer> basket = new HashMap<>();//not optimal space

        int i = 0;
        int j = 0;

        while (j < fruits.length){

            if( basket.size()<=2){//basket not full - add
                basket.put(fruits[j], j++);//add incrementally ++
            }

            if(basket.size() >2){//basket full

                int min = fruits.length-1;//initially min set to max

                for(int value : basket.values()){//check all values in map
                    min = Math.min(min, value);//update min
                }

                i = min +1;//set new min
                basket.remove(fruits[min]);//remove we counted it in ,  dont need anymore
            }

            max = Math.max(max, j - i);//update max , i - j , since we have slided i to new as we met third fruit
        }

        return max;
    }
}
