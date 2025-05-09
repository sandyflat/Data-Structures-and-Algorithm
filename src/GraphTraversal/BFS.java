// Breadth First Search (BFS) graph traversal implementation from scratch. O(V + E)
// Traverse or search a graph level by level and explores all the vertices at the
// current depth before moving to the next level,
// Start from a source vertex and visit all adjacent vertices of the current vertex,
// it means go to immediate neighbours first.
// Utilizes a queue to keep track of the vertices to be explored.
// Suitable for finding the shortest path in an unweighted graph.
package GraphTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// unweighted and undirected graph
public class BFS {
    static class Edge{
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

    // Breadth first search
    public static void breadthFirstSearch(ArrayList<Edge> graph[], int vertices){
        Queue<Integer> queue = new LinkedList<>();   // keep neighbours of current node in queue
        boolean[] visitedNode = new boolean[vertices];  // keep tracks whether current node is visited
                                                         // already or not
        queue.add(0);            // firstly add starting vertex in queue

        while(!queue.isEmpty()){
            int currentVertex = queue.remove();   // assign value and then remove it.
            if(visitedNode[currentVertex] == false){
                System.out.print(currentVertex + " ");     // print current vertex
                visitedNode[currentVertex] = true;

                // then add all neighbours of current vertex in queue
                for(int i = 0; i<graph[currentVertex].size(); i++){
                    Edge e = graph[currentVertex].get(i);
                    queue.add(e.destination);
                }
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
        ArrayList<Edge> graph[] = new ArrayList[noOfVertices];
        createGraph(graph);
        breadthFirstSearch(graph, noOfVertices);
    }
}
