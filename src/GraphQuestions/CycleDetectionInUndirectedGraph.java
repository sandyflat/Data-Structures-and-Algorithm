// Program to find whether the undirected graph is cyclic or not.(Undirected Graph)
// Prints true if found cyclic, otherwise print nothing.
// Approach using modified DFS.
package GraphQuestions;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraph {
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
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));

    }

    // check cyclic or not.
    public static boolean isCycleUndirected(ArrayList<Edge>[] graph, boolean[] visited, int currentNode, int parent ){
        visited[currentNode] = true;

        for(int i = 0; i<graph[currentNode].size(); i++){
            Edge e = graph[currentNode].get(i);

            // condition 1
            if(visited[e.destination] && e.destination!= parent){
                return true;
            }
            // condition 2
            else if(!visited[e.destination]){
                if(isCycleUndirected(graph, visited, e.destination, currentNode)){   // if returns true.
                    return true;
                }
            }
        }
        return false; // if any cycle doesn't exist then just return false.
    }

    public static void main(String[] args) {
        int noOfVertices = 6;
        /*
                0 ------ 1 ------- 2
                 \       |         |
                  \      |         |
                   \     |         |
                     \   |         |
                       \ |         |
                         4         3
                          \
                            \
                              \
                               5
         */

        // creating array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];
        createGraph(graph);
        System.out.println(isCycleUndirected(graph,new boolean[noOfVertices],0, -1));
    }
}
