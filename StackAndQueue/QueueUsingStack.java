import java.util.*;
import java.lang.*;
import java.io.*;



class Queue{
	/** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1= new Stack<>();
        s2= new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.add(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
public class QueueUsingStack{
	public static void main(String[] args) {
		
	}
}