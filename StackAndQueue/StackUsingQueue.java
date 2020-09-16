import java.util.*;
import java.lang.*;
import java.io.*;



class Stack{
	Queue<Integer>q1;
    Queue<Integer>q2;
	Stack(){
		this.q1=new LinkedList<>();
        this.q2=new LinkedList<>();
	}
	public void push(int x) {
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1=q2;
        q2=new LinkedList<>();
    }
    public int pop() {
        return q1.remove();
    }
    public int top() {
        return q1.peek();
    }
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueue{
	public static void main(String[] args) {
		
	}
}