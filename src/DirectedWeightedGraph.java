import java.util.ArrayList;

public class DirectedWeightedGraph implements DirectedWeightedGraphInterface{

	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	
	public DirectedWeightedGraph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}

	public static void main(String[] args) {
		DirectedWeightedGraph g = new DirectedWeightedGraph();
		g.addAllVerticesAndEdges();
		
		g.dijkstra( g.getVertex("y") );
		
		System.out.println( g.getWeight( g.getVertex("t")));

	}



	@Override
	public void addAllVerticesAndEdges() {
		// Vertices
		Vertex s = new Vertex("s");
		Vertex t = new Vertex("t");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex z = new Vertex("z");
		vertices.add(s);
		vertices.add(t);
		vertices.add(x);
		vertices.add(y);
		vertices.add(z);
		Edge e1 = new Edge(s,t,10);
		Edge e2 = new Edge(s,y,5);
		Edge e3 = new Edge(t,x,1);
		Edge e4 = new Edge(t,y,2);
		Edge e5 = new Edge(x,z,4);		
		Edge e6 = new Edge(y,t,3);
		Edge e7 = new Edge(y,x,9);
		Edge e8 = new Edge(y,z,2);		
		Edge e9 = new Edge(z,s,7);
		Edge e10 = new Edge(z,x,6);
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);
		edges.add(e6);
		edges.add(e7);
		edges.add(e8);
		edges.add(e9);
		edges.add(e10);
		
		System.out.println(vertices);
		System.out.println(edges);
	}

	

	@Override
	public Edge getEdge(Vertex src, Vertex sink) {
		for(Edge e : edges){
			if(e.getSrc() == src && e.getSink() == sink) return e;
		}
		return null;
	}

	@Override
	public Vertex getVertex(String name) {
		for(Vertex v : vertices){
			if(v.getName().equals(name)) return v;
		}
		return null;
	}

	@Override
	public ArrayList<Vertex> getNeighbors(Vertex aVertex) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		for(Edge e : edges){
			if(e.getSrc() == aVertex) result.add(e.getSink());
		}
		return result;
	}

	@Override
	public void dijkstra(Vertex start) {
		
		for(Vertex v : vertices) {
			v.setDistance(Integer.MAX_VALUE);
		}		
		start.setDistance(0);
		
		ArrayList<Vertex> S = new ArrayList<Vertex>(); //list of vertices processed so far
		ArrayList<Vertex> Q = new ArrayList<Vertex>(vertices); //list of vertices processed so far
		
		while(Q.size() != 0){
			
			for(Vertex  v : vertices){
				S.add(v);
				Q.remove(v);
				ArrayList<Vertex> neighbors = getNeighbors(v);
				for(Vertex n : neighbors){
					if(n.getDistance() > v.getDistance() + getEdge(v, n).getWeight()){
						n.setDistance( v.getDistance() + getEdge(v, n).getWeight() );
						n.setPi(v);
					}
				}
			}
		}
		
		
		
	}

	@Override
	public int getWeight(Vertex sink) {
		
		return sink.getDistance();
	}
	
	
	public Vertex getPi(Vertex sink) {
		
		return sink.getPi();
	}

}
