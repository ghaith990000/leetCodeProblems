package graphs;
import java.util.*;
public class DirectedGraph {
    static void addEdge(Vector<Integer> adj[], int u, int v)
    {
        adj[u].add(v);
    }

    // Function to print adjacency list
    static void adjacencylist(Vector<Integer> adj[], int V)
    {
        for(int i=0; i<V; i++){
            System.out.print(i + "->");
            for (int x : adj[i]){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    // Function to initialize the adjacency list of the given graph
    static void initGraph(int V, int edges[][], int noOfEdges)
    {
        // to represent graph as adjacency list
        @SuppressWarnings("unchecked")
        Vector<Integer> adj[] = new Vector[V];
        for(int i = 0; i<adj.length; i++){
            adj[i] = new Vector<>();
        }

        // Traverse edges array and make edges
        for(int i=0; i<noOfEdges; i++){
            addEdge(adj, edges[i][0], edges[i][1]);
        }

        adjacencylist(adj, V);
    }

    public static void main(String[] args){
        // Given vertices
        int V = 6;

        int edges[][] = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};

        int noOfEdges = 5;

        initGraph(V, edges, noOfEdges);
    }
}
