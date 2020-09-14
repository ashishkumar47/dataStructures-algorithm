import java.util.*;
import java.lang.*;
import java.io.*;





class Stack{
	int[] stack;
	  int size;
	  Stack(){
	  	this.stack= new int[1000];
	  	this.size=-1;
	  }


	public void push(int element){
		if(size>999){
			System.out.println("Stack overFlow");
			return;
		}
		size++;
		stack[size]=element;
		System.out.println(element+" pushed into the stack");
	}
	public int pop(){
		if(size<0){
			System.out.println("Stack underFlow");
			return 0;
		}
		int temp=stack[size];
		size--;
       return temp;
	}
	public int peek(){
		if(size<0){
			System.out.println("Stack is underFlow");
			return 0;
		}
		return stack[size];
	}
	public boolean isEmpty(){
		return size>0;
	}

}
public class StackUsingArray{
	public static void main(String[] args) {
		Stack st= new Stack();
		st.push(1);
		System.out.println(st.isEmpty());
		System.out.println(st.pop()+" is poped from the stack");
		System.out.println(st.peek());
		
	}
}