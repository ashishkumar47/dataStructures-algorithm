import java.util.*;
import java.lang.*;
import java.io.*;



class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}


public class BottomView
{

    //Recursive Approach
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public void helper(Node root, Map<Integer, Node> map, int hd)
    {
        if(root == null)
            return;
        if(map.get(hd) != null)
        {
            Node temp = map.get(hd);
            if(root.hd >= temp.hd)
            {
                map.put(hd, root);
            }
        }
        else
        {
            map.put(hd, root);
        }
        if(hd < min)
        {
            min = hd;
        }
        if(hd > max)
        {
            max = hd;
        }
        int rootLevel = root.hd;
        if(root.left != null)
        {
            root.left.hd = rootLevel + 1;
        }
        if(root.right != null)
        {
            root.right.hd = rootLevel + 1;
        }
        helper(root.left, map, hd - 1);
        helper(root.right, map, hd + 1);
    }
    public ArrayList <Integer> bottomViewRecursive(Node root)
    {
        // Code here
        int hd = 0;
        Map<Integer, Node> map = new HashMap<>();
        ArrayList<Integer>list = new ArrayList<>();
        root.hd = 0;
        helper(root, map, hd);
        for(int i = min; i <= max; i++)
        {
            list.add(map.get(i).data);
        }
        return list;
    }


    //Iterative Approach
    public ArrayList <Integer> bottomView(Node root)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int hd = 0;
        Queue<Node>q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>list = new ArrayList<>();
        root.hd = hd;
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.remove();
            hd = temp.hd;

            if(temp.hd < min)
            {
                min = temp.hd;
            }
            if(temp.hd > max)
            {
                max = temp.hd;
            }
            map.put(hd, temp.data);
            if(temp.left != null)
            {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }
        for(int i = min; i <= max; i++)
        {
            list.add(map.get(i));
        }
        return list;
    }
    public static void main(String[] args)
    {

    }
}