package KEVIN_NAUGHTON_JR.array;

/*
given array of money in houses how much max one can rob
every adjacent ( next t each other ) house  has alarm - cant rob
1 2 3 1 = 4 = 1 + 3
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] sums = new int[]{1, 2, 3, 1};
        int maxRob = maxRob(sums);
        System.out.println(maxRob);
    }

    static int maxRob(int[] money) {
        if (money == null || money.length == 0) {//pre check
            return 0;
        }

        if (money.length == 1) {//one element
            return money[0];
        }
        if (money.length == 2) {//two elements
            return Math.max(money[0], money[1]);
        }

        //store max money one can rob in each cell
        int[] dymanicProgArray = new int[money.length];
        dymanicProgArray[0] = money[0];//first cell
        dymanicProgArray[1] = Math.max(money[0], money[1]);//second cell

        //start from 3 cell , traverse
        for (int sum = 2; sum < money.length; sum++) {
            //current cell = max between current+pre-revious OR previous
            dymanicProgArray[sum] = Math.max(money[sum] + dymanicProgArray[sum - 2],//current money sum + sum of TWO cells back ( so not an adjacent )
                    dymanicProgArray[sum - 1]);//OR just previous CELL
        }

        return dymanicProgArray[money.length - 1];//end will contain MAX one can rob
    }

}
