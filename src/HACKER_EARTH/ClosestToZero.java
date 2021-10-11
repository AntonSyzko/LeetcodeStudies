package HACKER_EARTH;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class ClosestToZero {

    public static void main(String[] args)  {

        int closestToZeroInArray = Solve(5, new int []{-1, 1 ,2, 5, 8});
        System.out.println(closestToZeroInArray);

         closestToZeroInArray = SolveJava8(4, new int []{-10, 10 ,20, 544});
        System.out.println("\r\n Java 8 map reduce " + closestToZeroInArray);

    }

    static int Solve(int N, int[] A) {

        int closestIndex = 0;

        int currentDiff = Integer.MAX_VALUE;//temp first diff to MAX

        for (int index = 0; index < A.length; index++) {

            int abs = abs(A[index]);//get absolute value, despite +/-

            if (abs < currentDiff) {//less than diff

                closestIndex = index;
                currentDiff = abs;

                //case of SAME abs value of negative (ex: -1) was assigned to current diff before
            } else if (abs == currentDiff && A[index] > 0 && A[closestIndex] < 0) {

                closestIndex = index;//reasiign to positive value ( same ABS )
            }
        }
        return A[closestIndex];
    }

    static int SolveJava8(int N, int[] A) {
        int closestToZero = Arrays.stream(A).filter(i -> i != 0)
                .reduce((first, second) -> abs(first) < abs(second) ?
                        first : (abs(first) == abs(second) ? max(first, second) : second))
                .getAsInt();

        return closestToZero;
    }
}
