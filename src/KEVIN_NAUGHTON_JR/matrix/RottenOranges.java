package KEVIN_NAUGHTON_JR.matrix;

import java.util.HashSet;
import java.util.Set;

public class RottenOranges {

    public static void main(String[] args) {


        int [][] oranges = new int [][] {{2,1,1},{1,1,0},{0,1,1}};

        int minutesTakenTpRotten = orangesRotting(oranges);
        System.out.println(minutesTakenTpRotten);
    }

    //O(n)  space O(n)
    static int orangesRotting(int [][] oranges){
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();

        //populate fresh and rotten ( 1 rotten at the beginning)  oranges
        for (int row = 0; row < oranges.length; row++) {
            for (int col = 0; col < oranges[row].length; col ++) {
                if(oranges[row][col] == 1){
                    fresh.add(""+ row + col);//"" is here to math the has set key string expected
                }else if (oranges[row][col] == 2){
                    rotten.add("" + row + col);
                }
            }
        }

        int minutes = 0;
        int [][] directions = new int [][] {//traversal board for BFS
                {0,1},//right
                {1,0},//left
                {-1,0},//up
                {0,-1}//down
        };

        while (fresh.size()>0){

            Set<String> infected = new HashSet<>();//storage for new rotten as we  go

            for (String rotten_orange : rotten){
                int i = rotten_orange.charAt(0)-'0';//position of rotten in pile
                int j  = rotten_orange.charAt(1) - '0';//-'0' to give int answer

                for (int[] direction : directions){//for each direction

                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];

                    if( fresh.contains(""+nextI+nextJ)){
                        fresh.remove(""+nextI+nextJ);//not a fresh anymore
                        infected.add(""+nextI+nextJ);//now infected
                    }
                }
            }
            if(infected.size()==0){//if nothing was added to new infected - we cannot reach remote orange - return -1
                return -1;
            }
            rotten = infected;//new rottens
            minutes++;
        }
        return minutes;
    }
}
