/* Made by
 * Hamed Tounsi - 68841
 * Rasmus Laue Petersen - 68907
 * Mansour Hamidi - 68903
 * Kush Max Kei - 68924
 * */

public class Edge {
    private Vertex srcVertex;
    private Vertex destVertex;
    private Integer km;

    public Edge (Vertex src, Vertex dest, Integer km){
        this.srcVertex = src;
        this.destVertex = dest;
        this.km = km;
        src.addOutEdge(this);
    }

    public void setSrcVertex(Vertex srcVertex){this.srcVertex = srcVertex;}

    public Vertex getSrcVertex(){return srcVertex;}

    public void setDestVertex(Vertex destVertex){this.destVertex = destVertex;}

    public Vertex getDestVertex(){return destVertex;}

    public void setKm(Integer km){this.km = km;}

    public Integer getKm(){return km;}
}
