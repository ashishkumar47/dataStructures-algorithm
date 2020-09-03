import java.util.*;
import java.lang.*;
import java.io.*;


// Build tree using preOrder and inOrder.

public class BuildTree1{
	static TreeNode buildTreeUtils(int[] preorder,int pres,int pree,int[] inorder,int ins,int ine){
		if(pres>pree){
			return null;
		}
		int rootData=preorder[pres];
		TreeNode root= new TreeNode(rootData);
		int rootIndex=-1;
		for(int i=ins;i<=ine;i++){
			if(inorder[i]==rootData){
				rootIndex=i;
				break;
			}
		}
		int lpres=pres+1;
		int lins=ins;
		int line=rootIndex-1;
		int lpree=line-lins+lpres;
		int rpres=lpree+1;
		int rpree=pree;
		int rins=rootIndex+1;
		int rine=ine;
		root.left=buildTreeUtils(preorder,lpres,lpree,inorder,lins,line);
		root.right=buildTreeUtils(preorder,rpres,rpree,inorder,rins,rine);
		return root;
	}
	static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeUtils(preorder,0,preorder.length-1,inorder,0,inorder.length-1);        
    }
	public static void main(String[] args) {
		
	}
}