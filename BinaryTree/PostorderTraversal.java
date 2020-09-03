import java.util.*;
import java.lang.*;
import java.io.*;




public class PostorderTraversal
{

    //Iterative Approach

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>postOrder= new LinkedList<>();
        if(root==null)
            return postOrder;
        Stack<TreeNode> st= new Stack<>();
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        TreeNode save=null;
        while(!st.isEmpty()){
            TreeNode topElement=st.peek();
            if(topElement.right!=null&&save!=topElement.right){
                TreeNode temp=topElement.right;
                while(temp!=null){
                    st.push(temp);
                    temp=temp.left;
                }                
            }
            else{
                save=st.peek();
                postOrder.add(st.pop().val);
            }
        }
        return postOrder;        
    }


    //Recursive Approach
    static void helper(Node root, ArrayList<Integer> list)
    {
        if(root == null)
            return;
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.data);
    }
    static ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer>list = new ArrayList<>();
        if(root == null)
            return list;
        helper(root, list);
        return list;
    }
    public static void main(String[] args)
    {

    }
}