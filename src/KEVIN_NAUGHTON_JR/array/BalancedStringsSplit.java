package KEVIN_NAUGHTON_JR.array;

/*
LRLLRRLR  split in balanced, balanced is equal amount of L and R
LR  LLRR  LR
 */
public class BalancedStringsSplit {
    public static void main(String[] args) {
        String s = "LRLLRRLR";
        int numOfBalancedSplit = countBalancedStrings(s);
        System.out.println(numOfBalancedSplit);
    }

    static int countBalancedStrings(String input) {
        int balancedStringRes = 0;
        int metLandRasWeGoCounter = 0;

        for (int i = 0; i < input.length(); i++) {

            char current = input.charAt(i);//extract char

            if (current == 'L') {
                metLandRasWeGoCounter++;//increment met L
            }
            if (current == 'R') {
                metLandRasWeGoCounter--; // decrement met R
            }

            if (metLandRasWeGoCounter == 0) {//0 will indicate eaxt amount of L and R met ( ++ to -- gives 0)
                balancedStringRes++;//so final res increments
            }

        }
        return balancedStringRes;
    }
}
