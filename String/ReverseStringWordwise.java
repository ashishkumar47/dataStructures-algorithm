import java.util.*;
import java.lang.*;
import java.io.*;




public class ReverseStringWordwise{
	static void reverseWordsWise(char[] ch,int start,int end){
        int i=start,j=end;
        while(i<=j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }
    static String reverseWords(String s) {
        if(s==null||s.length()==0)
            return "";
        s=s.trim();
        int k=0,l=0;
        String newString="";
        while(k<s.length()){
            if(s.charAt(k)==' '){
                l=k;
                while(s.charAt(l)==' '){
                    l++;
                }
                k=l-1;
                newString=newString+" ";
            }
            if(s.charAt(k)!=' '){
                newString=newString+s.charAt(k);
            }            
            k++;
        }
        char[] ch=newString.toCharArray();
        reverseWordsWise(ch,0,ch.length-1);
        int j=0,i=0;
        while(j<ch.length){
            while(j<ch.length&&ch[j]!=' '){
                j++;
            }
            reverseWordsWise(ch,i,j-1);
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



//the sky is blue : blue is sky the
//  hello world!  : world! hello
//a good   example: example good a