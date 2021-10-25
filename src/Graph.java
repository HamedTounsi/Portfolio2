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
            System.out.println("Edges from vertex: "+src);
            for (int dest = 0; dest < vertices.get(src).getOutEdge().size(); dest++) {
                System.out.println(" The distance to "+vertices.get(src).getOutEdge().get(dest)+" is "+
                        vertices.get(src).getOutEdge().get(dest).getKm()+" km.");
            }
            System.out.println(" ");
        }
    }

    //Run time T = O(E log V)
    public void MSTPrims(){

        //ArrayList<Pair> VertexPairs = new ArrayList<>();
        MinHeap<Vertex> Q = new MinHeap<>();


        if (vertices.size() > 0){
            vertices.get(0).setDistance(0);
        }

        for (int i = 0; i < vertices.size(); i++) {
            Q.insert(vertices.get(i));
        }

        this.MST = 0;

        while (!Q.isEmpty()){
            Vertex src = Q.extractMin();
            for (int e0 = 0; e0 < src.getOutEdge().size(); e0++) {
                Vertex destinationVertex = src.getOutEdge().get(e0).getDestVertex();
                if (src.getOutEdge().get(e0).getKm() < destinationVertex.getDistance()){
                    destinationVertex.setDistance(src.getOutEdge().get(e0).getKm());
                    destinationVertex.setPredecessor(src);
                    int position = Q.getPosition(destinationVertex);
                    Q.decreasekey(position);
                }
            }
            this.MST += src.getDistance();
        }
    }

    public void printPrims(){
        System.out.println("Minimum spaning tree distance");
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getPredecessor() != null) {
                System.out.println(i + " parent " + vertices.get(i).getPredecessor().getName() + " to " +
                        vertices.get(i).getName() + " weight " + vertices.get(i).getDistance());
            }
            System.out.println("Total cost: "+getMST());
        }
    }
}

// Pair Class
class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;

    public Pair(Integer distance, Integer index){
        this.distance = distance;
        this.index = index;
    }

    @Override
    public int compareTo(Pair o){
        return this.distance.compareTo(o.distance);
    }
}
