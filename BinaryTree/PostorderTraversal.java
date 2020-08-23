import java.util.*;
import java.lang.*;
import java.io.*;




public class PostorderTraversal
{

    //Iterative Approach

    static ArrayList<Integer> postorderTraversal(Node root)
    {
        ArrayList<Integer>list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<Node> st = new Stack<>();
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
        Node save = null;
        while(!st.isEmpty())
        {
            Node temp = st.top();
            if(temp.right != null&&temp.right!=save)
            {
                Node travRight = temp.right;
                while(travRight != null)
                {
                    st.push(travRight);
                    travRight = travRight.left;
                }
            }
            else
            {
                save = temp;
                list.add(st.pop());
            }
        }
        return list;
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