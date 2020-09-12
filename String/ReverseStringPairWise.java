import java.util.*;
import java.lang.*;
import java.io.*;



public class ReverseStringPairWise{
	 static void reverseWords(char[] ch,int start,int end){
        int i=start,j=end;
        while(start<=end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
    }
    static String reverseStr(String s, int k) {
        if(s==null||s.length()==0)
            return "";
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i+=2*k){
            int start=i;
            int end=i+k-1;
            if(end<ch.length){
                reverseWords(ch,start,end);
            }
            else{
                end=ch.length-1;
                reverseWords(ch,start,end);
            }
        }
        return String.valueOf(ch);
    }
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
			int n=input.nextInt();
			System.out.println(str+":"+reverseStr(str,n));
		}
		
	}
}

//s = "abcdefg", k=2
//s = "abcd", k=3
//s = "a" , k=2
//s = "abcdefg" , k=3