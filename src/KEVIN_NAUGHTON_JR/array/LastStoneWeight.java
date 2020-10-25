package KEVIN_NAUGHTON_JR.array;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
given array of stone weights
each turn collide heaviest stones and smash them togeter
if stones weights == -> smash = 0
if no - heaviest stone of two becomes the remainder of both weights 5 against 3 = 5 -3 = 2, so instead of 5 is now 2

return last stone weight or 0 if no stones left
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int [] stones = IntStream.of(2,7,4,1,8,1).toArray();
        int lastStone = lastStoneWeightWithNegation(stones);

        System.out.println(lastStone);
    }

    static int lastStoneWeight(int [] stones){

        //max heap, by default kava priority queue is MIN heap, so comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((stone1, stone2)-> stone2-stone1);

        for(int stone: stones){
            maxHeap.add(stone);//popluate max heap
        }

        while (maxHeap.size()>1){
            int stone1 = maxHeap.remove();//retrieve stones from MAX heap top
            int stone2 = maxHeap.remove();

            if(stone1 != stone2){//not same
                maxHeap.add(stone1-stone2);//so put back to max heap the remainder of smashing
            }
        }

        return maxHeap.isEmpty()? 0 : maxHeap.remove();//if smth in heap return - othervise 0
    }

    static int lastStoneWeightWithNegation(int [] stones){

        //max heap, by default Java priority queue is MIN heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int stone: stones){
            maxHeap.add(-stone);//popluate max heap, NEGATE ( - sign )  to have MAX heap
        }

        while (maxHeap.size()>1){
            int stone1 = -maxHeap.remove();//retrieve stones from MAX heap top
            int stone2 = -maxHeap.remove();//NEGATE BACK number

            if(stone1 != stone2){//not same
                //MIND !!! NEGATE BACK
                maxHeap.add(-(stone1-stone2));//so put back to max heap the remainder of smashing
            }
        }

        //MIND NEGATE BACK
        return maxHeap.isEmpty()? 0 : -maxHeap.remove();//if smth in heap return - othervise 0
    }
}
