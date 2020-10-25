package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
given array of ++++, game is to substitute two ++ by two -- signs
so for + + + + combinations are
- - + +
+ - - +
+ + - -

 */
public class FlipGame {
    public static void main(String[] args) {
        String input = "++++";
        List<String> res = generatePossiblePlusSubstitutions(input);
        res.stream().forEach(System.out::println);

        boolean resFilpTwo = canWin("++++");
        System.out.println(resFilpTwo);
    }

    //runtime O(n)  or even O(n^2) - since substring ???
    // space O(n)
    static List<String> generatePossiblePlusSubstitutions(String input) {

        List<String> possibleSunstitutions = new ArrayList<>();//res

        int index = 0;//traverse index

        while (index < input.length()) {//loop condition

            int nextMove = index == 0 ? //is it beginning of input ?
                    input.indexOf("++")  // YES - find FIRST occurene of ++
                    : // or if NOT
                    input.indexOf("++", index);//find ocurrence of ++ AFTER  current  index postion

            if (nextMove == -1) {//-1 is when ++ not found at all
                return possibleSunstitutions;//return what you currently GOT
            }

            String nextStateAfterFoundCombination = input.substring(0, nextMove) + //substring from start to current next move index
                    "--" + //add '--'  so replacing previously found ++ here
                    input.substring(nextMove + 2);//ad after replacing whats left - add , mind + 2 - since we replaced TWO ++

            possibleSunstitutions.add(nextStateAfterFoundCombination);//store res

            index = nextMove + 1;//raise index by next move
        }

        return possibleSunstitutions;
    }


    public static boolean canWin(String input) {
        if (input == null || input.length() < 2) {//pre check
            return false;
        }

        for (int i = 0; i < input.length() - 1; i++) {//traverse, length -1 = to have two consecutive elemnets to compare
            if (input.charAt(i) == '+' && input.charAt(i + 1) == '+') {//if current and next is  +
                String inputAfterFlip = input.substring(0, i) + "--" + input.substring(i + 2);//replace this two + to '-' = new form of input
                ////recursively check the new input
                if (!canWin(inputAfterFlip)) {//if false ( NOT true )
                    return true;// - means other FAILED - we WON
                }
            }
        }

        return false;//means was TRUE to other player and we lost
    }
}
