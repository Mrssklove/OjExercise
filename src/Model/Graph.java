package Model;

import java.util.*;

public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph()
    {
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }

    public Graph createGraph(int[][] edges)
    {
        int row=edges.length;
        int col=edges[0].length;
        Graph graph=new Graph();
        for(int i=0;i<row;i++)
        {
            int from=edges[i][0];
            int to=edges[i][1];
            if(!graph.nodes.containsKey(from))
                graph.nodes.put(from,new Node(from));
            if(!graph.nodes.containsKey(to))
                graph.nodes.put(to,new Node(to));

            Node fromNode=graph.nodes.get(from);
            Node toNode=graph.nodes.get(to);
            Edge newEdge=new Edge(0,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out++;
            toNode.in++;
            graph.edges.add(newEdge);
        }
      return graph;
    }

    /**
     * 图的宽度优先遍历
     * @param node
     */
    public void bfs(Node node)
    {
        if(node==null)
            return;
        Queue<Node> queue=new LinkedList<>();
        HashSet<Node> set=new HashSet<>();
        ((LinkedList<Node>) queue).add(node);
        set.add(node);
        while (!queue.isEmpty())
        {
            Node cur=queue.poll();
            System.out.println(cur.value);
            for(Node next:cur.nexts)
            {
                if(!set.contains(next))
                    ((LinkedList<Node>) queue).add(next);
            }
        }
    }

    /**
     * 图的深度优先遍历
     */
    public static void dfs(Node node)
    {
        if(node==null)
            return;
        Stack<Node> stack=new Stack<>();
        HashSet<Node> set=new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty())
        {
            Node cur=stack.pop();
            for(Node next:cur.nexts)
            {
                if(!set.contains(next))
                {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    /**
     * 拓扑排序
     */
    public static List<Node> sortedTopology(Graph graph)
    {
        HashMap<Node,Integer> inMap=new HashMap<>();
        Queue<Node> zeroInQueue=new LinkedList<>();
        for(Node node:graph.nodes.values())
        {
            inMap.put(node,node.in);
            if(node.in==0)
            {
                ((LinkedList<Node>) zeroInQueue).add(node);
            }
        }

        List<Node> res=new ArrayList<>();
        while (!zeroInQueue.isEmpty())
        {
            Node cur=zeroInQueue.poll();
            res.add(cur);
            for(Node next:cur.nexts)
            {
                inMap.put(next,inMap.get(next)-1);
                if(inMap.get(next)==0)
                    ((LinkedList<Node>) zeroInQueue).add(next);
            }
        }
        return res;
    }
}
