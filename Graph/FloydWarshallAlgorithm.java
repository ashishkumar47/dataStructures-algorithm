import java.util.*;
import java.lang.*;
import java.io.*;


public class FloydWarshallAlgorithm{
	static void FloydWarshallAlgo(int[][] matrix,int source,int destination){
		for(int i=source;i<=destination;i++){
			for(int r=source;r<=destination;r++){
				for(int c=source;c<=destination;c++){
					if(matrix[r][i]!=Integer.MAX_VALUE&&matrix[i][c]!=Integer.MAX_VALUE)
					matrix[r][c]=Math.min(matrix[r][c],matrix[r][i]+matrix[i][c]);
				}
			}

		}

	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int v=input.nextInt();
		int e=input.nextInt();
		int[][] matrix= new int[v+1][v+1];
		for(int i=0;i<=v;i++){
			for(int j=0;j<=v;j++){
				matrix[i][j]=Integer.MAX_VALUE;
				if(i==j)
				matrix[i][j]=0;
			}
		}
		int source=Integer.MAX_VALUE;
		int destination=Integer.MIN_VALUE;
		for(int l=0;l<e;l++){
			int src=input.nextInt();
			int des=input.nextInt();
			int weight=input.nextInt();
			matrix[src][des]=weight;
			source=Math.min(source,src);
			destination=Math.max(destination,src);
		}
		FloydWarshallAlgo(matrix,source,destination);
		System.out.println();
		for(int r=source;r<=destination;r++){
				for(int c=source;c<=destination;c++){
					System.out.print(matrix[r][c]+" ");
				}
				System.out.println();
			}		

	}
}

// 4 6
// 1 2 9
// 1 3 -4
// 2 1 6
// 2 4 2
// 3 2 5
// 4 3 1


// 4 7
// 0 1 3
// 0 3 7
// 1 0 8
// 1 2 2
// 2 3 1
// 2 0 5
// 3 0 2