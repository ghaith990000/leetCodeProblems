package graphs;

import java.util.*;

public class BasicGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public BasicGraph(int numVertices){
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for(int i=0; i<numVertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }


    }

    public void addEdge(int source, int destination){
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    public void printGraph(){
        for(int i=0; i<numVertices; i++){
            System.out.print("Vertex " + i + " is connected to: ");
            for(Integer vertex : adjacencyList[i]){
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}

