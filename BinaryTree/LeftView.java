import java.util.*;
import java.lang.*;
import java.io.*;





public class LeftView
{
    int maxLevel = 0;

    //Iterative approach
    static void leftView(Node root)
    {
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            System.out.print(q.peek() + " ");
            for(int i = 0; i < size; i++)
            {
                Node temp = q.remove();
                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
            }
        }
    }

    static void helper(Node root, int level)
    {
        if(root == null)
            return;
        if(level > maxLevel)
        {
            maxLevel = level;
            System.out.print(root.data + " ");
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    static void leftViewRecursion(Node root)
    {
        int level = 1;
        helper(root, level);
    }




    public static void main(String[] args)
    {

    }
}