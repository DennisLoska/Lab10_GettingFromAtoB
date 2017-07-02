
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class DirectedWeightedGraph implements DirectedWeightedGraphInterface {

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private String fileGraph;

    public DirectedWeightedGraph(String fileGraph) {
        this.fileGraph = fileGraph;
        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        generateWeightedGraph();
    }

    /*
     * Erstellt den Graphen basierend auf der TextFile
     */
    @Override
    public void generateWeightedGraph() {
        //this is needed because edges cant be created before the sink Verticles are created
        ArrayList<String> edgesToCreate = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(fileGraph, "\n");

        while (st.hasMoreTokens()) {
            String currentLine = st.nextToken();
            //System.out.println(currentLine);
            StringTokenizer st2 = new StringTokenizer(currentLine);
            //src
            String src = st2.nextToken(" ");
            vertices.add(new Vertex(src));
            //other points - here a loop is needed
            while (st2.hasMoreTokens()) {
                String currentSink = st2.nextToken();
                edgesToCreate.add(currentSink + "," + src);
            }
        }
        //create the Edges
        for (String s : edgesToCreate) {
            StringTokenizer sts = new StringTokenizer(s, ",");
            String sink = sts.nextToken();
            int weight = Integer.parseInt(sts.nextToken());
            String src = sts.nextToken();
            edges.add(new Edge(getVertex(src), getVertex(sink), weight));
        }
    }

    /*
     * Exercise 3 shortest path
     * TODO: fix bug so its actually the shortest path and not the first path ever found to destination node
     */
    public void depthSearch(String start, String end) {
        Vertex node = getVertex(start);
        Vertex endNode = getVertex(end);
        Stack<Vertex> visitedNodes = new Stack<Vertex>();
        visitedNodes.add(node);
        node.setVisited(true);
        String path = "The shortest Path: \n";
        while (!visitedNodes.isEmpty()) {
            Vertex currentNode = visitedNodes.pop();
            //creates the path by appending a visited nodes name with stupid if-case
            //because of stupid name-method-implementation in Vertex class
            if (start.equals("1"))
                path += currentNode.getName() + " \n";
            else path += currentNode.getFullName() + " \n";
            //discover neighbours of the currentNodeode
            for (Vertex neighbour : getNeighbors(currentNode)) {
                if (neighbour != null && !neighbour.getVisited()) {
                    //marks all neighbour-nodes as visited
                    visitedNodes.add(neighbour);
                    neighbour.setVisited(true);
                    //print out path if end-node is found
                    if (neighbour == endNode) {
                        //again stupid if-case
                        if (start.equals("1"))
                            System.out.println(path + neighbour.getName() + "\n");
                        else System.out.println(path + neighbour.getFullName() + "\n");
                    }
                }
            }
        }
    }

    /*
     * Exercise 4 cheapest path
     */
    public void dijkstra(String start, String end) {
        Vertex v1 = getVertex(start);
        Vertex v2 = getVertex(end);
        Vertex currentNode;
        ArrayList<Vertex> unvisitedNodes = new ArrayList<Vertex>();

       /* 1. assign to every node except the starting node the distance value of infinity
        2. set initial Node as current, mark all others as unvisited, create a set of all unvisited Nodes
        ?really necessary?*/
        for (Vertex v : vertices) {
            if (v != v1) v.setDistance(Integer.MAX_VALUE);
            unvisitedNodes.add(v);
        }

        //3. calculate Distance to the first neghbours of the startingNode
        currentNode = v1;
        while (!unvisitedNodes.isEmpty()) {
            //System.out.println("currentNode: "+currentNode.toString());
            //System.out.println("unvisitedNodes: "+unvisitedNodes.toString());
            unvisitedNodes.remove(currentNode);
            for (Vertex v : getNeighbors(currentNode)) {
                int currentWeight = getEdge(currentNode, v).getWeight();
                if (currentWeight + currentNode.getDistance() < v.getDistance()) {
                    v.setDistance(currentWeight + currentNode.getDistance());
                    v.setPi(currentNode);
                }
            }

            //now we take the next node with the lowest calculated distance(from all or just from neighbours?
            int smallestDistance = Integer.MAX_VALUE;
            Vertex smallestDisVertex = currentNode;
            for (Vertex v : vertices) {
                if (unvisitedNodes.contains(v) && v.getDistance() < smallestDistance) {
                    smallestDisVertex = v;
                    smallestDistance = v.getDistance();
                }
            }

            currentNode = smallestDisVertex;
        }

        //now everything form the starting point is set & calculated, now we can calculate our fastest ways
        System.out.println("Time in sec: " + v2.getDistance() + " | " + (double) (v2.getDistance() / 60) + " min (nur Fahrzeit)");

        //find the path by going through the Pi�s - the predecessors
        String path = "the following Path: \n";
        Vertex currentV = v2;
        while (currentV != v1) {
            path += currentV.getFullName() + "\n";
            currentV = currentV.getPi();
        }
        path += currentV.getFullName() + "\n";
        System.out.println(path);
    }

    public void printPis() {
        for (Vertex v : vertices) {
            System.out.println(v.toString() + " " + v.getPi().toString());
        }
    }

    @Override
    public Edge getEdge(Vertex src, Vertex sink) {
        for (Edge e : edges) {
            if (e.getSrc() == src && e.getSink() == sink) return e;
        }
        return null;
    }

    @Override
    public Vertex getVertex(String name) {
        for (Vertex v : vertices) {
            if (v.getName().equals(name)) return v;
        }
        return null;
    }

    @Override
    public ArrayList<Vertex> getNeighbors(Vertex aVertex) {
        ArrayList<Vertex> result = new ArrayList<Vertex>();
        for (Edge e : edges) {
            if (e.getSrc() == aVertex) result.add(e.getSink());
        }
        return result;
    }

    /*
     * convertiert den Graphen zur�ck in die textversion
     */
    public String toString() {
        return fileGraph;
    }

    public String toStringOld() {
        String result = "";
        for (Vertex v1 : vertices) {
            result += v1.toString() + " ";
            for (Vertex v2 : getNeighbors(v1)) {
                result += v2.toString() + "," + getEdge(v1, v2).getWeight() + " ";
            }
            result += "\n";
        }
        return result;
    }

}
