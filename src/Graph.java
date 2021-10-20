import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<Vertex> vertices;

    int [][] matrixEdgeGraph;
    int [][] matrixWeightGraph;

    Graph(int vertices){

        vertices = new ArrayList<Vertex>();

        matrixEdgeGraph = new int [vertices][vertices];
        matrixWeightGraph = new int [vertices][vertices];
    }

    public void addEdge(int source, int destination, int km){
        matrixEdgeGraph[source][destination] = 1;
        matrixWeightGraph[source][destination] = km;
    }

    public void printGraph(){
        for (int src = 0; src<matrixEdgeGraph.length; src++) {
            System.out.println("Edges from vertex: "+src);
            for (int dest = 0; dest < matrixEdgeGraph.length; dest++) {
                if (matrixEdgeGraph[src][dest]==1){
                    System.out.println(" To "+dest+" weight "+matrixWeightGraph[src][dest]);
                }
            }
        }
    }

    public void MSTPrims(){
        int[] distance = new int[matrixEdgeGraph.length];
        int[] predecessor = new int[matrixEdgeGraph.length];

        ArrayList<Pair> VertexPair = new ArrayList<>();
        MinHeap<Pair> Q = new MinHeap<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(predecessor, -1);

        if (matrixEdgeGraph.length > 0){
            distance[0] = 0;
        }

        for (int i = 0; i < matrixEdgeGraph.length; i++) {
            VertexPair.add(new Pair(distance[i], i));
            Q.insert(VertexPair.get(i));
        }

        int MST = 0;

        while (!Q.isEmpty()){
            Pair u = Q.extractMin();
            for (int v = 0; v < matrixEdgeGraph.length; v++) {
                if (matrixEdgeGraph[u.index][v] == 1 && matrixWeightGraph[u.index][v]<distance[v]){
                    distance[v] = matrixWeightGraph[u.index][v];
                    predecessor[v] = u.index;
                    int position = Q.getPosition(VertexPair.get(v));
                    VertexPair.get(v).distance = matrixWeightGraph[u.index][v];
                    Q.decreasekey(position);
                }
            }

            MST += distance[u.index];
        }

        System.out.println("Minimum spaning tree distance");
        for (int i = 0; i < matrixEdgeGraph.length; i++) {
            System.out.println(i+ " parent "+ predecessor[i]+ " to " +i+ " weight " + distance[i]);
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
