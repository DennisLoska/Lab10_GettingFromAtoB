
public class Edge {

    private Vertex src;
    private Vertex sink;
    private int weight;

    Edge(Vertex src, Vertex sink, int weight) {
        this.src = src;
        this.sink = sink;
        this.weight = weight;
    }

    int getWeight() {
        return weight;
    }

    Vertex getSrc() {
        return src;
    }

    Vertex getSink() {
        return sink;
    }

    public String toString() {
        return "src[" + src.toString() + "],sink[" + sink.toString() + "],weight(" + weight + ")";
    }

}
