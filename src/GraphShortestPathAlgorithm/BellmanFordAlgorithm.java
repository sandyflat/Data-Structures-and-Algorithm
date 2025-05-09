// Bellman-Ford algorithm implementation from scratch.  (for negative weights also).
// Same like Dijkstra's Algorithm, used to find the shortest path from a single source vertex
// to all other vertices in a weighted graph.
// Unlike Dijkstra's Algorithm, the Bellman-Ford algorithm works for graphs with negative weight edges.
// But it cannot handle graphs with negative weight cycles(cycles where the total weight is negative).
// A graph is represented by edges.
// Perform same relaxation approach but repeat this for V-1 times (V = number of vertices).
// Slower compared to Dijkstra's algorithm.
// Applications :- Network Routing Protocol, Negative weight cycle detection etc
package GraphShortestPathAlgorithm;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // create graph
    public static void createGraph(ArrayList<Edge> graph[]){
        // create empty arraylist in each index of array of type arraylist
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2, -4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-10));     // change weight -1 to -10 then
                                                                  // it becomes negative weight cycle

    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int sourceVertex, int noOfVertices){
        int[] distance = new int[noOfVertices];

        // initialize distance of each vertex except source vertex with infinity/max value.
        for(int i = 0; i<noOfVertices; i++){
            if(i != sourceVertex){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for(int k = 0; k<noOfVertices-1; k++){
            for(int i = 0; i<noOfVertices; i++){
                for(int j = 0; j<graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;

                    if(distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]){
                        distance[v] = distance[u] + e.weight;
                    }
                }
            }
        }

        // Since Bellman-Ford algorithm doesn't work for negative weight cycles hence we can
        // check whether the graph is negative weighted cycle graph by using same code above
        // from line 59 to line 69 once again .
        // If the distance goes on updating more than V-1 times then we can verify there is
        // negative weight cycle in graph.
        // so again executing one more loop to detect negative weight cycle

        for(int i = 0; i<noOfVertices; i++){
            for(int j = 0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                int u = e.source;
                int v = e.destination;

                if(distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]){
                    System.out.println("Negative weight cycle present in the graph.");
                }
            }
        }
        // above code from line 79 to line 89 is only for detecting negative weight cycle in graph.
        // we don't have to use in our regular algorithm if we are already sure about graph.
        // keep going from line 94.

        for(int i=0; i<distance.length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int noOfVertices = 5;
        /*
                      2               -1
               (0) --------> (1) <----------- (4)
                 \            |               /|\
                  \           |                |
                 4 \          | -4             | 4
                    \         |                |
                     \        |                |
                      \       |                |
                        \     |                |
                          \   |                |
                            \|/        2       |
                             (2) ------------>(3)

         */

        // creating array of arraylist
        ArrayList<Edge> graph[] = new ArrayList[noOfVertices];
        createGraph(graph);
        bellmanFord(graph,0,noOfVertices);
    }
}
