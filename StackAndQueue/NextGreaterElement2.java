import java.util.*;
import java.lang.*;
import java.io.*;




public class NextGreaterElement2{

 //Optimise Approach
 static int[] nextGreaterElementsOptimise(int[] nums) {
        int[] result= new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<nums.length*2;i++){
            int j=i%nums.length;
            while(!st.isEmpty()&&nums[st.peek()]<nums[j]){
                result[st.pop()]=nums[j];
            }
            st.push(j);
        }       
        return result;        
    }


  //BruteForce Approach
    static int[] nextGreaterElements(int[] nums) {
        int[] result= new int[nums.length];
        for(int i=0;i<nums.length*2;i++){
            int k=i%nums.length;
            int element=-1;
            for(int l=k;l<nums.length*2;l++){
                int m=l%nums.length;
                if(nums[m]>nums[k]){
                    element=nums[m];
                    break;
                }                
            }
            result[k]=element;
        }
        return result;
    }


	public static void main(String[] args) {
		
	}
}