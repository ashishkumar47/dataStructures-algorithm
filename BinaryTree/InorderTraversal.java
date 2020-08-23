
import java.util.*;
import java.lang.*;
import java.io.*;



public class InorderTraversal
{
    //Iterative approach
    static List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer>inOrder = new LinkedList<>();
        if(root == null)
            return inOrder;
        Stack<TreeNode>st = new Stack<>();
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
        while(!st.isEmpty())
        {
            TreeNode temp = st.pop();
            inOrder.add(temp.val);
            if(temp.right != null)
            {
                TreeNode tempRight = temp.right;
                while(tempRight != null)
                {
                    st.push(tempRight);
                    tempRight = tempRight.left;
                }
            }
        }
        return inOrder;
    }

    //Recursive approach
    void inOrder(TreeNode root, List<Integer>list)
    {
        if(root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public List<Integer> inorderTraversalRecursion(TreeNode root)
    {
        List<Integer>list = new LinkedList<>();
        inOrder(root, list);
        return list;
    }

    public static void main(String[] args)
    {

    }
}