import java.util.*;
import java.lang.*;
import java.io.*;



public class ConstructBst{
	static Node constructBstUtils(Node root,int data){
		if(root==null){
			root= new Node(data);
			return root;
		}
		else if(root.data=>data){
			root.left=constructBstUtils(root.left,data);
		}
		else{
			root.right=constructBstUtils(root.right,data);
		}
		return root;
	}

	static Node constructBst(int[] bst){
		Node root= null;
		for(int i=0;i<bst.length;i++){
			root=constructBstUtils(root,bst[i]);
		}
		return root;
	}
	public static void main(String[] args) {
		
	}
}