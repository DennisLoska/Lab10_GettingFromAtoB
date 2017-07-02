import java.io.BufferedReader;
import java.io.FileReader;

public class Vertex {
    // for dijkstra
    private int distance;
    private Vertex pi;
    private String name;
    private String letterName;
    private boolean visited = false;
    Vertex(String name) {
        this.name = name;
        distance = 0;
        setPi(null);
    }

    public String toString() {
        return "name[" + name + "]";

    }

    String getName() {
        return name;
    }

    /*
        Exercise 5
     */
    String getFullName(){
        String currentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader("stationNames.txt"));
            while((currentLine=br.readLine())!=null){
                if (currentLine.contains(this.name))
                    letterName=currentLine;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sth went wrong");
        }
        return letterName;
    }

    int getDistance() {
        return distance;
    }

    void setDistance(int distance) {
        this.distance = distance;
    }

    Vertex getPi() {
        if (pi != null) {
            return pi;
        }
        return new Vertex("kein");
    }

    void setPi(Vertex pi) {
        this.pi = pi;
    }

	public void setVisited(boolean visited){
        this.visited=visited;
	}

	public boolean getVisited(){
		return this.visited;
	}

}
