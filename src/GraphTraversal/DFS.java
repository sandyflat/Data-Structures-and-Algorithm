// Depth First Search (DFS) graph traversal implementation from scratch. O(V + E)
// Traverse or search a graph by exploring as far as possible along each branch/neighbours
// before backtracking. (Depth-wise)
// Utilizes a recursion or stack for traversal.
// Explores a graph as deep as possible along one path before backtracking.
// Suitable for detecting cycles and topological sorting.
package GraphTraversal;

import java.util.ArrayList;

// unweighted and undirected graph
public class DFS {
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

    //Depth First Search (DFS)
    public static void depthFirstSearch(ArrayList<Edge>[] graph, int currentNode, boolean[] visited){
        System.out.print(currentNode + " ");
        visited[currentNode] = true;

        // visit every neighbour of current vertex.
        for(int i =0; i<graph[currentNode].size(); i++){
            Edge e = graph[currentNode].get(i);

            if(visited[e.destination] == false){
                depthFirstSearch(graph, e.destination, visited);     // recursive call
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
        depthFirstSearch(graph, 0, visited);
    }
}
