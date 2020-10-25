package KEVIN_NAUGHTON_JR.misc;


import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
given list of list rooms - with keys to other rooms find out if we can visit all the rooms using keys

start at room 0
 */
public class RoomsAndKeys {
    public static void main(String[] args) {

    }

    //DFS
    static boolean canVisitRooms(List<List<Integer>> roomsVsKeys){
        HashSet<Integer> visitedByExtractedKeys = new HashSet<>();
        visitedByExtractedKeys.add(0);//by default first is visited

        Stack<Integer> stackOfCheckedRooms = new Stack<>();//DFS
        stackOfCheckedRooms.add(0);

        while (!stackOfCheckedRooms.isEmpty()){
            List<Integer> keysFromCurrentRoom = roomsVsKeys.get(stackOfCheckedRooms.pop());//exctract keys
//if of extracted keys rooms are not yet visited
            keysFromCurrentRoom.stream()
                    .filter( key -> !visitedByExtractedKeys.contains(key))
                    .forEach(ki ->{//for each NOT YET visited
                              visitedByExtractedKeys.add(ki);//add KEY to visited
                             stackOfCheckedRooms.add(ki);//add ToStack to check it's keys in next iterations
            });
        }
        //in the end if visited by extracted keys = all rooms size = we are OK
        return visitedByExtractedKeys.size() == roomsVsKeys.size();
    }

}
