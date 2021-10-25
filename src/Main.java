public class Main {

    public static void main(String[] args) {
        Graph elNet = new Graph();

        Vertex Eskildstrup = new Vertex("Eskildstrup");
        Vertex Haslev = new Vertex("Haslev");
        Vertex Holbæk = new Vertex( "Holbæk");
        Vertex Jægerspris = new Vertex("Jægerspris");
        Vertex Kalundborg = new Vertex("Kalundborg");
        Vertex Korsør = new Vertex( "Korsør");
        Vertex Køge = new Vertex("Køge");
        Vertex Maribo = new Vertex("Maribo");
        Vertex Næstved = new Vertex("Næstved");
        Vertex Ringsted = new Vertex("Ringsted");
        Vertex Slagelse = new Vertex("Slagelse");
        Vertex NykøbingF = new Vertex("Nykøbing Falster");
        Vertex Vordingborg = new Vertex("Vordingborg");
        Vertex Sorø = new Vertex("Sorø");
        Vertex Roskilde = new Vertex("Roskilde");
        Vertex Nakskov = new Vertex("Nakskov");

        elNet.addVertex(Eskildstrup);
        elNet.addVertex(Haslev);
        elNet.addVertex(Holbæk);
        elNet.addVertex(Jægerspris);
        elNet.addVertex(Kalundborg);
        elNet.addVertex(Korsør);
        elNet.addVertex(Køge);
        elNet.addVertex(Maribo);
        elNet.addVertex(Næstved);
        elNet.addVertex(Ringsted);
        elNet.addVertex(Slagelse);
        elNet.addVertex(NykøbingF);
        elNet.addVertex(Vordingborg);
        elNet.addVertex(Sorø);
        elNet.addVertex(Roskilde);
        elNet.addVertex(Nakskov);

        elNet.addEdge(Eskildstrup,Maribo, 28);
        elNet.addEdge(Eskildstrup,NykøbingF, 13);
        elNet.addEdge(Eskildstrup, Vordingborg, 25);
        elNet.addEdge(Haslev,Korsør, 60);
        elNet.addEdge(Haslev,Køge,24);
        elNet.addEdge(Haslev, Næstved, 25);
        elNet.addEdge(Haslev,Ringsted, 19);
        elNet.addEdge(Haslev,Roskilde, 47);
        elNet.addEdge(Haslev,Slagelse, 48);
        elNet.addEdge(Haslev, Sorø, 34);
        elNet.addEdge(Haslev, Vordingborg, 40);
        elNet.addEdge(Holbæk, Jægerspris, 34);
        elNet.addEdge(Holbæk, Kalundborg, 44);
        elNet.addEdge(Holbæk,Korsør, 66);
        elNet.addEdge(Holbæk, Ringsted, 36);
        elNet.addEdge(Holbæk, Roskilde, 32);
        elNet.addEdge(Holbæk, Slagelse, 46);
        elNet.addEdge(Holbæk, Sorø, 34);
        elNet.addEdge(Jægerspris, Korsør, 94);
        elNet.addEdge(Jægerspris, Køge, 58);
        elNet.addEdge(Jægerspris, Ringsted, 56);
        elNet.addEdge(Jægerspris, Roskilde, 33);
        elNet.addEdge(Jægerspris, Slagelse, 74);
        elNet.addEdge(Jægerspris, Sorø, 63);
        elNet.addEdge(Kalundborg, Ringsted, 62);
        elNet.addEdge(Kalundborg, Roskilde, 70);
        elNet.addEdge(Kalundborg, Slagelse, 39);
        elNet.addEdge(Kalundborg,Sorø, 51);
        elNet.addEdge(Korsør, Næstved, 45);
        elNet.addEdge(Korsør, Slagelse, 20);
        elNet.addEdge(Køge, Næstved, 45);
        elNet.addEdge(Køge, Ringsted, 28);
        elNet.addEdge(Køge, Roskilde, 25);
        elNet.addEdge(Køge, Vordingborg, 60);
        elNet.addEdge(Maribo, Nakskov, 27);
        elNet.addEdge(Maribo, NykøbingF, 26);
        elNet.addEdge(Næstved, Roskilde, 57);
        elNet.addEdge(Næstved, Ringsted, 26);
        elNet.addEdge(Næstved, Slagelse, 37);
        elNet.addEdge(Næstved, Sorø, 32);
        elNet.addEdge(Næstved, Vordingborg, 28);
        elNet.addEdge(Ringsted, Roskilde, 31);
        elNet.addEdge(Ringsted, Sorø, 15);
        elNet.addEdge(Ringsted, Vordingborg, 58);
        elNet.addEdge(Slagelse, Sorø, 14);

        elNet.printGraph();
        elNet.MSTPrims();
        elNet.printPrims();
    }
}
