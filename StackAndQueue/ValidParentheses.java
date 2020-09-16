import java.util.*;
import java.lang.*;
import java.io.*;




public class ValidParentheses{
	static boolean isValid(String s) {
        if(s==null||s.length()==0)
            return false;
        Stack<Character>st= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }
            else if(ch==')'){
                if(st.peek()=='(')
                    st.pop();
                else
                    st.push(ch);
            }
            else if(ch==']'){
                if(st.peek()=='[')
                    st.pop();
                else
                    st.push(ch);
                
            }
            else if(ch=='}'){
                if(st.peek()=='{')
                    st.pop();
                else
                    st.push(ch);
                
            }
            else{
                st.push(ch);
            }
        }
        if(st.isEmpty())
            return true;
        return false;
        
    }
	public static void main(String[] args) {
		
	}
}


//Note: counting approach will break on this tescase: "([)]"