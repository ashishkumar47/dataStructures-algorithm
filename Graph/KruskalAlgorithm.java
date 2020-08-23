import java.util.*;
import java.lang.*;
import java.io.*;


public class KruskalAlgorithm{
	static int findParent(int v,int[] parent){
		if(parent[v]==-1)
			return v;
		return findParent(parent[v],parent);
	}
	static void KruskalAlgorithmUtils(Edge[] graph,Edge[] minimumSpanningTree,int n){
		System.out.println();
		Arrays.sort(graph,(a,b)->a.weight-(b.weight));
		int count=0,i=0;
		int[] parent= new int[n];
		Arrays.fill(parent,-1);
		while(count!=n-1){
			Edge currentEdge=graph[i];
			int srcParent=findParent(currentEdge.src,parent);
			int desParent=findParent(currentEdge.des,parent);
			if(srcParent!=desParent){
				minimumSpanningTree[count]=currentEdge;
				count++;
				parent[desParent]=srcParent;
			}
			i++;
		}
		for(Edge edge:minimumSpanningTree){
			System.out.println(edge.src+" "+edge.des+" "+edge.weight);
		}

	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int n=input.nextInt();
		int e=input.nextInt();
		Edge[] edges= new Edge[e];
		Edge[] minimumSpanningTree= new Edge[n-1];
		for(int i=0;i<e;i++){
			int src=input.nextInt();
			int des=input.nextInt();
			int weight=input.nextInt();
			Edge edge= new Edge(src,des,weight);
			edges[i]=edge;
		}
		KruskalAlgorithmUtils(edges,minimumSpanningTree,n);
	}
}

// 6
// 11
// 0 1 1
// 0 2 5
// 2 3 10
// 0 3 4
// 1 3 3
// 1 2 6
// 3 4 7
// 2 4 8
// 4 5 2
// 2 5 9
// 3 5 6


// 4
// 5
// 0 1 5
// 0 3 5
// 1 3 2
// 1 2 4
// 2 3 1