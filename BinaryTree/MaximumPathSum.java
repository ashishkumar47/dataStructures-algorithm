import java.util.*;
import java.lang.*;
import java.io.*;




public class MaximumPathSum{
	static int answer=Integer.MIN_VALUE;
	static int findBestPathSoFar(TreeNode root){
		if(root==null)
			return 0;
		int left=findBestPathSoFar(root.left);
		int right=findBestPathSoFar(root.right);
		answer=Math.max(answer,left+right+root.val);
		int bestPathSoFar=Math.max(left,right)+root.val;
		if(bestPathSoFar<0)
			return 0;
		return bestPathSoFar;
	}
	public static void main(String[] args) {
		
	}
}