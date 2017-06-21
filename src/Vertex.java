
public class Vertex {
	
	
	
	private int distance;	 // for dijkstra
	private Vertex pi;
	private String name;

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
		return pi;
	}

	public void setPi(Vertex pi) {
		this.pi = pi;
	}

}
