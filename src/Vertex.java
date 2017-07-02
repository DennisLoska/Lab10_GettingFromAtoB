public class Vertex {

    // for dijkstra
    private int distance;
    private Vertex pi;

    private String name;
    boolean visited = false;

    Vertex(String name) {
        this.name = name;
        distance = 0;
        setPi(null);
    }

    public String toString() {
        return "name[" + name + "]";

    }

    String getName() {
        return name;
    }

    int getDistance() {
        return distance;
    }

    void setDistance(int distance) {
        this.distance = distance;
    }

    Vertex getPi() {
        if (pi != null) {
            return pi;
        }
        return new Vertex("kein");
    }

    void setPi(Vertex pi) {
        this.pi = pi;
    }

    public void setVisited() {
        visited = true;
    }

    public void setUnVisited() {
        visited = false;
    }

}
