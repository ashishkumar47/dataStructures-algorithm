import java.util.*;
import java.lang.*;
import java.io.*;





public class LowestCommonAncestor{

// static void lcaBruteForceUtils(Node root,int n,List<Integer>path){
// 	if(root==null)
// 		return;
// 	path.add(root.data);
// 	if(root.data==n)
// 		return;
// 	lcaBruteForceUtils(root.left,n,path);
// 	lcaBruteForceUtils(root.right,n,path);
// 	path.remove(path.size()-1);
// }

// static Node lcaBruteForce(Node root,int n1,int n2){
// 	if(root==null)
// 		return null;
// 	List<Integer> path1= new ArrayList<>();
// 	List<Integer> path2= new ArrayList<>();
// 	lcaBruteForceUtils(root,n1,path1);
// 	lcaBruteForceUtils(root,n2,path2);
// }


	static Node lca(Node root, int n1,int n2)
	{
		if(root==null)
			return null;
		if(root.data==n1||root.data==n2)
			return root;
		Node left=lca(root.left,n1,n2);
		Node right=lca(root.right,n1,n2);

		if(left==null&&right!=null)
			return right;
		if(left!=null&&right==null)
			return left;
		if(left==null&&right==null)
			return null;
		return root;
	}
	public static void main(String[] args) {
		
	}
}