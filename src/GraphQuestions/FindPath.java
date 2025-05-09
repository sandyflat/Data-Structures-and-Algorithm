// Program to find all paths from source(src) vertex to target(tar) vertex in graph.
// Using slightly modified DFS traversal algorithm.
package GraphQuestions;

import java.util.ArrayList;

public class FindPath {
    private static class Edge{
        int source;
        int destination;

        public Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

    // create graph
    public static void createGraph(ArrayList<Edge> graph[]){
        // create empty arraylist in each index of array of type arraylist
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    // find path from source to destination
    public static void printAllPath(ArrayList<Edge>[] graph, boolean[] visited, int currentNode, String path, int target){
        if(currentNode == target){
            System.out.println(path);
            return;
        }
        // visit all neighbours of current node/vertex
        for(int i = 0; i< graph[currentNode].size(); i++){
            Edge e = graph[currentNode].get(i);
            if(!visited[e.destination]){
                visited[currentNode] = true;
                printAllPath(graph, visited, e.destination, path+e.destination, target);
                visited[currentNode] = false;   // while returning make it false.
            }
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 7;
        /*
                 1 ------3
                /        |  \
               0         |    5 --- 6
               \         |  /
                 2 ----- 4
         */

        // creating array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];
        createGraph(graph);
        int source = 0, target = 5;
        printAllPath(graph, visited, source, "0", target);
    }
}
