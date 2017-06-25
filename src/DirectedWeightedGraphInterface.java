import java.util.ArrayList;

public interface DirectedWeightedGraphInterface {

	public void addAllVerticesAndEdges();
	
	public Edge getEdge(Vertex src, Vertex sink);
	public Vertex getVertex(String name);
	public ArrayList<Vertex> getNeighbors(Vertex aVertex);
	
	
}
