import java.util.*;
import java.lang.*;
import java.io.*;




class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}
class Stack{
	Node head;
	Stack(){
		this.head=null;
	}

	public void push(int element){
		Node temp=new Node(element);
		if(head==null){
			head=temp;
		}
		else{
			temp.next=head;
			head=temp;
		}
	}
	public int pop(){
		if(head==null){
			System.out.println("Stack is Empty");
			return -1;
		}
		int headElement=head.data;
		head=head.next;
		return headElement;
	}
	public int peek(){
		if(head==null){
			System.out.println("Stack is Empty");
			return -1;
		}
		return head.data;
	}
	public boolean isEmpty(){
		return head==null;
	}

}
public class StackUsingLinkedList{
	public static void main(String[] args) {
		Stack st= new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.isEmpty());
		System.out.println(st.pop()+" is poped from the stack");
		System.out.println(st.pop()+" is poped from the stack");
		System.out.println(st.pop()+" is poped from the stack");
		System.out.println(st.pop()+" is poped from the stack");
		System.out.println(st.peek());		
	}
}