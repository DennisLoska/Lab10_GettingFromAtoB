import java.util.ArrayList;

public interface DirectedWeightedGraphInterface {

	public void addAllVerticesAndEdges();
	
	public Edge getEdge(Vertex src, Vertex sink);
	public Vertex getVertex(String name);
	public ArrayList<Vertex> getNeighbors(Vertex aVertex);
	
	public void dijkstra(Vertex start);
	public int getWeight(Vertex sink);
}
