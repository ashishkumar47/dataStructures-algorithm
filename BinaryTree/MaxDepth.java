import java.util.*;
import java.lang.*;
import java.io.*;





public class MaxDepth
{

    //Recursive Approach
    static int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right) + 1;
    }
    static int maxDepthRecursive(TreeNode root)
    {
        return helper(root);
    }

    static int maxDepth(TreeNode root)
    {
        int level = 0;
        if(root == null)
            return level;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode temp = q.remove();
                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
            }
            level++;
        }
        return level;
    }



    public static void main(String[] args)
    {

    }
}