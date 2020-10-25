package LEET_CODE.array;

/*
[ 1 2 3 4 ]  destination index 2
calc distance way to get to destination ( index in aray )  from index
clockwise or ciunterclockwise
start from zero index, counterclockwise - start from end 4 3 2 1
 */
public class BusStop {

    public static void main(String[] args) {
       int [] distances = new int [] {1,2,3,4};
       int dist = distanceBetweenStops(distances, 0,2);
        System.out.println(dist);
    }

    static int distanceBetweenStops(int [] distances,int start, int destination){
        int clockWiseDistance = 0;
        int totalDistance = 0;

        for (int i = 0; i < distances.length ; i++) {

            if(start < destination && // if we start before our dest AND
                    (i >= start && i < destination )){ //index we AT more thean start AND index less then dest
                clockWiseDistance += distances[i];
            }

            if( start > destination && //if we start AFTER dest AND
                    (i >= start || i < destination)){//index we AT more than start OR!!! index less dest
                clockWiseDistance += distances[i];
            }

            totalDistance += distances[i];//accumulate total
        }

        return Math.min(clockWiseDistance,//choose min of clockwise and counter
                totalDistance - clockWiseDistance);//counterclockwise = total - clockwise
    }
}
