import java.util.*;
import java.lang.*;
import java.io.*;



class Pair{
    TreeNode root;
    int state;
    Pair(TreeNode root,int state){
        this.root=root;
        this.state=state;
    }
}
class BSTIterator {

    public List<Integer>inOrder;
    public int start;
    public BSTIterator(TreeNode root) {
        inOrder= new LinkedList<>();
        if(root!=null){
            Stack<Pair>st= new Stack<>();
        st.push(new Pair(root,1));
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                top.state++;
                if(top.root.left!=null){
                    st.push(new Pair(top.root.left,1));
                }
            }
            else if(top.state==2){
                inOrder.add(top.root.val);
                top.state++;
                if(top.root.right!=null){
                    st.push(new Pair(top.root.right,1));
                }
                
            }
            else{
                st.pop();                
            }
        }            
        }
        start=0;
    }
    
    /** @return the next smallest number */
    public int next() {
    if(inOrder.size()==0)
        return 0;
    int next=inOrder.get(start);
        start++;
        return next;        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(start<inOrder.size())
            return true;
        return false;
    }
}

public class BSTIteratorBruteForce{
	public static void main(String[] args) {
		
	}
}