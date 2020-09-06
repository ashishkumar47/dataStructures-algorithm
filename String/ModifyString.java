import java.util.*;
import java.lang.*;
import java.io.*;



//https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

public class ModifyString{


	//BruteForce Approach
	static String modifyString(String s) {
        char[] ch=s.toCharArray();
        char previous='~';
        int j=0;
        while(j<ch.length-1){
            char letter=ch[j];
            if(letter=='?'){
                for(int i=0;i<26;i++){
                    char character=(char)('a'+i);
                if(character!=previous&&character!=ch[j+1]){
                    ch[j]=character;
                    break;
                }
            }
                
            }
            previous=ch[j];
            j++;
            
        }
        if(j==ch.length-1&&ch[ch.length-1]=='?'){
            if(previous=='z'){
                ch[ch.length-1]=(char)(previous-1);
            }
            else{
                ch[ch.length-1]=(char)(previous+1);
            }
        }
        return String.valueOf(ch);
    }



	//Optimise Approach
	static char getChar(char i,char k){
        char sample='a';
        if(k=='@'){
            while(sample==i){
                sample++;
            }
            if(sample=='z')
                sample='a';
            
        }
        else{
            while(sample==i||sample==k){
                sample++;
            }
            if(sample=='z')
                sample='a';
        }
        return sample;
    }
    static String modifyStringOptimise(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='?')
                return "a";
            else
                return s;
        }
        char[] ch=s.toCharArray();
        char previous='~';
        int j=0;
        while(j<ch.length){
            char letter=ch[j];
            if(letter=='?'){
               if(j==0){
                   char character=getChar(ch[j+1],'@');
                   ch[j]=character; 
                   
               }
            else if(j<ch.length-1){
                char character=getChar(ch[j-1],ch[j+1]);
                ch[j]=character; 
            }
            else{
                char character=getChar(ch[j-1],'@');
                ch[j]=character;                     
                }               
            }
            previous=ch[j];
            j++;
            
        }
        return String.valueOf(ch);
    }
	public static void main(String[] args) {

		String str="??yw?ipkj?";
		System.out.println(modifyString(str));
		System.out.println(modifyStringOptimise(str));		
	}
}



// "?zs"
// "ubv?w"
// "j?qg??b"
// "??yw?ipkj?"