import java.util.*;
import java.lang.*;
import java.io.*;




public class ValidPalindrome{
	static boolean validPalindrome(String s){
		if(s==null||s.length()==0)
            return true;
        String reference="abcdefghijklmnopqrstuvwxyz0123456789";
        String str=s.toLowerCase();
        char[] ch=str.toCharArray();
		int i=0,j=ch.length-1;
        while(i<=j){
            while(i<j&&reference.indexOf(ch[i])==-1){
                i++;
            }
            while(i<j&&reference.indexOf(ch[j])==-1){
                j--;
            }
            
            if(ch[i]!=ch[j])
                return false; 
            i++;
            j--;               
            
        }
        return true;   
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
			System.out.println(validPalindrome(str));
		}
		
	}
}



//A man, a plan, a canal: Panama
//race a car