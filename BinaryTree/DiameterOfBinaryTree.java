import java.util.*;
import java.lang.*;
import java.io.*;






public class DiameterOfBinaryTree{

	//Recursive Approach O(n)
	static Pair findHeightAndDiameter(TreeNode root){
		if(root==null){
			return new Pair(0,0);
		}
		Pair left=findHeightAndDiameter(root.left);
		Pair right=findHeightAndDiameter(root.right);
		int height=Math.max(left.first,right.first)+1;
		int option1=left.first+right.first;
		int option2=left.second;
		int option3=right.second;
		int diameter=Math.max(option1,Math.max(option2,option3));
		return new Pair(height,diameter);
	}

static int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        return findHeightAndDiameter(root).second;        
}






	//Recursive Approach O(n*h)
	static int findHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }
    static int diameterOfBinaryTreeRecursive(TreeNode root) {
        if(root==null)
            return 0;
        
        int diameter=findHeight(root.left)+findHeight(root.right);
        int leftDiameter=diameterOfBinaryTreeRecursive(root.left);
        int rightDiameter=diameterOfBinaryTreeRecursive(root.right);
        return Math.max(diameter,Math.max(leftDiameter,rightDiameter));        
    }


	//Iterative Approach O(n*h)
	static int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
    static int diameterOfBinaryTreeIterative(TreeNode root) {
        if(root==null)
            return 0;
       int height=Integer.MIN_VALUE;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            int left=maxDepth(temp.left);
            int right=maxDepth(temp.right);
            height=Math.max(height,left+right);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return height;
    }
	public static void main(String[] args) {
		
	}
}