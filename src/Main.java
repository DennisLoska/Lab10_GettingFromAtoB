import java.io.File;

public class Main {

	public static void main(String[] args) {
		GraphFileReader r = new GraphFileReader();
		DirectedWeightedGraph g = new DirectedWeightedGraph(r.readFile("file.txt"));
		
		//g.dijkstra( g.getVertex("y") );
		
		//System.out.println( g.getWeight( g.getVertex("t")));
		System.out.println(g.toString());
		
		
		//r.readFile("file.txt");
	}

}
