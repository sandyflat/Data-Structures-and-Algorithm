// Topological Sorting implementation from scratch. O(V + E).
// It is used only for DAGs (Directed Acyclic Graph).
// DAG is a directed graph with no cycles.
// Topological sorting is a linear ordering of vertices in DAGs such that for every directed edge,
// u --> v, vertex 'u' appears/comes before vertex 'v' in the ordering.
// Applications :- Task Scheduling, Dependency Resolution , Course Prerequisites.
// Approach Using modified Depth-First Search (DFS).
package TopologicalSorting;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
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

        // graph[0] and graph[1] doesn't have any neighbours. ie vertex 0 and 1

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    // topological sorting logic
    public static void topologicalSortingUtil(ArrayList<Edge>[] graph, int currentNode, boolean[] visited, Stack<Integer> stack){
        visited[currentNode] = true;

        for(int i = 0; i<graph[currentNode].size(); i++){
            Edge e = graph[currentNode].get(i);

            if(!visited[e.destination]){    // if not visited.
                topologicalSortingUtil(graph, e.destination, visited, stack);
            }
        }
        stack.push(currentNode);    // push currentNode/ parent while returning into stack.
    }

    // checks for every vertex.
    public static void topSort(ArrayList<Edge>[] graph, int vertices){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<vertices; i++){
            if(!visited[i]){
                topologicalSortingUtil(graph, i, visited, stack);
            }
        }

        // print/pop elements from stack at last.
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 6;
        /*
                5 -----> 0 <------ 4
                |                  |
                |                  |
                |                  |
               \|/                \|/
                2 -----> 3 ------> 1
         */

        // creating array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[noOfVertices];
        createGraph(graph);
        topSort(graph, noOfVertices);
    }
}
