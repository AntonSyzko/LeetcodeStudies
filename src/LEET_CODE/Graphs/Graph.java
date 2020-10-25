package LEET_CODE.Graphs;

import java.util.Queue;

public class Graph {

    private int maxNodes = 10;
    private int[][] grid;
    Vertex[] vertexList;
    private int currentNode;
    Stack stack = new Stack();//DFS
    Que que = new Que();

    public Graph() {
        vertexList = new Vertex[maxNodes];
        grid = new int[maxNodes][maxNodes];
        currentNode = 0;
    }


    public void addVertex(char name) {
        vertexList[currentNode++] = new Vertex(name);
    }

    public void addEdge(int start, int end, int val) {
        grid[start][end] = 1;
        grid[end][start] = val;
    }

    public int check(int v) {//check adjacent nodex
        for (int i = 0; i < currentNode; i++) {
            // is a PATH and is NOT yet visited
            if (grid[v][i] == 1 && vertexList[i].isVisited == false) {
                return i;
            }
        }

        return -1;//visited
    }

    public void passInDeep(int index) {
        System.out.print(vertexList[index].name);
        vertexList[index].isVisited = true;
        stack.push(index);

        while (!stack.isEmpty()){
            int neighbour = check(stack.peek());//check adjacent nodes straight away
            if(neighbour == -1){//if visited
                neighbour = stack.pop();//extract from stack
            }else {//othervise
                System.out.print(vertexList[neighbour].name);//process
                vertexList[neighbour].isVisited = true;//mark as visited
                stack.push(neighbour);//add to stack this current adjacent
            }
        }//end of while

        for (int i = 0; i < currentNode; i++){
            vertexList[i].isVisited = false;//set back all nodes to NOT visted to do another branch depth search
        }
    }

    public void passInWidth(int index){
        System.out.print(vertexList[index].name);
        vertexList[index].isVisited = true;
        que.insert(index);

        int vertex;

        while (!que.isEmpty()){
            int temp = que.remove();

            while ((vertex = check(temp))!= -1){//if adjacent vertex is NOT visited and in path ( check)
                System.out.print(vertexList[vertex].name);
                vertexList[vertex].isVisited = true;//mark as visited
                que.insert(vertex);//add to que this adjacent
            }
        }//end of if

        for (int i = 0; i < currentNode; i++){
            vertexList[i].isVisited = false;//set back all nodes to NOT visted to do another branch depth search
        }
    }
}
