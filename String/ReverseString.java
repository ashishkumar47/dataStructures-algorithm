import java.util.*;
import java.lang.*;
import java.io.*;




public class ReverseString{
	static String reverseString(String str){
		if(str==null||str.length()==0)
			return "";
		char[] ch= str.toCharArray();
		int i=0,j=ch.length-1;
		while(i<=j){
			char temp=ch[i];
			ch[i]=ch[j];
			ch[j]=temp;
			i++;
			j--;
		}
		return String.valueOf(ch);
	}
	public static void main(String[] args) {

		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
			System.out.println(str+" : "+reverseString(str));
		}	
	}
}