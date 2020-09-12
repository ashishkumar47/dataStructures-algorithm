import java.util.*;
import java.lang.*;
import java.io.*;




public class ReverseStringInPlace{
	static void reverseWordsInplace(char[] ch,int start,int end){
        int i=start,j=end;
        while(start<=end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
    }
    static String reverseWords(String s) {
        if(s==null||s.length()==0)
            return "";
        char[] ch=s.toCharArray();
        int i=0,j=0;
        while(j<ch.length){
            while(j<ch.length&&ch[j]!=' '){
                j++;
            }
            reverseWordsInplace(ch,i,j-1);
            j++;
            i=j;
        }
        return String.valueOf(ch);        
    }
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
			System.out.println(str+":"+reverseWords(str));
		}
		
	}
}