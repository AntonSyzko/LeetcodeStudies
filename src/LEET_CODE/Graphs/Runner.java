package LEET_CODE.Graphs;

public class Runner {

    public static void main(String[] args) {
        Graph graf = new Graph();
        graf.addVertex('A');
        graf.addVertex('B');
        graf.addVertex('C');
        graf.addVertex('X');
        graf.addVertex('Z');


        graf.addEdge(0,1,1);
        graf.addEdge(1,2,1);
        graf.addEdge(2,3,1);
        graf.addEdge(0,4,1);//another branch - X:  0 - 4
        graf.addEdge(4,5,1);//another branch - Z:  4 - 5

        System.out.println(" ======================= DFS ========================");

           graf.passInDeep(0);
        System.out.println(" \r\n======================= BFS ========================");
        graf.passInWidth(0);




    }
}
