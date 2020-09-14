import java.util.*;
import java.lang.*;
import java.io.*;



class Queue{
	int[] queue;
	int front;
	int back;
	Queue(){
		this.queue=new int[1000];
		this.front=0;
		this.back=-1;
	}

	public void add(int element){
		if(back>999){
			System.out.println("Queue is full");
			return;
		}
		back++;
		queue[back]=element;
		System.out.println(element+" is added in the queue");
	}
	public int remove(){
		if(back<0||front>back){
			System.out.println("Queue is Empty");
			return -1;
		}
		int temp=queue[front];
		front++;
		return temp;
	}
	public int peek(){
		if(back<0){
			System.out.println("Queue is Empty");
			return -1;
		}
		return queue[front];
	}
	public boolean isEmpty(){
		return back>0;
	}
	public int size(){
		return back-front+1;
	}
}
public class QueueUsingArray{
	public static void main(String[] args) {
		Queue q= new Queue();
		System.out.println(q.remove());
		System.out.println(q.peek());
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println("Size of the queue is "+ q.size());
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println(q.peek());
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println(q.remove()+" is removed from the queue");
		System.out.println("Size of the queue is "+ q.size());
		
	}
}