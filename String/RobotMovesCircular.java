import java.util.*;
import java.lang.*;
import java.io.*;



public class RobotMovesCircular{
	static boolean doesRobotMovesCircular(String str){
		char currentDirection='N';
		int x=0,y=0;
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(ch=='G'){
				if(currentDirection=='N'){
					y++;
				}
				else if(currentDirection=='S'){
					y--;
				}
				else if(currentDirection=='E'){
					x++;
				}
				else{
					x--;
				}

			}
			else if(ch=='L'){
				if(currentDirection=='N'){
				currentDirection='W';
				}
				else if(currentDirection=='S'){
				currentDirection='E';
				}
				else if(currentDirection=='E'){
				currentDirection='N';
				}
				else{
				currentDirection='S';
					
			    }
			}
			else{
				if(currentDirection=='N'){
				currentDirection='E';
				}
				else if(currentDirection=='S'){
				currentDirection='W';
				}
				else if(currentDirection=='E'){
				currentDirection='S';
				}
				else{
				currentDirection='N';					
			    }
			}
		}
		if(x==0&&y==0)
				return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		input.nextLine();
		for (int i = 0; i < t; i++) {
			String str=input.nextLine();
			if(doesRobotMovesCircular(str))
			System.out.println(str+":Circular");
			else
			System.out.println(str+":Not Circular");
		}		
	}
}




// RGGGGRRGGRGRGGRRRRRGRGGRRRGGGGRRRGGGRGRGGGGRGRRGRGRGRRGRRRGGGRGRGRGGGRGRGRGRRGRGRRRR : Not Circular
// GLGLGLG : Circular
// GLLG : Circular
// GGGGL : Not Circular
// GRGRGRG : Circular
// GLRGRLGGLR : Not Circular