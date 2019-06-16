import java.awt.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class Graph {

    Map<Vertex, ArrayList<Edge>> graph;

    public Graph(){
        this.graph = new HashMap<>();
    }

    public void addEdge(String source, String destination, int cost){
        ArrayList<Edge> adjList = this.graph.get(new Vertex(source));
        if (adjList != null){
            adjList.add(new Edge(destination, cost));
        }
        else {
            ArrayList<Edge> tmp = new ArrayList<>();
            tmp.add(new Edge(destination, cost));
            this.graph.put(new Vertex(source), tmp);
            this.graph.putIfAbsent(new Vertex("T"), new ArrayList<>()); //for vertices with only incoming arcs
        }
    }

    public void addEdge(String source, String destination, int cost, int capacity){
        ArrayList<Edge> adjList = this.graph.get(new Vertex(source));
        if (adjList != null){
            adjList.add(new Edge(destination, cost, capacity));
        }
        else {
            ArrayList<Edge> tmp = new ArrayList<>();
            tmp.add(new Edge(destination, cost, capacity));
            this.graph.put(new Vertex(source), tmp);
        }
    }

    public String toString(){
        String output = "";
        for (Map.Entry<Vertex, ArrayList<Edge>> entry : this.graph.entrySet()) {
            output = output + entry.getKey().getName() + " -> " + entry.getValue() + "\n";
        }
        return output;
    }

    public int getVertexNumber(){
        return this.graph.size();
    }
    
    public int getEdgeNumber(){
        int total = 0;
        for (Vertex v: this.graph.keySet()) {
            total += this.graph.get(v).size();
        }
        return total;
    }

    public Set<Vertex> getVertices(){
        return this.graph.keySet();
    }

    public int getMaxEdgeCost(){
        int max = -1;
        for (Vertex v: this.graph.keySet()) {
            for (Edge e: this.graph.get(v)){
                if(e.getCost() > max)
                    max = e.getCost();
            }
        }
        return max;
    }

    public ArrayList<Edge> adj(String v){
        return this.graph.get(new Vertex(v));
    }
}
