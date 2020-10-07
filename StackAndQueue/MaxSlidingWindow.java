import java.util.*;
import java.lang.*;
import java.io.*;




public class MaxSlidingWindow{

	//BruteForce Approach
	public int findMax(int[] nums,int start,int end){
        int maxElement=Integer.MIN_VALUE;
        while(start<=end){
            maxElement=Math.max(maxElement,nums[start]);
            start++;
        }
        return maxElement;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0)
            return nums;
        List<Integer>elements=new LinkedList<>();
        for(int i=0;i<=nums.length-k;i++){
            int max=findMax(nums,i,i+k-1);
            elements.add(max);
        }
        int[] a= new int[elements.size()];
        for(int i=0;i<elements.size();i++){
            a[i]=elements.get(i);
        }
        return a;        
    }

    public static void main(String[] args) {
    	
    }
}