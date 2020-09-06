import java.util.*;
import java.lang.*;
import java.io.*;



public class CheckBst{


	//Optimise Approach
	static boolean checkBst(TreeNode root,long min,long max){
        if(root==null)
            return true;
        if((root.val<=min||root.val>=max))
            return false;
        boolean left=checkBst(root.left,min,root.val);
        boolean right=checkBst(root.right,root.val,max);
        if(left&&right)
            return true;
        return false;
    }
    static boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return checkBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }


	//BruteForce Approach
	static boolean checkLeft(TreeNode root,int data){
        if(root==null)
            return true;
        if(root.val>=data)
            return false;
        boolean left=checkLeft(root.left,data);
        boolean right=checkLeft(root.right,data);
        if(left&&right)
            return true;
        return false;
    }
    static boolean checkRight(TreeNode root,int data){
        if(root==null)
            return true;
        if(root.val<=data)
            return false;
        boolean left=checkRight(root.left,data);
        boolean right=checkRight(root.right,data);
        if(left&&right)
            return true;
        return false;
    }
    static boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if(checkLeft(root.left,root.val)&&checkRight(root.right,root.val)){
            boolean left=isValidBST(root.left);
            boolean right=isValidBST(root.right);
            if(left&&right)
                return true;
            return false;
        }
        return false;        
    }
	public static void main(String[] args) {
		
	}
}