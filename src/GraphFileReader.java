import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Exercise 2 read a graph from a file - saves the wohile Graph in a string without spaces
 */
public class GraphFileReader {
    public GraphFileReader() {}
    /*
	 * liest eine TextFile des Graphen im folgendem Format:
	 * SourceVertexName SinkVertex1,1Weight SinkVertex2,2Weight...SinkVertexN,NWeight
	 */
    public String readFile(String filename) {
        String result = "";
        String currentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((currentLine = br.readLine()) != null) {
                result += currentLine + "\n";
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sth went wrong");
        }
        return result;
    }
}
