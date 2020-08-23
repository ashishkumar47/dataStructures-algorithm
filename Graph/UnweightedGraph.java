import java.util.*;
import java.lang.*;
import java.io.*;





public class UnweightedGraph
{
    Map<Integer, List<Integer>>edges;

    UnweightedGraph()
    {
        edges = new HashMap<>();
    }

    public Map<Integer, List<Integer>> getEdges()
    {
        return this.edges;
    }

    public void addEdgeUtils(int src, int des)
    {
        if(edges.get(src) == null)
        {
            List<Integer>edge = new LinkedList<>();
            edge.add(des);
            edges.put(src, edge);
        }
        else
        {
            edges.get(src).add(des);
        }
    }
    public void printEdges(Map<Integer, List<Integer>>edges)
    {
        for(Integer key : edges.keySet())
        {
            System.out.print(key + "->");
            for(Integer value : edges.get(key))
            {
                System.out.print(value + ",");
            }
            System.out.println();
        }
    }

    public void addEdge(int src, int des, boolean isBidirectional)
    {
        addEdgeUtils(src, des);
        if(isBidirectional)
        {
            addEdgeUtils(des, src);
        }

    }
}