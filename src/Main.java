import java.io.File;

public class Main {

	public static void main(String[] args) {
		DirectedWeightedGraph g = new DirectedWeightedGraph();
		g.addAllVerticesAndEdges();
		
		g.dijkstra( g.getVertex("y") );
		
		System.out.println( g.getWeight( g.getVertex("t")));
		
		GraphFileReader r = new GraphFileReader();
		r.readFile("file.txt");
	}

}
