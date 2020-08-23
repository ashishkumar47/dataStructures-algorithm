import java.util.*;
import java.lang.*;
import java.io.*;




public class IsBipartite
{
    //optimise approach for checkingBipartite
    public boolean checkBipartite(int[][] graph, int src, int currentColor, int[] colors)
    {
        colors[src] = currentColor;
        for(int neighbors : graph[src])
        {
            if(colors[neighbors] == -1 && !checkBipartite(graph, neighbors, 1 - currentColor, colors))
            {
                return false;
            }
            if(colors[neighbors] == currentColor)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph)
    {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors, -1);
        for(int i = 0; i < v; i++)
        {
            if(colors[i] == -1)
            {
                if(!checkBipartite(graph, i, 0, colors))
                    return false;
            }
        }
        return true;
    }


    // This approach will work but give TLE for long/complex graph.
    public boolean isEligible(int[][] graph, int src, String str)
    {
        if(str.length() == 0)
            return true;
        char ch = str.charAt(str.length() - 1);
        int[] neighbors = graph[src];
        for(int neighbor : neighbors)
        {
            if(neighbor < str.length())
            {
                if(ch == str.charAt(neighbor))
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartiteUtils(int[][] graph, int src, String str, int v)
    {
        if(src >= v || !isEligible(graph, src, str))
        {
            return false;
        }
        if(str.length() == v)
            return true;
        boolean groupA = isBipartiteUtils(graph, src + 1, str + "A", v);
        boolean groupB = isBipartiteUtils(graph, src + 1, str + "B", v);
        if(!groupA && !groupB)
            return false;
        return true;
    }
    public boolean isBipartite(int[][] graph)
    {
        int v = graph.length;
        String str = "";
        return  isBipartiteUtils(graph, -1, str, v);
    }

    public static void main(String[] args)
    {

    }
}