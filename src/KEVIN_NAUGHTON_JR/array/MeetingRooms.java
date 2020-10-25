package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
given intervals for room meetings, find min number of rooms needed for mettings
[0,30]  [5,10]  [15,20]

res 2 meeting rooms
 */
public class MeetingRooms {

    public static void main(String[] args) {
        Interval i1 = new Interval(0,30);
        Interval i2 = new Interval(5,10);
        Interval i3 = new Interval(15,20);



        int minRooms = minMeetingRooms(new Interval[]{i1, i2, i3});

        System.out.println(minRooms);

    }

    //
    //
    static int minMeetingRooms(Interval[] intervals){
        if( intervals == null || intervals.length == 0){//pre check
            return 0;
        }

        Arrays.sort(intervals, (a,b)-> a.start - b.start);//sort by start time  in beginning

        PriorityQueue <Interval> minHeap = new PriorityQueue<>((a,b)-> a.end - b.end);//min heap by end time

        minHeap.add(intervals[0]);//we need ONE interval anyways to start

        for (int interval = 1; interval< intervals.length; interval++){//traverse other intervals
            Interval current = intervals[interval];//from interval array
            Interval eraliest = minHeap.remove();//last in min heap end

            if( current.start >= eraliest.end){//collision here - if current starts even earlier than earliest ends
                eraliest.end = current.end;//override - current END is now the earliest end
            }else {//if no collision
                minHeap.add(current);//just add to min heap
            }

            minHeap.add(eraliest);//if earliest was updated it will be stored as updated , or returned to heap after all comparisons
        }

        return minHeap.size();//size is number of rooms
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval() {
            start = 0;
            end = 0;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Interval{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }
}
