public class Edge {
    private Vertex srcVertex;
    private Vertex destVertex;
    private Integer km;

    public Edge (Vertex src, Vertex dest, Integer km){
        this.srcVertex = src;
        this.destVertex = dest;
        this.km = km;
    }

    public Vertex getSrcVertex(){
        return srcVertex;
    }

    public void setSrcVertex(Vertex srcVertex){
        this.srcVertex = srcVertex;
    }

    public Vertex getDestVertex(){
        return destVertex;
    }

    public void setDestVertex(Vertex destVertex){
        this.destVertex = destVertex;
    }

    public Integer getKm(){
        return km;
    }

    public void setKm(Integer km){
        this.km = km;
    }
}
