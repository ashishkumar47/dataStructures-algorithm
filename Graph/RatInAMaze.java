import java.util.*;
import java.lang.*;
import java.io.*;

public class RatInAMaze{

	static void printPathUtils(int[][] matrix,ArrayList<String>paths,String path,int sr,int sc,int dr,int dc){
		if(sr>dr||sr<0||sc>dc||sc<0){
			return;
		}
		if(matrix[sr][sc]==0){
			return;
		}
		if(sr==dr&&sc==dc){
			paths.add(path);
		}
		matrix[sr][sc]=0;
		printPathUtils(matrix,paths,path+"D",sr+1,sc,dr,dc);
		printPathUtils(matrix,paths,path+"U",sr-1,sc,dr,dc);
		printPathUtils(matrix,paths,path+"R",sr,sc+1,dr,dc);
		printPathUtils(matrix,paths,path+"L",sr,sc-1,dr,dc);
		matrix[sr][sc]=1;
	}

	static ArrayList<String> printPath(int[][] matrix,int n){
		ArrayList<String>paths= new ArrayList<>();
		printPathUtils(matrix,paths,"",0,0,n-1,n-1);
		if(paths.size()==0){
			paths.add("-1");
		}
		return paths;
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int n=input.nextInt();
		int[][] matrix=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=input.nextInt();
			}
		}
		ArrayList<String> paths=printPath(matrix,n);
		for(String path:paths){
			System.out.println(path);
		}
	}
}

// 4
// 1 0 0 0 
// 1 1 0 1 
// 0 1 0 0 
// 0 1 1 1

// 4
// 1 0 0 0 
// 1 1 0 1 
// 1 1 0 0 
// 0 1 1 1

// 2
// 1 0
// 1 0 