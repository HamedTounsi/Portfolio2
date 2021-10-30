/* Made by
 * Hamed Tounsi - 68841
 * Rasmus Laue Petersen - 68907
 * Mansour Hamidi - 68903
 * Kush Max Kei - 68924
 * */

import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private int MST;

    //Graph Constructor
    public Graph(){
        this.vertices = new ArrayList<Vertex>();
    }

    public int getMST(){
        return MST;
    }

    //Add a vertex to the ArrayList(Vertices)
    public void addVertex(Vertex v){
        vertices.add(v);
    }

    //Add edge both ways (Undirected), Only if src and dest is in the ArrayList(Vertices)
    public void addEdge(Vertex src, Vertex dest, int km){
        if (!vertices.contains(src) || !vertices.contains(dest)){
            System.err.println("Missing vertex!");
            return;
        }

        //Creates an Edge both ways (Undirected)
        Edge newEdge = new Edge(src, dest, km);
        Edge secondNewEdge = new Edge(dest, src, km);
    }

    public void printGraph(){
        for (int src = 0; src<vertices.size(); src++) {
            System.out.println("Edges from vertex: "+ vertices.get(src).getName());
            for (int dest = 0; dest < vertices.get(src).getOutEdge().size(); dest++) {
                System.out.println(" The distance to "+vertices.get(src).getOutEdge().get(dest).getDestVertex().getName()+" is "+
                        vertices.get(src).getOutEdge().get(dest).getKm()+" km.");
            }
            System.out.println(" ");
        }
    }

    //Run time T = O(E log V)
    public void MSTPrims(){

        //ArrayList<Pair> VertexPairs = new ArrayList<>();
        MinHeap<Vertex> Q = new MinHeap<>();


        if (vertices.size() > 0) {
            vertices.get(0).setDistance(0); //O(1)


            for (int i = 0; i < vertices.size(); i++) { //O(v)
                Q.insert(vertices.get(i));
            }

            this.MST = 0; //O(1)

            while (!Q.isEmpty()) { //O(V)
                Vertex src = Q.extractMin(); //O(log v)
                for (int e0 = 0; e0 < src.getOutEdge().size(); e0++) { //O(+2e)
                    Vertex destinationVertex = src.getOutEdge().get(e0).getDestVertex();
                    if (src.getOutEdge().get(e0).getKm() < destinationVertex.getDistance()) { //O(1)
                        destinationVertex.setDistance(src.getOutEdge().get(e0).getKm());
                        destinationVertex.setPredecessor(src);
                        int position = Q.getPosition(destinationVertex);
                        Q.decreasekey(position); //O(log v)
                    }
                }
                this.MST += src.getDistance();
            }
        }
    }

    public void printPrims(){
        System.out.println("Minimum spanning tree distance");
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getPredecessor() != null) {
                System.out.println(vertices.get(i).getPredecessor().getName() + " to " +
                        vertices.get(i).getName() + " weight " + vertices.get(i).getDistance() + "km");
            }
        }
        System.out.println("Total cost: "+getMST()*100000);
    }
}
