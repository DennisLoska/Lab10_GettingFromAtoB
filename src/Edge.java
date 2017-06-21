
public class Edge {

	private Vertex src;
	private Vertex sink;
	private int weight;

	public Edge(Vertex src, Vertex sink, int weight) {
		this.src = src;
		this.sink = sink;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public Vertex getSrc() {
		return src;
	}

	public Vertex getSink() {
		return sink;
	}
	
	public String toString(){
		return "src[" + src.toString() + "],sink[" + sink.toString() +"],weight(" + weight + ")";
		
	}

}
