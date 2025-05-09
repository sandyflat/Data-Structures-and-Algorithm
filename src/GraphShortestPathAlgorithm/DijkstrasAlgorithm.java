// Dijkstra's Algorithm implementation from scratch. (for positive weights).
// It is the shortest path algorithm used to find the shortest path from a source vertex to
// all other vertex. (ie every vertex).
// Works for both directed and undirected graphs but requires non-negative weights.
// Greedy algorithm that expands the nearest (with less distance/weight) unvisited vertex first.
// Approach using a priority queue to store vertices based on their tentative distances.
// Applications :- Network Routing, GPS and Navigation systems, Transportation, Pathfinding,
// Telecommunication, Social Networks, Electrical Circuit Design, Urban Planning etc.
package GraphShortestPathAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
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

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

        // graph[5]/ vertex 5 doesn't have any neighbours.

    }

    public static class Pair implements Comparable<Pair>{        // make Pair type comparable
        int node;          // vertex of graph.
        int distance;

        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

        // overriding pre-defined method of Comparable interface.
        @Override
        public int compareTo(Pair p2) {
            return this.distance - p2.distance;    // ascending sorting

            // negative: current object comes before parameter object.
            // positive: current object comes after parameter object.
            // zero: objects are equal.
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int sourceVertex, int noOfVertices ){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        StringBuilder path = new StringBuilder(" ");       // tracks path of vertex traversal.

        int[] distance = new int[noOfVertices];     // keeps track of each vertex distance. (updated)
        // initially initializing each vertex's distance with infinity number.
        for(int i = 0; i<noOfVertices; i++){
            if(i != sourceVertex){      // except source vertex.
                distance[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] visited = new boolean[noOfVertices];

        priorityQueue.add(new Pair(0, 0));    // firstly adding source pair.
        // The priorityQueue automatically uses the compareTo() method to maintain the elements,
        // in sorted order and ensures that the Pair object with the smallest distance value ,
        // is always at the front of the queue (the head).

        // same bfs code
        while(!priorityQueue.isEmpty()){
            Pair currentNode = priorityQueue.remove();    // returns vertex with smallest distance.
            if(!visited[currentNode.node]){
                visited[currentNode.node] = true;
                path.append(currentNode.node);

                for(int i = 0; i<graph[currentNode.node].size(); i++){
                    Edge e = graph[currentNode.node].get(i);
                    int u = e.source;
                    int v = e.destination;

                    // main logic (relaxation)
                    if(distance[u] + e.weight < distance[v]){
                        distance[v] = distance[u] + e.weight;
                        priorityQueue.add(new Pair(v,distance[v]));
                    }
                }
            }
        }

        // printing
        System.out.println("Path of traversal of each vertex: "+ path);
        System.out.print("Distance from source to each vertex: ");
        System.out.println();
        for(int i = 0; i<noOfVertices; i++){
            System.out.print("Distance from vertex " + sourceVertex + " to vertex " + i + " = ");
            System.out.println(distance[i] + " ");
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 6;
        /*
                            7
                    ->(1) ------->(3)
                   /   |         /|\  \
                2 /    |          |    \ 1
                 /     |          |    \|/
               (0)     | 1      2 |    (5)
                 \     |          |    /|\
                  \    |          |    /
                 4 \   |          |   / 5
                    \  |          |  /
                     \|/          | /
                     (2) -------->(4)
                            3
         */

        // creating array of arraylist
        ArrayList<Edge> graph[] = new ArrayList[noOfVertices];
        createGraph(graph);
        dijkstra(graph, 0, noOfVertices);
    }
}
