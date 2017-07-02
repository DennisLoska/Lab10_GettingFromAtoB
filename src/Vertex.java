import java.io.BufferedReader;
import java.io.FileReader;

public class Vertex {

    private int distance;     // for dijkstra
    private Vertex pi;
    private String name;
    private String letterName;
    //boolean visited = false;
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

	/*public void setVisited(){
		visited = true;
	}

	public void setUnVisited(){
		visited = false;
	}*/

}
