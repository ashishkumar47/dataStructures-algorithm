import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Stack;





public class NextSmallestElement{


	//Optimise Approach
	static int[] nextSmallestElementOptimise(int[] nums){
		int[] result= new int[nums.length];
		Arrays.fill(result,-1);
		Stack<Integer> st= new Stack<>();
		for(int i=0;i<nums.length;i++){
			while(!st.isEmpty()&&nums[st.peek()]>nums[i]){
				result[st.pop()]=nums[i];
			}
			st.push(i);
		}
		return result;
	}


	//BruteForce Approach
	static int[] nextSmallestElement(int[] nums){
		int[] result= new int[nums.length];
		for(int i=0;i<nums.length;i++){
			int element=-1;
			for(int j=i;j<nums.length;j++){
				if(nums[j]<nums[i]){
					element=nums[j];
					break;
				}
			}
			result[i]=element;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] a={4, 8, 5, 2, 25};
		int[] greaterElements=nextSmallestElementOptimise(a);
		for(int i=0;i<greaterElements.length;i++){
			System.out.println(greaterElements[i]);
		}
	}
}