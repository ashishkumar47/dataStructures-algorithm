import java.util.*;
import java.lang.*;
import java.io.*;


class BSTIterator {

    public List<Integer>inOrder;
    public int index;
    public BSTIterator(TreeNode root) {
        inOrder= new ArrayList<>();
        inOrderTraversal(root);
        index=0;        
    }
    
    /** @return the next smallest number */
    public int next() {
        int next=inOrder.get(index);
        index++;
        return next;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<inOrder.size();        
    }
    
    public void inOrderTraversal(TreeNode root){
        if(root==null)
            return;
        inOrderTraversal(root.left);
        inOrder.add(root.val);
        inOrderTraversal(root.right);
    }
}


public class BSTIteratorOptimized{
	public static void main(String[] args) {
		
	}
}