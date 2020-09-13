import java.util.*;
import java.lang.*;
import java.io.*;




public class CorrectCapitalization{
	static boolean isSubStringCorrectlyCapitalize(String str){
			boolean isCapital=false;
			boolean isSmall=false;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)>='a'&&str.charAt(i)<='z')
					isSmall=true;
				else
					isCapital=true;
			}
			if(isCapital&&isSmall)
				return false;
			return true;

	}
	static boolean correctCapitalization(String str){
		if(str==null||str.length()==0)
			return false;
		if(str.charAt(0)>='A'&&str.charAt(0)<='Z'){
			String travString=str.substring(1);
			return isSubStringCorrectlyCapitalize(travString);			
		}
		String travString=str.substring(1);
		return isSubStringCorrectlyCapitalize(travString);
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
			System.out.println(str+":"+correctCapitalization(str));
		}
	}
}


// A string correctly uses capitalization 
// if all letters are capitalized, no letters are capitalized,
// or only the first letter is capitalized.

// "InDia", return false
// "Calvin", return true
// "compUter", return false
// "coding", return true
// "HELLOWORLD", return true
// "Capitalization", return true