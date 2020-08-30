import java.util.*;
import java.lang.*;
import java.io.*;


class Pair{
	int height;
	boolean isBalanced;
	Pair(int height,boolean isBalanced){
		this.height=height;
		this.isBalanced=isBalanced;
	}
}



public class BalancedBinaryTree{

	static Pair isBalancedUtils(TreeNode root){
		if(root==null){
			return new Pair(0,true);
		}
		Pair left=isBalancedUtils(root.left);
		Pair right=isBalancedUtils(root.right);
		int height=Math.max(left.height,right.height)+1;
		if(left.isBalanced&&right.isBalanced&&Math.abs(left.height-right.height)<=1){
			return new Pair(height,true);
		}
		return new Pair(height,false);
	}
	static boolean isBalancedOptimise(TreeNode root){
		return isBalancedUtils(root).isBalanced;
	}


	static int height(TreeNode root){
		if(root==null)
			return 0;
		return Math.max(height(root.left),height(root.right))+1;
	}
	static boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		boolean left=isBalanced(root.left);
		boolean right=isBalanced(root.right);
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		if(left&&right&&(Math.abs(leftHeight-rightHeight)<=1))
			return true;
		return false;
    }
	public static void main(String[] args) {
		
	}
}