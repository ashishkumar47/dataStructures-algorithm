import java.util.*;
import java.lang.*;
import java.io.*;



public class BuildTree2{
	static TreeNode buildTreeUtils(int[] inorder,int ins,int ine,int[] postorder,int poss,int pose){
		if(ins>ine||pos>pose){
			return null;
		}
		int rootData=postorder[pose];
		TreeNode root=new TreeNode(rootData);
		int rootIndex=-1;
		for(int i=ins;i<=ine;i++){
			if(inorder[i]==rootData){
				rootIndex=i;
				break;
			}
		}
		int lins=ins;
		int line=rootIndex-1;
		int lposs=poss;
		int lpose=line-lins+lposs;
		int rins=rootIndex+1;
		int rine=ine;
		int rposs=lpose+1;
		int rpose=pose-1;

		root.left=buildTreeUtils(inorder,lins,line,postorder,lposs,lpose);
		root.right=buildTreeUtils(inorder,rins,rine,postorder,rposs,rpose);
		return root;
	}
	static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtils(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
	public static void main(String[] args) {
		
	}
}