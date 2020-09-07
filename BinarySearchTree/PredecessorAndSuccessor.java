import java.util.*;
import java.lang.*;
import java.io.*;



class Res{
	Node pre=null;
	Node suc=null;
}


public class PredecessorAndSuccessor{
	static void findPreSuc(Node root, Res p, int key)
    {
       if(root.data==key){
       	if(root.left!=null){
       		Node temp=root.left;
       		while(temp.right!=null){
       			temp=temp.right;
       		}
       		p.pre=temp;
       	}
       	if(root.right!=null){
       		Node temp=root.right;
       		while(temp.left!=null){
       			temp=temp.left;
       		}
       		p.suc=temp;
       	}
       	return;
       }
       if(root.data>key){
       	p.suc=root;
       	findPreSuc(root.left,p,key);
       }
       if(root.data<key){
       	p.pre=root;
       	findPreSuc(root.right,p,key);
       }
    }
	public static void main(String[] args) {
		 
	}
}