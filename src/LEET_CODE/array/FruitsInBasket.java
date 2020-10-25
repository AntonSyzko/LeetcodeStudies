package LEET_CODE.array;


/*
given array of fruits , find max fruits to fit in 2 baskets
only one type of fruit can go to basket

1 2 3 2 2
res = 4 ( 2 +2 )
 */
public class FruitsInBasket {
    public static void main(String[] args) {

        int maxFruitsInTwoBaskets = maxFruits(new int[]{1, 2, 3, 2, 2});
        System.out.println(maxFruitsInTwoBaskets);

    }

    static int maxFruits(int[] fruits) {
        int last_fruit = -1;//sliding window pointer
        int second_last_fruit = -1;//sliding window pointer
        int last_fruit_count = 0;
        int current_max = 0;
        int max = 0;

        for (Integer fruit : fruits) {
            if (fruit == last_fruit || fruit == second_last_fruit) {
                current_max += 1;
            } else {
                current_max = last_fruit_count + 1;
            }

            if (fruit == last_fruit) {
                last_fruit_count += 1;
            } else {
                last_fruit_count = 1;//first appearance
            }

            if (fruit != last_fruit) {
                second_last_fruit = last_fruit;//what was last - but now secind last
                last_fruit = fruit;//assignment of last fruit
            }

            max = Math.max(current_max, max);
        }

        return max;
    }
}
