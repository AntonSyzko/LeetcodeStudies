package LEET_CODE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
[ [1] [2] [3] [] ]
each [] is key for next room with index of what is in [*] so [1] is key for room index 1
 */
public class KeysAndRooms {

    public static void main(String[] args) {

        List<List<Integer>> roomsWithKeysForIndexedRooms = new ArrayList<>();
        roomsWithKeysForIndexedRooms.add(List.of(0));
        roomsWithKeysForIndexedRooms.add(List.of(1));
        roomsWithKeysForIndexedRooms.add(List.of(2));
        roomsWithKeysForIndexedRooms.add(List.of(3));
        roomsWithKeysForIndexedRooms.add(Collections.emptyList());



        boolean visitedRooms = canVisitAllRooms(roomsWithKeysForIndexedRooms);
        System.out.println(visitedRooms);

    }

    static boolean canVisitAllRooms(List<List<Integer>> roomsWithKeys){
        boolean[] seenRooms = new boolean[roomsWithKeys.size()];
        seenRooms[0]=true;//initial room is visited by default

        Stack<Integer> keys = new Stack<>();
        keys.add(0);//initial room


        while (!keys.isEmpty()){//while keys in stack
            int current_key = keys.pop();//get current key from stack
            for(int new_key : roomsWithKeys.get(current_key)){//get the value from rooms for what index of room is the value key
                if (!seenRooms[new_key]){//if by that index in seen room is false
                    seenRooms[new_key]=true;//set to true seen
                    keys.add(new_key);//add to stack to use in next room to open it
                }

            }
        }

        for(boolean seenKey : seenRooms){
            if(!seenKey) return false;//if any unseen - false
        }

        return true;
    }
}


