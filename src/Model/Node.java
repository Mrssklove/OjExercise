package Model;


import java.util.ArrayList;

public class Node {

    public int value;  //值

    public int in;     //入度

    public int out;    //出度

    public ArrayList<Node> nexts; //临接点

    public ArrayList<Edge> edges; //边集

    public Node(int value)
    {
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
