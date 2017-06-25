import java.io.File;

public class Main {

	public static void main(String[] args) {
		GraphFileReader r = new GraphFileReader();
		DirectedWeightedGraph g = new DirectedWeightedGraph(r.readFile("file.txt"));
		//System.out.println(g.toString());
		g.djkstra("1","7");
	}

	
}
