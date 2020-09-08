import java.util.*;
import java.lang.*;
import java.io.*;



public class KthSmallest{
	static void findSmallest(TreeNode root,int k,int[] a){
        if(root==null)
            return;
        findSmallest(root.left,k,a);
        a[0]++;
        if(k==a[0]){
            a[1]=root.val;
        }
        findSmallest(root.right,k,a);
    }
    static int kthSmallest(TreeNode root, int k) {
        int[] a= new int[2];
        findSmallest(root,k,a);
        return a[1];
    }
	public static void main(String[] args) {
		
	}
}