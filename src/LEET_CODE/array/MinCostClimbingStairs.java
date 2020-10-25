package LEET_CODE.array;

/*
        given array of costs [10,15,20]
        one can start from index 0 or 1 - find min cost to get to top
        res = 15, starting from index 1

 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] costs = new int[]{10, 15, 20};

        int minCost = minCostClimbingStairsModyfingInputArray(costs);
        System.out.println(minCost);

        int[] costs2 = new int[]{1, 100, 1, 1, 1, 20, 1};

        int minCostDyn = minCostClimbingStairsDynamic(costs2);
        System.out.println(minCostDyn);
    }

    static int minCostClimbingStairsModyfingInputArray(int[] costs) {

        for (int i = 2; i < costs.length; i++) {
            //modyfing the very array in place
            costs[i] += Math.min(costs[i - 1], costs[i - 2]);//min of two previous
        }

        //min of last two after all additions while iterating
        return Math.min(costs[costs.length - 2], costs[costs.length - 1]);
    }

    static int minCostClimbingStairsDynamic(int[] costs) {
        int step1 = 0;//remember previous steps
        int step2 = 0;

        for (int i = costs.length - 1; i >= 0; i--) {//backwards traversal

            //add to current stp is val and MIN of two previous
            int current_step = costs[i] + Math.min(step1, step2);//first iter step 1 and 2 are 0
            step1 = step2;//reassign
            step2 = current_step;
        }
        return Math.min(step1, step2);//at the end step 1 and 2 will store last two costs of getting there , choose MIN

    }

}
