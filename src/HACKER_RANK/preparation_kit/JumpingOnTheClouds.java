package HACKER_RANK.preparation_kit;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        int[] clouds = new int[] {0,1,0,0,1,0};
        int[] clouds2 = new int[] {0,1,0,0};

        int jumps = jumpingOnTheClouds(clouds2);
        System.out.printf("jumps %s", jumps);
    }

    static int jumpingOnTheClouds(int[] clouds){
        int numberOfJumps = 0;
        int cloud = 0;

        while (cloud < clouds.length-1){
            if(
                    cloud+2 == clouds.length //if last before final '0'  e.g:  0.1.0.0 - not jump over end of array - index out of bound , so step should be +1 ( not +2 )
                    ||
            clouds[cloud+2] == 1 ){
                cloud ++;
                numberOfJumps++;
            }else {
                cloud  += 2;
                numberOfJumps++;
            }
        }

        return numberOfJumps;
    }
}
