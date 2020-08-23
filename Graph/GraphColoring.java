import java.util.*;
import java.lang.*;
import java.io.*;


//Note: considering 3 colors "RGB" and vertex starts from 1;
// gives all possible combinations of colors to color a graph such that no two adjacent vertex have same color.


public class GraphColoring
{
    static boolean isColorEligible(Map<Integer, List<Integer>>edges, String str, int src)
    {
        if(str.length() == 0)
            return true;
        char ch = str.charAt(str.length() - 1);
        List<Integer>neighbors = edges.get(src);
        for(Integer neighbor : neighbors)
        {
            if(neighbor <= str.length())
            {
                if(str.charAt(neighbor - 1) == ch)
                    return false;
            }
        }
        return true;
    }
    static void gaphColoring(Map<Integer, List<Integer>>edges, int src, String str, int v)
    {
        if(src > v || !isColorEligible(edges, str, src))
        {
            return;
        }
        if(str.length() == 4)
        {
            System.out.println(str);
            return;
        }
        gaphColoring(edges, src + 1, str + "R", v);
        gaphColoring(edges, src + 1, str + "G", v);
        gaphColoring(edges, src + 1, str + "B", v);
    }
    public static void main(String[] args)
    {
        UnweightedGraph graph = new UnweightedGraph();
        int v = 4;
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);
        Map<Integer, List<Integer>>edges = graph.getEdges();
        gaphColoring(edges, 0, "", v);
    }
}