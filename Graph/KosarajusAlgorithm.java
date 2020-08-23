
import java.util.*;
import java.lang.*;
import java.io.*;



public class KosarajusAlgorithm
{
    static void findConnectedComponents(Map<Integer, List<Integer>> transposeGraph, int stackElement, List<Integer> component, Set<Integer>visited)
    {
        visited.add(stackElement);
        component.add(stackElement);
        List<Integer>neighbors = transposeGraph.get(stackElement);
        if(neighbors != null)
        {
            for(Integer neighbor : neighbors)
            {
                if(!visited.contains(neighbor))
                {
                    findConnectedComponents(transposeGraph, neighbor, component, visited);
                }
            }
        }

    }
    static Map<Integer, List<Integer>> getTranspose(Map<Integer, List<Integer>>edges)
    {
        UnweightedGraph graph = new UnweightedGraph();
        for(Integer key : edges.keySet())
        {
            for(Integer neighbor : edges.get(key))
            {
                graph.addEdge(neighbor, key, false);
            }
        }
        return graph.getEdges();
    }
    static void kosarajusAlgorithmUtils(Map<Integer, List<Integer>>edges, int src, Set<Integer>visited, Stack<Integer>topoSort)
    {
        visited.add(src);
        List<Integer>list = edges.get(src);
        if(list != null)
        {
            for(Integer neighbors : list)
            {
                if(!visited.contains(neighbors))
                {
                    kosarajusAlgorithmUtils(edges, neighbors, visited, topoSort);
                }
            }

        }
        topoSort.push(src);
    }
    static void kosarajusAlgorithm(Map<Integer, List<Integer>>edges, int v)
    {
        Stack<Integer>topoSort = new Stack<>();
        Set<Integer>visited = new HashSet<>();

        for(int i = 0; i < v; i++)
        {
            if(!visited.contains(i))
            {
                kosarajusAlgorithmUtils(edges, i, visited, topoSort);
            }

        }
        Map<Integer, List<Integer>> transposeGraph = getTranspose(edges);
        visited = new HashSet<>();
        List<List<Integer>> components = new LinkedList<>();
        while(!topoSort.isEmpty())
        {
            int stackElement = topoSort.pop();
            List<Integer>component = new LinkedList<>();
            if(!visited.contains(stackElement))
            {
                findConnectedComponents(transposeGraph, stackElement, component, visited);
                components.add(component);
            }

        }
        for(int i = 0; i < components.size(); i++)
        {
            for(Integer element : components.get(i))
            {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        UnweightedGraph graph = new UnweightedGraph();
        int v = 13, e = 22;
        graph.addEdge(0, 5, false);
        graph.addEdge(0, 1, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(2, 0, false);
        graph.addEdge(3, 2, false);
        graph.addEdge(3, 5, false);
        graph.addEdge(4, 3, false);
        graph.addEdge(4, 2, false);
        graph.addEdge(5, 4, false);
        graph.addEdge(6, 0, false);
        graph.addEdge(6, 4, false);
        graph.addEdge(6, 9, false);
        graph.addEdge(7, 6, false);
        graph.addEdge(7, 8, false);
        graph.addEdge(8, 7, false);
        graph.addEdge(8, 9, false);
        graph.addEdge(9, 10, false);
        graph.addEdge(9, 11, false);
        graph.addEdge(10, 12, false);
        graph.addEdge(11, 12, false);
        graph.addEdge(11, 4, false);
        graph.addEdge(12, 9, false);
        Map<Integer, List<Integer>>edges = graph.getEdges();
        kosarajusAlgorithm(edges, v);
    }
}