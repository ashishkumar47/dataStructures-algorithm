import java.util.*;
import java.lang.*;
import java.io.*;



public class NextGreaterElement1{

	
    //Optimise Approach using stack
	static int[] nextGreaterElementOptimise(int[] nums1, int[] nums2){
		Map<Integer,Integer> map= new HashMap<>();
		Stack<Integer>st= new Stack<>();
		for(int i=0;i<nums2.length;i++){
			while(!st.isEmpty()&&st.peek()<nums2[i]){
				map.put(st.pop(),nums2[i]);
			}
			st.push(nums2[i]);
		}
		for(int j=0;i<nums1.length;j++){
			if(map.get(nums1[j])!=null)
			nums1[j]=map.get(nums1[j]);
		else
			nums1[j]=-1;
		}
		return nums1;
	}


	//BruteForce Approach
	static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result= new int[nums1.length];
        Map<Integer,Integer>store= new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            store.put(nums2[i],i);
        }
        for(int l=0;l<nums1.length;l++){
            int index=store.get(nums1[l]);
            int nextGreaterElement=-1;
            int element=nums1[l];
            for(int j=index;j<nums2.length;j++){
                if(nums2[j]>element){
                    nextGreaterElement=nums2[j];
                    break;
                }
            }
            result[l]=nextGreaterElement;
        }
        return result;
    }
	public static void main(String[] args) {
		
	}
}