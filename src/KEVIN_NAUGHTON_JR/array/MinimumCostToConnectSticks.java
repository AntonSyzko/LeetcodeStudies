package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
given array of sticks length
create one gian stick
cobine sticks by pair taking the minimum cost to combine two sticks at one step

2 4 3
2 + 3 = 5 , cost to make it is 5
4 + 5 = 9, and add the previous cost 9 + 5 = 14
longest stick to create with costs is 14
 */
public class MinimumCostToConnectSticks {

    public static void main(String[] args) {

        int[] sticks = new int [] {2,4,3};
        int cost = connectSticks(sticks);

        System.out.println(cost);
    }

    //time O(n logN), logN for heap and reheap , N - elemnts
    //space O(N) - num of elements in array
    static int connectSticks(int[] sticks){
        int cost_to_connect_sticks = 0;//res

        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>();
        //populate min heap, automatically will be sorted minimal first
       Arrays.stream(sticks).forEach(stick -> minimumHeap.add(stick));

        //while heap has smth
        while (minimumHeap.size() >1){
            //add two top min elemnts from heap
            int sum_of_two_top_elements_of_min_heap = minimumHeap.remove() + minimumHeap.remove();
            //as we have to count for COST - add the SUM to HEAP back , it will be plced according to VALUE( mins go first )
            minimumHeap.add(sum_of_two_top_elements_of_min_heap);

            //final cost aggregates all sums to connect sticks
            cost_to_connect_sticks += sum_of_two_top_elements_of_min_heap;

        }

        return cost_to_connect_sticks;//res
    }
}
