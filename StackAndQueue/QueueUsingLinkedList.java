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

class Queue{
	Node head;
	Node tail;
	Queue(){
	  this.head=null;
	  this.tail=null;
	}
	public void add(int element){
		Node temp=new Node(element);
		if(head==null){
			head=temp;
			tail=temp;
		}
		else{
			tail.next=temp;
			tail=tail.next;
		}

	}
	public int remove(){
		if(head==null){
			System.out.println("Queue is Empty");
			return -1;
		}
		int temp=head.data;
		head=head.next;
		return temp;
	}
	public int peek(){
		if(head==null){
			System.out.println("Queue is Empty");
			return -1;
		}
		return head.data;
	}
	public boolean isEmpty(){
		return head==null;
	}
}

public class QueueUsingLinkedList{
	public static void main(String[] args) {
		Queue q= new Queue();
		System.out.println(q.remove());
		System.out.println(q.peek());
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println(q.peek());
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println(q.remove()+" is removed from the queue");		
	}
}