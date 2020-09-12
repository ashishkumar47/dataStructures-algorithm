import java.util.*;
import java.lang.*;
import java.io.*;




public class LongestPalindromicSubstring{



//Optimise Approach
	static int resultLength;
	static int resultStart;
 static void setPalindromeFromCenter(String s,int start,int end){
 	if(s==null||s.length()==0)
 		return;
 	while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
 		start--;
 		end++;
 	}
 	if(resultLength<end-start-1){
 		resultStart=start+1;
 		resultLength=end-start-1;
 	}
 	
 }
 static String longestPalindromicSubstringOptimise(String s){
 	if(s==null||s.length()==0)
 		return "";
 	for(int i=0;i<s.length();i++){
 		setPalindromeFromCenter(s,i,i);
 		setPalindromeFromCenter(s,i,i+1);
 	}
 	return s.substring(resultStart,resultStart+resultLength);
 }




	//Brute Force Approach
	static boolean checkPalindrome(char[] ch,int start,int end){
		int i=start,j=end;
		while(start<=end){
			if(ch[start]!=ch[end]){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	static String longestPalindromicSubstring(String str){
		if(str==null||str.length()==0)
			return str;
		char[] ch=str.toCharArray();
		int length=Integer.MIN_VALUE;
		int startLength=0,endLength=0;
		for(int i=0;i<ch.length;i++){
			for(int j=0;j<ch.length;j++){
				if(checkPalindrome(ch,i,j)&&(j-i+1)>length){
					startLength=i;
					endLength=j;
					length=j-i+1;
				}
			}
		}
		String subString=String.valueOf(ch);
		return subString.substring(startLength,endLength+1);
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
			System.out.println(str+":"+longestPalindromicSubstringOptimise(str));
		}
		
	}
}

//cbbd
//babad