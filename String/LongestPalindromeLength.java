import java.util.*;
import java.lang.*;
import java.io.*;




public class LongestPalindromeLength{
	static int longestPalindrome(String s) {
        if(s==null||s.length()==0)
            return 0;
        int[] count=new int[128];
        int ans=0;
        boolean isOddIncluded=true;
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            count[ch[i]]++;
        }
        for(int j=0;j<count.length;j++){
            if(count[j]!=0){
                if(count[j]%2==0){
                    ans+=count[j];
                }
                else{
                    if(isOddIncluded){
                        ans+=count[j];
                        isOddIncluded=false;
                    }
                    else{
                        ans+=count[j]-1;
                    }
                }
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		
	}
}