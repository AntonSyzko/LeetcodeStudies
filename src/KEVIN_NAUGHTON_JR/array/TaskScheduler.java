package KEVIN_NAUGHTON_JR.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*

array of processes , n is cool down period between same prcesses
Intuition behind solution: Count the number of times each type of tasks occurs with a hash map.
From the values in the hash map create a max heap. While the max heap is not empty, at every "cycle" in the cpu cooldown time of n,
 try to run the task that occurs the most adding these tasks to a temporary list. After iterating through the cooldown time
 (given as n in the problem) iterate through the temporary list checking for which tasks still need to be run
  (if the value in the list is greater than zero add it back to the max heap).
  Then, increment our return value by either the size of the temporary list
  (i.e. all the tasks you were able to run) or by the cooldown time
  (if you ran out of tasks to run you have to wait the full cooldown).
 Finally, once the max heap is empty, return cycles.
 */
public class TaskScheduler {

    public static void main(String[] args) {
        int leastInterval = leastInterval(new char[]{'A','A','A','B','B','B'},2);
        System.out.println(leastInterval);
    }

    static int leastInterval(char[] tasks, int coolDown) {
        HashMap<Character, Integer> tasksToTimesOccuredMap = new HashMap<>();
        for (char taska : tasks) {
            tasksToTimesOccuredMap.put(taska, tasksToTimesOccuredMap.getOrDefault(taska, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(tasksToTimesOccuredMap.values());

        int CPUCicles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            for (int coolDownPeriod = 0; coolDownPeriod < coolDown + 1; coolDownPeriod++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for (int i : temp) {
                if (--i > 0) {
                    maxHeap.add(i);
                }
            }

            CPUCicles += maxHeap.isEmpty() ? temp.size() : coolDown + 1;
        }
        return CPUCicles;
    }
}
