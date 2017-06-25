import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DirectedWeightedGraph implements DirectedWeightedGraphInterface{

	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	private String fileGraph;
	
	public DirectedWeightedGraph(String fileGraph) {
		this.fileGraph = fileGraph;
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		addAllVerticesAndEdges();
	}
	
	/*
	 * Erstellt den Graphen basierend auf der textFile
	 */
	@Override
	public void addAllVerticesAndEdges() {
		ArrayList<String> edgesToCreate  = new ArrayList<String>(); //this is needed because edges cant be created before the sink Verticles are created
		StringTokenizer st = new StringTokenizer(fileGraph, "\n");
		
		while(st.hasMoreTokens()){
			String currentLine = st.nextToken();
			//System.out.println(currentLine);
			
			StringTokenizer st2 = new StringTokenizer(currentLine);
			//src
			//System.out.println(st2.nextToken(" "));
			String src = st2.nextToken(" ");
			vertices.add(new Vertex(src));
			//other points - here a loop is needed
			while(st2.hasMoreTokens()){
				String currentSink = st2.nextToken();
				//System.out.println(currentSink);
				edgesToCreate.add(currentSink + "," + src);
			}
		}
		//create the Edges
		for(String s: edgesToCreate){
			StringTokenizer sts = new StringTokenizer(s,",");
			String sink = sts.nextToken();
			int weight = Integer.parseInt(sts.nextToken());
			String src = sts.nextToken();
			//System.out.println("src " + src+", sink "+sink+", weight "+weight);
			edges.add(new Edge(getVertex(src),getVertex(sink),weight));
		}
	}
	/* die obere methode macht das gleiche, nur eingelesen aus einer textfile
	@Override
	public void addAllVerticesAndEdges() {
		// Vertices
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex g = new Vertex("g");
		Vertex h = new Vertex("h");
		vertices.add(a);
		vertices.add(b);
		vertices.add(c);
		vertices.add(d);
		vertices.add(e);
		vertices.add(f);
		vertices.add(g);
		vertices.add(h);
		
		Edge e1 = new Edge(a,b,1);
		Edge e2 = new Edge(a,h,2);
		Edge e3 = new Edge(b,a,1);
		Edge e4 = new Edge(b,c,1);
		Edge e5 = new Edge(c,b,1);		
		Edge e6 = new Edge(c,d,1);
		Edge e7 = new Edge(d,c,1);
		Edge e8 = new Edge(d,e,1);		
		Edge e9 = new Edge(e,d,1);
		Edge e10 = new Edge(e,f,1);
		Edge e11 = new Edge(f,e,1);
		Edge e12 = new Edge(f,g,1);
		Edge e13 = new Edge(g,f,1);
		Edge e14 = new Edge(g,h,1);
		Edge e15 = new Edge(h,g,1);
		Edge e16 = new Edge(h,a,2);
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
		edges.add(e11);
		edges.add(e12);
		edges.add(e13);
		edges.add(e14);
		edges.add(e15);
		edges.add(e16);
		
		
		System.out.println(vertices);
		System.out.println(edges);
	}
	*/
	

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

	//TODO dies kommt in die Main
	/*@Override
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
	*/

	/*@Override
	public int getWeight(Vertex sink) {
		
		return sink.getDistance();
	}*/
	
	
	public Vertex getPi(Vertex sink) {
		
		return sink.getPi();
	}
	
	/*
	 * convertiert den Graphen zurück in die textversion
	 */
	public String toString(){
		String result="";
		for(Vertex v1:vertices){
			result += v1.toString() + " ";
			for(Vertex v2: getNeighbors(v1)){
				result+= v2.toString() + "," + getEdge(v1,v2).getWeight() +" ";
			}
			result += "\n";
		}
		return result;
	}

}
