import java.util.*;
import java.lang.*;
import java.io.*;



public class BellmanfordAlgorithm{
	static void bellmanFordAlgo(Edge[] edges,int v,int src){
		if(src==1){
			v++;
		}
		int[] distance=new int[v];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[src]=0;
		for(int i=1;i<v;i++){
			for(int j=0;j<edges.length;j++){
				int x=edges[j].src;
				int y=edges[j].des;
				int weight=edges[j].weight;
				if(distance[x]!=Integer.MAX_VALUE&&distance[x]+weight<distance[y]){
					distance[y]=distance[x]+weight;
				}
			}
		}
		System.out.println();
		boolean flag=false;
		for(int j=0;j<edges.length;j++){
				int x=edges[j].src;
				int y=edges[j].des;
				int weight=edges[j].weight;
				if(distance[x]!=Integer.MAX_VALUE&&distance[x]+weight<distance[y]){
					flag=true;
					break;
				}
			}
			if(flag){
				System.out.println("Graph contains negative weight cycle.");
			}
			else{
				for(int k=src;k<distance.length;k++){
			System.out.println(k+"->"+distance[k]);
		}
	}		

	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int v=input.nextInt();
		int e=input.nextInt();
		Edge[] edges= new Edge[e];
		int source=1;
		for(int i=0;i<e;i++){
			int src=input.nextInt();
			int des=input.nextInt();
			int weight=input.nextInt();
			edges[i]=new Edge(src,des,weight);
			if(src==0||des==0)
				source=0;
		}
		bellmanFordAlgo(edges,v,source);
	}
   
}


// 6 8
// 4 5 2
// 3 4 2
// 2 5 4
// 0 2 5
// 1 2 -3
// 5 4 1
// 0 3 6
// 0 1 4


// 4 4
// 3 2 -10
// 4 3 3
// 1 4 5
// 1 2 4

// 4 4
// 0 1 1
// 1 2 3
// 2 3 2
// 3 1 -6 
