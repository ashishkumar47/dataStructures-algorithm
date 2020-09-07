import java.util.*;
import java.lang.*;
import java.io.*;


//So the optimise Approach is for serialize either levelOrder or preorder
//for deserialize either iterative builtBst or Bst using preorder and inorder
//because recursive builtBst will give O(n^2) time complexity in worst case(skewed Trees)

public class SerializeAndDeserialize{
//Optimise Approach using PreOrder and InOrder Traversal
	// Encodes a tree to a single string.
    public void preOrderTraversal(TreeNode root,StringBuilder str){
        if(root==null)
            return;
        str.append(root.val);
        str.append(",");
        preOrderTraversal(root.left,str);
        preOrderTraversal(root.right,str);        
    }
    public int[] getPreOrder(String data){
        String[] str=data.split(",");
        int[] a=new int[str.length];
        for(int i=0;i<str.length;i++){
            int n=Integer.parseInt(str[i]);
            a[i]=n;
        }
        return a;
    }
    public int[] getInorder(int[] pre){
        int[] in=new int[pre.length];
        for(int i=0;i<pre.length;i++){
            in[i]=pre[i];
        }
        Arrays.sort(in);
        return in;
    }
    public TreeNode builtTree(int[] pre,int pres,int pree,int[] in,int ins,int ine){
        if(pres>pree||ins>ine){
            return null;
        }
        int rootData=pre[pres];
        TreeNode root= new TreeNode(rootData);
        int rootIndex=-1;
        for(int i=ins;i<=ine;i++){
            if(in[i]==rootData){
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
        
        root.left=builtTree(pre,lpres,lpree,in,lins,line);
        root.right=builtTree(pre,rpres,rpree,in,rins,rine);
        return root;
    }
    public String serialize(TreeNode root) {
        StringBuilder str= new StringBuilder();
        preOrderTraversal(root,str);
        return str.toString();        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        int[] pre=getPreOrder(data);
        int[] in=getInorder(pre);
        TreeNode root=builtTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;        
    }







     //Optimise Approach using preOrder Traversal
	public void preOrderTraversal(TreeNode root,StringBuilder str){
        if(root==null)
            return;
        str.append(root.val);
        str.append(",");
        preOrderTraversal(root.left,str);
        preOrderTraversal(root.right,str);        
    }
    public int[] getPreOrder(String data){
        String[] str=data.split(",");
        int[] a=new int[str.length];
        for(int i=0;i<str.length;i++){
            int n=Integer.parseInt(str[i]);
            a[i]=n;
        }
        return a;
    }
    
    public TreeNode builtBst(TreeNode root,int d){
        if(root==null){
            root=new TreeNode(d);
            return root;
        }
        else if(root.val>d){
            root.left=builtBst(root.left,d);
        }
        else if(root.val<d){
            root.right=builtBst(root.right,d);
        }
        return root;
    }
    public String serialize(TreeNode root) {
        StringBuilder str= new StringBuilder();
        preOrderTraversal(root,str);
        return str.toString();        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        int[] pre=getPreOrder(data);
        TreeNode root=null;
        for(int i=0;i<pre.length;i++){
            root=builtBst(root,pre[i]);
        }
        return root;        
    }
	




	// Approach using Level Order
	 static String serialize(TreeNode root) {
        if(root==null)
            return "";
        String output="";
        Queue<TreeNode>q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            output+=temp.val+",";
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return output;
    }

    // Decodes your encoded data to tree.
    static TreeNode builtBst(TreeNode root,int d){
        if(root==null){
            root=new TreeNode(d);
            return root;
        }
        else if(root.val>d){
            root.left=builtBst(root.left,d);
        }
        else if(root.val<d){
            root.right=builtBst(root.right,d);
        }
        return root;
    }
    static TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        TreeNode root=null;
        String[] str=data.split(",");
        for(int i=0;i<str.length;i++){
            int n=Integer.parseInt(str[i]);
            root=builtBst(root,n);
        }      
        return root;
    }
	public static void main(String[] args) {
		
	}
}