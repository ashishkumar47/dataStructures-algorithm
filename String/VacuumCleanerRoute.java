import java.util.*;
import java.lang.*;
import java.io.*;



public class VacuumCleanerRoute{
	static boolean isReturnToOriginal(String str){
		if(str==null||str.length()==0)
			return true;
		int x=0,y=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='R'){
				x++;
			}
			else if(str.charAt(i)=='L'){
				x--;
			}
			else if(str.charAt(i)=='U'){
				y++;
			}
			else{
				y--;
			}
		}
		if(x==0&&y==0)
				return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str=input.nextLine();
		    System.out.println(isReturnToOriginal(str));
		}
		
	}
}


// "LR", return true
// "URURD", return false
// "RUULLDRD", return true