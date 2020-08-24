import java.util.*;
import java.lang.*;
import java.io.*;


class Pair
{
    Node root;
    int hd;
    Pair(Node root, int hd)
    {
        this.root = root;
        this.hd = hd;
    }
}



public class TopView
{
    static void topView(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer>map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        q.add(new Pair(root, 0));
        while(!q.isEmpty())
        {
            Pair temp = q.remove();
            int hd = temp.hd;
            min = Math.min(min, hd);
            max = Math.max(max, hd);
            if(map.get(hd) == null)
            {
                map.put(hd, temp.root.data);
            }
            if(temp.root.left != null)
            {
                q.add(new Pair(temp.root.left, hd - 1));
            }
            if(temp.root.right != null)
            {
                q.add(new Pair(temp.root.right, hd + 1));
            }
        }
        for(int i = min; i <= max; i++)
        {
            System.out.print(map.get(i) + " ");
        }


    }
    public static void main(String[] args)
    {

    }
}