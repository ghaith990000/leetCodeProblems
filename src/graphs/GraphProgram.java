package graphs;

public class GraphProgram {
    public static void main(String[] args){
        BasicGraph graph = new BasicGraph(5);

        // Add edges
        graph.addEdge(0,1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
