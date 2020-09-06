import java.util.*;
import java.lang.*;
import java.io.*;



public class SearchBst{
	 static TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return root;
        if(root.val==val)
            return root;
        if(root.val>val)
            return searchBST(root.left,val);
        return searchBST(root.right,val);        
    }
	public static void main(String[] args) {
		
	}
}