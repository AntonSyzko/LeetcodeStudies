package HACKER_RANK.preparation_kit;

import java.util.Arrays;
import java.util.Comparator;

public class LuckBalance {

    public static void main(String[] args) {


        int[][] luckbalance_vs_contestimportance = new int[][]{{5,1},{1,1},{4,0}};

        System.out.println(luckBalance(3, luckbalance_vs_contestimportance));
    }

    /*
    5 1
    4 0
    3 2
     */
    static int luckBalance(int number_of_contests, int[][] luckballance_vs_importance) {
        int luck_balance = 0;

        Arrays.sort(luckballance_vs_importance, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return -1 * Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < luckballance_vs_importance.length; i++) {
            int luck = luckballance_vs_importance[i][0];
            int importance = luckballance_vs_importance[i][1];

            if (importance == 1 && number_of_contests > 0) {
                number_of_contests--;
                luck_balance += luck;
            } else if (importance == 1 && number_of_contests == 0) {
                luck_balance -= luck;
            }

            if (importance == 0) {
                luck_balance = +luck;
            }


        }

        return luck_balance;
    }
}
