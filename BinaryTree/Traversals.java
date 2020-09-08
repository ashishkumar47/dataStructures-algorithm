import java.util.*;
import java.lang.*;
import java.io.*;



class Pair{
	TreeNode node;
	int state;
	Pair(TreeNode node,int state){
		this.node=node;
		this.state=state;
	}
}
class AllTraversals{
	List<Integer>inOrder;
	List<Integer>preOrder;
	List<Integer>postOrder;
	AllTraversals(List<Integer>inOrder,List<Integer>preOrder,List<Integer>postOrder){
		this.preOrder=preOrder;
		this.postOrder=postOrder;
		this.inOrder=inOrder;
	}
}
public class Traversals{
	static AllTraversals traversals(TreeNode root){
		Stack<Pair>st= new Stack<>();
		st.push(new Pair(root,1));
		List<Integer>preOrder= new ArrayList<>();
		List<Integer>inOrder= new ArrayList<>();
		List<Integer>postOrder= new ArrayList<>();
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){  //preOrder, state++, travel Left
				preOrder.add(top.node.val);
				top.state++;
				if(top.node.left!=null){
					st.push(new Pair(top.node.left,1));
				}

			}
			else if(top.state==2){ //inorder, state++,right
				inOrder.add(top.node.val);
				top.state++;
				if(top.node.right!=null){
					st.push(new Pair(top.node.right,1));
				}

			}
			else{ //postOrder,pop
				postOrder.add(top.node.val);
				st.pop();
			}
		}
		return new AllTraversals(inOrder,preOrder,postOrder);
	}
	public static void main(String[] args) {
		
	}
}