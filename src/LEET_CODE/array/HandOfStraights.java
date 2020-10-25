package LEET_CODE.array;

import java.util.TreeMap;

/*
given array of cards [1,2,3,6,2,3,4,7,8] and group limit 3
form card gruoups (subarraya) so that it holds num of cards = limit and cards are consecutive
[1,2,3,]  [2,3,4]   [6,7,8]
 */
public class HandOfStraights {

    public static void main(String[] args) {

        int[] cards = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        boolean canFormGroupOfCards = isCardStraight(cards, 3);
        System.out.println(canFormGroupOfCards);
    }

    static boolean isCardStraight(int[] hand, int card_group_limit) {

        TreeMap<Integer, Integer> sorted_cards = new TreeMap<>();//sorted data struct to store cards sorted for future grouping
        for (int card : hand) {//travers cards and populate tree map
            if (!sorted_cards.containsKey(card)) {
                sorted_cards.put(card, 1);//first occurence - key is cards ( value from array ) , value 1 ( one occurence)
            } else {
                sorted_cards.replace(card, sorted_cards.get(card) + 1);//value +1  more  occurences
            }
        }

        while (!sorted_cards.isEmpty()) {//traverse tree
            int first_card = sorted_cards.firstKey();//get first card - since we are  sorted - it will be smallest
// loop from each card + card limit, cause its the limit in group ( group of 3 in our example, so only this number of iterations in loop )
            for (int i = first_card; i < first_card + card_group_limit; i++) {
                if (!sorted_cards.containsKey(i)) {//this card does not exists
                    return false;//we can NOT form this current group , iteration stopped - false, go to next in tree
                }

                int count = sorted_cards.get(i);//how many times this card ocurred in tree map
                if (count == 1) {//if only once -
                    sorted_cards.remove(i);//just remove it, we  cannot use it anymore,
                } else { // it is more than once in our cards ( tree map )
                    sorted_cards.replace(i, sorted_cards.get(i) - 1);//decrease it's counter value in tree map , so its used once
                }
            }
        }

        return true;//if all passed the number of groups by limit formed - all good

    }
}
