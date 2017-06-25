import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Exercise 2 read a graph from a file - saves the wohile Graph in a string without spaces
 */
public class GraphFileReader {
	 
	public GraphFileReader(){
		
	}
	/*
	 * liest eine TExtFile des Graphen im folgendem Format:   
	 * SourceVertexName SinkVertex1,1Weight SinkVertex2,2Weight...SinkVertexN,NWeight
	 */
	
	public DirectedWeightedGraph readFileOld(File file){
		String result="";
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				result+=sc.next();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found");
		}
		
		System.out.println(result);//Stattdessen eine Methode die die String in einen Graphen converted
		return null;
	}
	
	public DirectedWeightedGraph readFile(String filename){
		String result="";
		String currentLine="";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while((currentLine=br.readLine())!=null){
				result+=currentLine;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("smth went wrong");
		}
		
		System.out.println(result);//Stattdessen eine Methode die die String in einen Graphen converted
		return null;
		
}
}
