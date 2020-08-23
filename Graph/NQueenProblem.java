import java.util.*;
import java.lang.*;
import java.io.*;


public class NQueenProblem{
	static boolean isQueenSafe(int[][] board,int row,int j){
		for(int k=row;k>=0;k--){
			if(board[k][j]==1)
				return false;
		}
		int m=row,n=j;
		while(m>=0&&n<board.length){
			if(board[m][n]==1)
				return false;
			m--;
			n++;
		}
		m=row;
		n=j;
		while(m>=0&&n>=0){
			if(board[m][n]==1){
				return false;
			}
			m--;
			n--;
		}
		return true;
	}
	static  void printBoard(int[][] board,List<String>possibleCombinations){
		String value="[";
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==1)
				value+=String.valueOf(j+1)+" ";
			}
		}
		value+="]";
		possibleCombinations.add(value);
	}
	static boolean solveNQueen(int[][] board,int row,List<String>possibleCombinations){
		if(row==board.length){
			printBoard(board,possibleCombinations);
			return false;
		}
		for(int j=0;j<board.length;j++){
			if(isQueenSafe(board,row,j)){
				board[row][j]=1;
				if(solveNQueen(board,row+1,possibleCombinations))
					return true;
				board[row][j]=0;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int n=input.nextInt();
		int[][] board= new int[n][n];
		List<String>possibleCombinations= new ArrayList<>();
		boolean isSolved=solveNQueen(board,0,possibleCombinations);
		for(String value:possibleCombinations){
			System.out.print(value+" ");
		}
		System.out.println();
	}
}