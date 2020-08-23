import java.util.*;
import java.lang.*;
import java.io.*;






public class PreorderTraversal
{
    //Iterative Approach
    static List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer>preOrder = new LinkedList<>();
        if(root == null)
            return preOrder;
        Stack<TreeNode>st = new Stack<>();
        while(root != null)
        {
            preOrder.add(root.val);
            st.push(root);
            root = root.left;
        }
        while(!st.isEmpty())
        {
            TreeNode temp = st.pop();
            if(temp.right != null)
            {
                TreeNode tempRight = temp.right;
                while(tempRight != null)
                {
                    preOrder.add(tempRight.val);
                    st.push(tempRight);
                    tempRight = tempRight.left;
                }
            }
        }
        return preOrder;
    }


    //Recursive Approach
    static void preOrder(TreeNode root, List<Integer>list)
    {
        if(root == null)
            return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer>list = new LinkedList<>();
        if(root == null)
            return list;
        preOrder(root, list);
        return list;
    }
    public static void main(String[] args)
    {

    }
}