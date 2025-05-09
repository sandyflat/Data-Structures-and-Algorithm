// Program to find whether the directed graph is cyclic or not.(Directed Graph)
// Prints true if found cyclic, otherwise print nothing.
// Approach using modified DFS.
package GraphQuestions;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
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

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));

    }

    // check cyclic or not.
    public static boolean isCycleDirected(ArrayList<Edge>[] graph, boolean[] visited, int currentNode, boolean[] recursionStack){
        visited[currentNode] = true;
        recursionStack[currentNode] = true;    // this array is used for detecting cycle.

        // visit every neighbour of current vertex.
        for(int i = 0; i< graph[currentNode].size(); i++){
            Edge e = graph[currentNode].get(i);
            if(recursionStack[e.destination]){
                return true;
            }else if(!visited[e.destination]){
                if(isCycleDirected(graph, visited, e.destination, recursionStack)){
                    return true;
                }
            }
        }

        recursionStack[currentNode] = false;
        return false;
    }

    public static void main(String[] args) {
        int noOfVertices = 4;
        /*
          0 → 2 → 3 → 0
          ↑
          |
          1

         */

        // creating array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];
        createGraph(graph);

        boolean[] visited = new boolean[noOfVertices];
        boolean[] recursionStack = new boolean[noOfVertices];
        for(int i = 0; i<noOfVertices; i++){
            if(!visited[i]){
                // starts from each vertex because there may be a vertex which does not have parent.
                // hence it tries to traverse from each vertex of graph
                boolean isCycle = isCycleDirected(graph, visited, 0, recursionStack);
                if(isCycle){
                    System.out.println(isCycle);   // if cycle exists print true otherwise doesn't print anything.
                    // if any single cycle detected then there is no need to check for others so break.
                    break;
                }
            }
        }
    }
}
