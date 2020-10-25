package HACKER_RANK.arrays;

/*
can jump 1 2 or 3 steps at time, how many jumps to get to given floor
 */
public class StepsToTake {

    public static void main(String[] args) {
        int res = countPathsDPIter(3);
        System.out.println(res);

    }

    static int countPathsR(int steps) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;//1 path to get to 0 stp - do nthing , still a path though
        }

        return countPathsR(steps - 1) + countPathsR(steps - 2) + countPathsR(steps - 3);
    }

    static int countPathsMemo(int steps) {//caller shell
        if(steps<0){
            return 0;
        }
        return countPathsMemo(steps, new int[steps + 1]);
    }

    static int countPathsMemo(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        }

        if (memo[steps] == 0) {
            memo[steps] = countPathsMemo(steps - 1, memo) + countPathsMemo(steps - 2, memo) + countPathsMemo(steps - 3, memo);
        }

        return memo[steps];
    }

    static int countPathsDynamicProgramming(int steps) {
        if(steps<0){
            return 0;
        }else if(steps<=1){//to prevent index out of bounds if N of stpes passed is 1
            return 1;
        }
        //dynamic array
        int[] pathsDP = new int[steps+1];

        pathsDP[0]=1;//paths  to take to reach same place = 1 - stay there
        pathsDP[1]=1;//paths to take to reach 1 - 1 step
        pathsDP[2]=2;//paths to take to reach 2 = 2 ( 2 step jump, or 1+1 )

        for (int i = 3; i <=steps ; i++) {
            pathsDP[i]=pathsDP[i-1]+pathsDP[i-2]+pathsDP[i-3];//current = sum of -1 -2 -3 previous
        }
        return pathsDP[steps];
    }
 static int countPathsDPIter(int steps){
        if(steps==0){
            return 0;
        }else if( steps<=1){
            return 1;
        }

        int[] paths = {1,1,2};//1path to get to 0, 1 path to get to 1, 2 paths to get to 2

     for (int i = 3; i <= steps ; i++) {
         int count=paths[2]+paths[1]+paths[0];//current = sum of prev 3
         paths[0]=paths[1];//rotate 1 to 0
         paths[1]=paths[2];//rotate 2 to 1
         paths[2]=count;//now last 2 is count of sum of all of them before
     }
     return paths[2];//last holds the value
 }




    }