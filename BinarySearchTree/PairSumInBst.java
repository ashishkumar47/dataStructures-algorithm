import java.util.*;
import java.lang.*;
import java.io.*;





public class PairSumInBst{


	//Slightly better Approach
	public void helper(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        List<Integer>list= new ArrayList<>();
        helper(root,list);
        int i=0,j=list.size()-1;
        while(i<j){
        int sum=list.get(i)+list.get(j);
            if(sum>k){
                j--;
            }
            else if(sum<k){
                i++;
            }
            else{
                return true;
            }
            
        }
        return false;
    }
    




	//BruteForce Approach
	static boolean find(TreeNode root,int key,int rootValue){
        if(root==null)
            return false;
        if(root.val==key&&root.val!=rootValue)
            return true;
        boolean left=find(root.left,key,rootValue);
        boolean right=find(root.right,key,rootValue);
        if(left==true||right==true)
            return true;
        return false;
    }
    static void helper(TreeNode root1,TreeNode root2,int k,boolean[] a){
        if(root1==null)
            return;
        helper(root1.left,root2,k,a);
        if(find(root2,k-root1.val,root1.val)){
            a[0]=true;
        }
        helper(root1.right,root2,k,a);
    }
    static boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        boolean[] a= new boolean[1];
        helper(root,root,k,a);
        return a[0];
    }
	public static void main(String[] args) {
		
	}
}