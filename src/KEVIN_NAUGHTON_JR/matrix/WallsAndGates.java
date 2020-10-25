package KEVIN_NAUGHTON_JR.matrix;

/*
0 is gate 1 is wall
all other cells are empty
fill empties  with distance to closest gate
max is INF
 */
public class WallsAndGates {
    public static void main(String[] args) {

    }

    static void wallsAndGates(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                if (matrix[row][colum] == 0) { // is gate and we will run depth first search to calculate possible ditances to it
                    depthFirstSearch(row, colum, 0, matrix);
                }
            }
        }
    }

    private static void depthFirstSearch(int row, int colum, int distance, int[][] matrix) {
        //base case for recursion
        if (row < 0 || row >= matrix.length // rows stay in bounds
                || colum < 0 || colum >= matrix[row].length || // colums stay in bounds
                matrix[row][colum] < distance) { // current distance to gate is bigger  then passed from prev step - ignore

            matrix[row][colum] = distance;// new smaller distance assigned
            depthFirstSearch(row + 1, colum, distance + 1, matrix);//next row up
            depthFirstSearch(row - 1, colum, distance + 1, matrix);// next row down

            depthFirstSearch(row, colum + 1, distance + 1, matrix); // next column right
            depthFirstSearch(row, colum - 1, distance + 1, matrix); // next column left

        }
    }
}
