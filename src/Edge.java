public class Edge {

    String destination;
    int cost;
    int capacity;

    public Edge(String destination, int cost){
        this.destination = destination;
        this.cost = cost;
        this.capacity = -1;
    }

    public Edge(String destination, int cost, int capacity ){
        this.destination = destination;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        if(capacity > 0)
            return "[Destination: '" + this.destination + "', Cost: '" + this.cost + "', Capacity: '" + this.capacity + "']";
        else
            return "[Destination: '" + this.destination + "', Cost: '" + this.cost + "]";
    }
}
