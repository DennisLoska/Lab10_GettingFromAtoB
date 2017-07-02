import java.io.File;

public class Main {
    public static void main(String[] args) {
        GraphFileReader r = new GraphFileReader();
        DirectedWeightedGraph g = new DirectedWeightedGraph(r.readFile("test.txt"));
        DirectedWeightedGraph g2 = new DirectedWeightedGraph(r.readFile("file.txt"));
        //System.out.println(g.toString());
        //g.djkstra("1", "7");
        g.depthSearch("1", "7");
        g2.djkstra("060192001006", "060120003653");
        g2.depthSearch("060192001006", "060120003653");
    }
}
