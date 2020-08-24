import java.util.*;
import java.lang.*;
import java.io.*;





public class ZigzagLevelOrder
{
    static List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        int level = 0;
        List<List<Integer>> parentList = new LinkedList<>();
        if(root == null)
            return parentList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> childList = new LinkedList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode temp = q.remove();
                childList.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            if(level % 2 != 0)
            {
                Collections.reverse(childList);
            }
            level++;
            parentList.add(childList);
        }
        return parentList;
    }
    public static void main(String[] args)
    {

    }
}