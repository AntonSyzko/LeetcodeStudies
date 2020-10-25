package LEET_CODE;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriagle {

    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = generatePascalTriangle(3);

        System.out.println(pascalTriangle);

    }

    public static List<List<Integer>> generatePascalTriangle(int numOfRows){

        List<List<Integer>> pascalTriangle = new ArrayList<>();

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        pascalTriangle.add(first_row); // intial

        for (int i = 1; i < numOfRows; i++){
            List<Integer> previous_row = pascalTriangle.get(i-1);
            List<Integer> current_row = new ArrayList<>();

            current_row.add(1);//first [1]

            for ( int j = 1 ; j < i; j++){
                current_row.add(previous_row.get(j) + previous_row.get(j-1));// all middle [] [] []
            }

            current_row.add(1);//...last[1]

            pascalTriangle.add(current_row);
        }

        return  pascalTriangle;
    }
}
