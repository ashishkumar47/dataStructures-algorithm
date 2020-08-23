import java.util.*;
import java.lang.*;
import java.io.*;




public class WeightedGraph{
	Map<Integer,List<Pair>>edges;

	WeightedGraph(){
		edges= new HashMap<>();
	}

	public Map<Integer,List<Pair>> getEdges(){
		return this.edges;
	}
	private void addEdgeUtils(int src,int des,int weight){
		if(edges.get(src)==null){
			List<Pair>edge= new LinkedList<>();
			edge.add(new Pair(des,weight));
			edges.put(src,edge);
		}
		else{
			edges.get(src).add(new Pair(des,weight));
		}
	}

	public void addEdge(int src,int des,int weight,boolean isBidirectional){
		addEdgeUtils(src,des,weight);
		if(isBidirectional){
			addEdgeUtils(des,src,weight);
		}
	}
}