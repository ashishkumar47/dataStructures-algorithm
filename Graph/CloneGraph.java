import java.util.*;
import java.lang.*;
import java.io.*;



public class CloneGraph{

	static Node cloneGraphUsingBfs(Node node) {
        if(node==null)
            return null;
        Map<Node,Node> map= new HashMap<>();
        Queue<Node>q= new LinkedList<>();
        q.add(node);
        map.put(node,new Node(node.val));
        Node root=null;
        while(!q.isEmpty()){
            Node temp=q.remove();
            Node src=map.get(temp);
            if(root==null)
                root=src;
            Node newNode=null;
            for(Node neighbor:temp.neighbors){
                if(map.get(neighbor)!=null){
                    newNode=map.get(neighbor);
                }
                else{
                    newNode=new Node(neighbor.val);
                    map.put(neighbor,newNode);
                    q.add(neighbor);
                }
                src.neighbors.add(newNode);
            }
        }
        return root;
    }

	static  Node helper(Node node,Map<Node,Node>visited){
       if(node==null)
           return null;
       if(visited.get(node)!=null)
           return visited.get(node);
        Node newNode= new Node(node.val);
       visited.put(node,newNode);
        for(Node neighbor:node.neighbors){            
             Node returnNode=helper(neighbor,visited);
                newNode.neighbors.add(returnNode);
        }
        return newNode;
    }
    static Node cloneGraphUsingDfs(Node node) {
        Map<Node,Node>visited= new HashMap<>();
       return helper(node,visited);        
    }

	public static void main(String[] args) {
		
	}
}