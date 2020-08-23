import java.util.*;
import java.lang.*;
import java.io.*;



public class PrimsAlgorithm{
	static int findMinWeightVertex(int[] weight,Set<Integer>visited){
		int vertex=-1;
		for(int i=0;i<weight.length;i++){
			if(!visited.contains(i)&&(vertex==-1||weight[i]<weight[vertex])){
				vertex=i;
			}
		}
		return vertex;
	}
	static void primsAlgo(Map<Integer,List<Pair>>edges,int v){
		int[] parent= new int[v];
		int[] weight= new int[v];
		Arrays.fill(parent,-1);
		Arrays.fill(weight,Integer.MAX_VALUE);
		weight[0]=0;
		Set<Integer>visited= new HashSet<>();
		for(int i=0;i<v;i++){
			int vertex=findMinWeightVertex(weight,visited);
			visited.add(vertex);
			for(Pair neighbour:edges.get(vertex)){
				if(!visited.contains(neighbour.first)&&neighbour.second<weight[neighbour.first]){
					weight[neighbour.first]=neighbour.second;
					parent[neighbour.first]=vertex;
				}
			}
		}

		for(int i=1;i<parent.length;i++){
			System.out.println(parent[i]+" "+i+" "+weight[i]);
		}
	}

	public static void main(String[] args) {
		WeightedGraph graph= new WeightedGraph();
		int v=5;
		graph.addEdge(0,1,4,true);
		graph.addEdge(0,2,8,true);
		graph.addEdge(1,3,6,true);
		graph.addEdge(1,2,2,true);
		graph.addEdge(2,3,3,true);
		graph.addEdge(2,4,9,true);
		graph.addEdge(3,4,5,true);
		Map<Integer,List<Pair>>edges=graph.getEdges();
		primsAlgo(edges,v);
	}
}