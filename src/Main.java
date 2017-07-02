public class Main {
    public static void main(String[] args) {
        GraphFileReader r = new GraphFileReader();
        DirectedWeightedGraph g = new DirectedWeightedGraph(r.readFile("test.txt"));
        DirectedWeightedGraph g2 = new DirectedWeightedGraph(r.readFile("file.txt"));
        //g.djkstra("1", "7");
        g.depthSearch("1", "7");
        g2.depthSearch("060192001006", "060120003653");

        //Exercise 5
        System.out.println("Von Schöneweide nach Tempelhof:");
        g2.djkstra("060192001006", "060068201511");
        System.out.println("Von Schöneweide nach Botanischer Garten:");
        g2.djkstra("060192001006", "060066102852");
        System.out.println("Von Schöneweide nach Wannsee:");
        g2.djkstra("060192001006", "060053301433");
        System.out.println("Von Schöneweide nach Ostkreuz:");
        g2.djkstra("060192001006", "060120003653");

    }
}
