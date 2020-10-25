package KEVIN_NAUGHTON_JR.array;

import java.util.HashSet;
import java.util.Stack;

public class FrogJump {

    public static void main(String[] args) {

    }


    static boolean canCross(int[] stones) {
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > stones[i - 1] * 2) {//math to see if distance between very stones is too high
                return false;
            }
        }

        HashSet<Integer> stonePositions = new HashSet<>();
        for (int stone : stones) {
            stonePositions.add(stone);
        }

        int lastStone = stones[stones.length - 1];

        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();

        positions.add(0);
        jumps.add(0);


        while (!positions.isEmpty()) {

            int position = positions.pop();
            int jumpDistance = jumps.pop();

            for (int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {//can jump only k-1, k , k+1
                if (i <= 0) {//if occured on zero index
                    continue;//ignore
                }
                int nextPosition = position + i;

                if (nextPosition == lastStone) {//got to last ?
                    return true;
                } else if (stonePositions.contains(nextPosition)) {//exists in possible positions
                    positions.add(nextPosition);//add and continue checking combinations
                    jumps.add(i);
                }

            }
        }
        return false;//got here without true - false
    }
}
