package KEVIN_NAUGHTON_JR.array;

/*
given dominos calculate how many swaps needed to make all in upper or bottom row be same

A : 2 1 2 4 2 2
B : 5 2 6 2 3 2

swap second and fourth from bottom and you have all upper 2

combinatorics are ONLY 4 :
upper ones match first upper
upper ones match first bottom
bottom ones match first upper
bottom ones match first bottom

 */
public class DominoSwaps {

    public static void main(String[] args) {

        int[] upper_row = new int[]{2, 1, 2, 4, 2, 2};
        int[] bottom_row = new int[]{5, 2, 6, 2, 3, 2};

        int numberOfSwaps = minDominoRotations(upper_row, bottom_row);
        System.out.println(" res " + numberOfSwaps);

    }

    static int minDominoRotations(int[] upper_domino_row, int[] bottom_domino_row) {
        int minSwaps = Math.min(
                numSwaps(upper_domino_row[0], upper_domino_row, bottom_domino_row),//upper ones match first upper
                numSwaps(bottom_domino_row[0], upper_domino_row, bottom_domino_row)//p ones match first bottom
        );

        minSwaps = Math.min(minSwaps, numSwaps(upper_domino_row[0], bottom_domino_row, upper_domino_row));//bottom ones match first upper
        minSwaps = Math.min(minSwaps, numSwaps(bottom_domino_row[0], bottom_domino_row, upper_domino_row));//bottom ones match first bottom

        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    private static int numSwaps(int target, int[] upper_domino_row, int[] bottom_domino_row) {
        int numSwaps = 0;

        for (int i = 0; i < upper_domino_row.length; i++) {//traverse row
            if (upper_domino_row[i] != target && bottom_domino_row[i] != target) {//if any ( upper or bottom ) don't match target
                return Integer.MAX_VALUE;//impossible to make upper or lower row have same dominos - return
            } else if (upper_domino_row[i] != target) {//if upper not =
                //upper here means passed as second param - does nt necessarily mean upper row of dominos
                numSwaps++;//than bottom - so swap
            }
        }
        return numSwaps;//res
    }
}
