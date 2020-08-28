import java.util.*;
import java.lang.*;
import java.io.*;




public class SymmetricTree{
	static boolean isSymmetricUtils(TreeNode t1,TreeNode t2){
		if(t1==null&&t2==null)
			return true;
		if(t1!=null&&t2==null)
			return false;
		if(t1==null&&t2!=null)
			return false;
		if(t1.val!=t2.val)
			return false;
		boolean left=isSymmetricUtils(t1.left,t2.right);
		boolean right=isSymmetricUtils(t1.right,t2.left);
		if(left&&right)
			return true;
		return false;
	}
    static boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetricUtils(root.left,root.right);        
    }
	public static void main(String[] args) {
		
	}
}