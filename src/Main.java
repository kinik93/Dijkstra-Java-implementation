import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {

    private static Vertex getMinLabel(Set<Vertex> tempVertex, int min){
        Vertex minVertex = new Vertex("");
        for(Vertex v: tempVertex){
            if(v.getLabel() < min){
                minVertex = v;
                min = v.getLabel();
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {

        Graph graph = new Graph();

        //CLRS graph example
        graph.addEdge("S", "T", 10);
        graph.addEdge("S", "Y", 5);
        graph.addEdge("T", "X", 1);
        graph.addEdge("T", "Y", 2);
        graph.addEdge("X", "Z", 4);
        graph.addEdge("Z", "X", 6);
        graph.addEdge("Z", "S", 7);
        graph.addEdge("Y", "T", 3);
        graph.addEdge("Y", "X", 9);
        graph.addEdge("Y", "Z", 2);

        int n = graph.getVertexNumber();
        System.out.println("Number of vertices: " + n);
        System.out.println("Number of edges: " + graph.getEdgeNumber());
        System.out.println("\n\tGRAPH STRUCTURE\n");
        System.out.println(graph);

        int C = graph.getMaxEdgeCost();
        System.out.println("Max edge cost: " + C);

        //-----DIJKSTRA ALGORITHM----------//

        Set<Vertex> temporarlyNodes = graph.getVertices();
        Set<Vertex> permanentNodes = new HashSet<>();

        for (Vertex v: temporarlyNodes){
            if(v.getName() == "S"){
                v.setLabel(0);
                v.setPred("S");
            }
            else
                v.setLabel((n-1) * C);
        }

        while(permanentNodes.size() < n){

            Vertex minVertex = getMinLabel(temporarlyNodes, (n*C));
            ArrayList<Edge> FS = graph.adj(minVertex.getName());
            permanentNodes.add(minVertex);
            temporarlyNodes.remove(minVertex);

            for(Edge e: FS){
                for(Vertex v: temporarlyNodes){
                    if(v.getName().equals(e.destination)){
                        if(v.getLabel() > minVertex.getLabel() + e.getCost()){
                            v.setLabel(minVertex.getLabel() + e.getCost());
                            v.setPred(minVertex.getName());
                        }
                    }
                }
            }
        }


        System.out.println("\n\tSOLUTION\n");
        System.out.println("Node\tLabel\tPred");
        for (Vertex v: permanentNodes){
            System.out.println(v.getName() + "\t\t" + v.getLabel() + "\t\t" + v.getPred());
        }
    }
}
