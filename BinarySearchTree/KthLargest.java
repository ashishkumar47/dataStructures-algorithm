import java.util.*;
import java.lang.*;
import java.io.*;



public class KthLargest{
	static void helper(Node root,int k,int[] a){
        if(root==null)
        return;
        helper(root.right,k,a);
        a[0]++;
        if(a[0]==k){
            a[1]=root.data;
        }
        helper(root.left,k,a);
    }
    static int kthLargest(Node root,int K)
    {
        //Your code here
        if(root==null)
        return 0;
        int[] a= new int[2];
        helper(root,K,a);
        return a[1];
        
    }
	public static void main(String[] args) {
		
	}
}