package KEVIN_NAUGHTON_JR.dynamic;

/*
given n of steps to reach, one can make 1 or 2 steps at the time
what is the max number of distinct steps to get to N
 */
public class StepsToClimb {

    public static void main(String[] args) {
        int steps = stepsToClimb(3);
        System.out.println(steps);
    }

    static int stepsToClimb(int stepsToReach) {

        int[] dp = new int[stepsToReach + 1];
        dp[0] = 1;// 1 step to get to 0 - do nothing ( also step )
        dp[1] = 1;// 1 step to get to 1 stair

        //from 2 !!!
        for (int step = 2; step <= stepsToReach; step++) {
            dp[step] = dp[step - 1] + dp[step - 2];
        }

        return dp[stepsToReach];
    }
}
