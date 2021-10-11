package HACKER_EARTH;

import LEET_CODE.Graphs.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphPaths {
    private static int[][] adjacencyMatrix;

    public GraphPaths(int[][] input) {
        adjacencyMatrix = input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        int vertices = Integer.parseInt(bufferedReader.readLine().trim());
        int[][] graphMatrix = new int[vertices][vertices];
        for(int i = 0; i < vertices; i++) {
            String[] row = bufferedReader.readLine().trim().split(" ");
            for(int j=0; j < vertices; j++) {
                graphMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        List<String> functionInputRowString = new ArrayList<String>(Arrays.asList(bufferedReader.readLine().trim().split(" ")));
        List<Integer> functionInputRow = functionInputRowString.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        GraphPaths graph = new GraphPaths(graphMatrix);

        int result = GraphPaths.numPaths(functionInputRow.get(0),functionInputRow.get(1),functionInputRow.get(2));

        System.out.println(result);

        wr.close();
        bufferedReader.close();
    }


    static int numPaths(int sourceNode, int destNode, int maxSteps){
        return 0;
    }


}
