import java.util.*;
import java.lang.*;
import java.io.*;




public class PopulateNextPointer{


	//Recursive Approach
	static void populate(Node root){
        if(root==null)
            return;
        if(root.left!=null){
            root.left.next=root.right;
        }
        if(root.right!=null&&root.next!=null){
            root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);   
    }
    static Node connect(Node root) {
        populate(root);
        return root;
    }

	//Iterative Approach
	static Node connectIterative(Node root) {
        if(root==null)
            return root;
        Queue<Node> q= new LinkedList<>();
        Node save=null;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node temp=q.peek();
                if(i!=0){
                    save.next=temp;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                save=q.remove();
            }
        }
        return root;
    }
	public static void main(String[] args) {
		
	}
}