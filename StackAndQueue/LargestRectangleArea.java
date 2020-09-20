import java.util.*;
import java.lang.*;
import java.io.*;



public class LargestRectangleArea{


    //Optimise Approach
	public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        int[] leftSmallest= new int[heights.length];
        int[] rightSmallest= new int[heights.length];
        Stack<Integer> st= new Stack<>();
        Arrays.fill(leftSmallest,-1);
        Arrays.fill(rightSmallest,heights.length);
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty()&&heights[st.peek()]>heights[i]){
                rightSmallest[st.pop()]=i;
            }
            st.push(i);
        }
        st= new Stack<>();
        for(int k=heights.length-1;k>=0;k--){
            while(!st.isEmpty()&&heights[st.peek()]>heights[k]){
                leftSmallest[st.pop()]=k;
            }
            st.push(k);
        }
        int area=0;
        for(int j=0;j<heights.length;j++){
            area=Math.max(area,heights[j]*(rightSmallest[j]-leftSmallest[j]-1));
        }
        return area;
        
    }


//BruteForce Approach
	public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        int area=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int left=0,right=0,l=i-1,r=i+1;
            while(l>=0&&heights[l]>=heights[i]){
                left++;
                l--;
            }
            while(r<heights.length&&heights[r]>=heights[i]){
                right++;
                r++;
            }
            area=Math.max(area,(left+right+1)*heights[i]);           
            
        }
        return area;        
    }
	public static void main(String[] args) {
		
	}
}