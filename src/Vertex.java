
public class Vertex {
	
	
	
	private int distance;	 // for dijkstra
	private Vertex pi;       //for djkstra
	private String name;
	//boolean visited = false;  // for djkstra

	public Vertex(String name) {
		this.name = name;
		distance= 0;
		setPi(null);
	}
	
	public String toString(){
		return "name[" + name + "]";
		
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Vertex getPi() {
		if(pi!=null){
		return pi;
		}
		return new Vertex("kein");
	}

	public void setPi(Vertex pi) {
		this.pi = pi;
	}
	
	/*public void setVisited(){
		visited = true;
	}
	
	public void setUnVisited(){
		visited = false;
	}*/

}
