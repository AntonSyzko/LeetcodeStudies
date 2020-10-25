package HACKER_RANK.preparation_kit;

import java.util.Arrays;

public class CountingValleys {

    public static void main(String[] args) {
        int steps = 8;
        String path = "UDDDUDUU";

        int [] res = numOfValleys(steps, path);
        System.out.println(Arrays.toString(res));

    }

    static int[] numOfValleys(int steps, String pathWithDownsAndUps){
        int altitude = 0;
        int num_of_valleys = 0;
        int num_of_hills = 0;

        for(int i = 0; i < steps; i++){
            if(pathWithDownsAndUps.charAt(i)=='U'){
                if(altitude == -1){
                    num_of_valleys++;
                }
                altitude++;
            }

            if(pathWithDownsAndUps.charAt(i) == 'D'){
                if (altitude== +1){
                    num_of_hills++;
                }
                altitude--;
            }
        }

        return new int []{num_of_valleys, num_of_hills};
    }
}
