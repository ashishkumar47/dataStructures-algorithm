import java.util.*;
import java.lang.*;
import java.io.*;




public class LevelOrder
{
    static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> parentList = new LinkedList<>();
        if(root == null)
            return parentList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer>childList = new LinkedList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode temp = q.remove();
                childList.add(temp.val);
                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
            }
            parentList.add(childList);
        }
        return parentList;

    }
    public static void main(String[] args)
    {

    }
}