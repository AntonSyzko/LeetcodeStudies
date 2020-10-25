package LEET_CODE.array;

import java.util.Arrays;

/*
l   o  v  e  l  e  e  t  c  o  d  e    cahr - 'e'
[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class ShortestDistanceToChar {

    public static void main(String[] args) {
       int[] res = shortestDistToChar("loveleetcode",'e');
        System.out.println(Arrays.toString(res));
    }

    static int[] shortestDistToChar(String word, char target){
        int n = word.length();
        int[] output = new int[n];
        int current_target_position = -n;//init with negative length of array to start

        for (int i = 0; i < n ; i++) {//traverse upwards
            if(word.charAt(i) == target){
                current_target_position = i;//set current to this occurence
            }
            output[i]=i - current_target_position;//store distance
        }

        for (int i = n-1; i >=0 ; i--) {//traverse backwards
            if(word.charAt(i)==target){
                current_target_position = i;//store occurence
            }
            output[i] = Math.min(output[i], Math.abs(i - current_target_position));//store MIN of prev and current distances
        }

        return output;
    }
}
