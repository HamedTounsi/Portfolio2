/* Made by
 * Hamed Tounsi - 68841
 * Rasmus Laue Petersen - 68907
 * Mansour Hamidi - 68903
 * Kush Max Kei - 68924
 * */

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{

    private String name;
    private ArrayList<Edge> outEdge;
    boolean isVisited = false;
    Vertex predecessor = null;
    Integer distance = Integer.MAX_VALUE;

    //Constructor
    public Vertex(String v){
        this.name = v;
        this.outEdge = new ArrayList();  //An ArrayList which holds outEdges to the vertex
    }

    public void setName(String v){this.name = v;}

    public String getName(){return this.name;}

    public void setPredecessor(Vertex v){this.predecessor = v;}

    public Vertex getPredecessor(){return this.predecessor;}

    public void setDistance(Integer dist){this.distance = dist;}

    public Integer getDistance(){return this.distance;}

    //Add an Edge to the outEdge ArrayList
    public void addOutEdge(Edge e){
        outEdge.add(e);
    }

    //Maybe not needed
    public void setOutEdge(ArrayList<Edge> edge){this.outEdge = edge;}

    public ArrayList<Edge> getOutEdge(){return this.outEdge;}

    //Compare the distance of this vertex and a given vertex
    public int compareTo(Vertex v){
        if (this.distance < v.distance){
            return -1;
        } else if (this.distance > v.distance){
            return 1;
        } else {
            return 0;
        }
    }

}
