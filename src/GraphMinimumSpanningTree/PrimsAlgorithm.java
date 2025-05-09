// Prim's Algorithm implementation from scratch.
// It is a greedy algorithm used to find the minimum spanning tree(MST) of a connected, weighted graph.
// It constructs the MST by starting with a single vertex and expanding it by repeatedly adding ,
// the smallest edge (edge with minimum cost) that connects a new vertex to the tree.
// gradually includes all vertices while ensuring no cycles are formed.
// Approach is almost similar as like Dijkstra's Algorithm but the difference in this algorithm is,
// there is no relaxation process.
package GraphMinimumSpanningTree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));

    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void primsAlgorithm(ArrayList<Edge>[] graph, int noOfVertices){
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();   // non-MST set
        boolean[] visited = new boolean[noOfVertices];               // MST set
        int[] parent = new int[noOfVertices];                        // Array to store parent of each node.
        ArrayList<Edge> mstEdges = new ArrayList<>();

        // Initialize parent array
        for(int i = 0; i< noOfVertices; i++){
            parent[i] = -1;    // indicates no parent initially .
        }

        priorityQueue.add(new Pair(0, 0));
        int mstCost = 0;

        while(!priorityQueue.isEmpty()){
            Pair currentNode = priorityQueue.remove();

            if(!visited[currentNode.node]){
                visited[currentNode.node] = true;
                mstCost += currentNode.cost;

                // If the current node has a parent, add the edge to mstEdge ArrayList
                if(parent[currentNode.node] != -1){
                    mstEdges.add(new Edge(parent[currentNode.node],currentNode.node,currentNode.cost));
                }

                for(int i = 0; i<graph[currentNode.node].size(); i++){
                    Edge e = graph[currentNode.node].get(i);
                    if(!visited[e.destination]){
                        priorityQueue.add(new Pair(e.destination,e.weight));
                        parent[e.destination] = currentNode.node;   // update parent of destination
                    }
                }
            }
        }
        System.out.println("minimum cost of MST: " + mstCost);
        System.out.println("Edges in the MST:");
        for(Edge e : mstEdges){
            System.out.println("Source: " + e.source + ", Destination: " + e.destination + ", Weight: " + e.weight);
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 4;
        /*
                          (0)
                         / |  \
                   10  /   |    \ 15
                     /     |      \
                   (1)     |      (2)
                     \     | 30   /
                      \    |     /
                   40  \   |    / 50
                        \  |   /
                         \ |  /
                          \| /
                           (3)
         */

        // creating array of arraylist
        ArrayList<Edge> graph[] = new ArrayList[noOfVertices];
        createGraph(graph);
        primsAlgorithm(graph,noOfVertices);
    }
}
