import java.util.*;
import java.lang.*;
import java.io.*;





public class RightView
{
    int maxLevel = Integer.MIN_VALUE;
    //Iterative Approach
    static List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            list.add(q.peek().val);
            for(int i = 0; i < size; i++)
            {
                TreeNode temp = q.remove();
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
                if(temp.left != null)
                {
                    q.add(temp.left);
                }
            }
        }
        return list;
    }


    //Recursive Approach
    static void helper(TreeNode root, List<Integer> list, int level)
    {
        if(root == null)
            return;
        if(level > maxLevel)
        {
            list.add(root.val);
            maxLevel = level;
        }
        helper(root.right, list, level + 1);
        helper(root.left, list, level + 1);
    }
    static List<Integer> rightSideView(TreeNode root)
    {
        List<Integer>list = new LinkedList<>();
        if(root == null)
            return list;
        helper(root, list, 0);
        return list;
    }



    public static void main(String[] args)
    {

    }
}