import java.util.*;
import java.lang.*;
import java.io.*;



public class AddBinary{
	static long convertToDecimal(String str){
		long d=0,p=1;
		for(int i=str.length()-1;i>=0;i--){
			int number=str.charAt(i)-'0';
			d=d+p*number;
			p=p*2;
		}
		return d;
	}
	static String convertToBinary(long number){
		long[] a=new long[32];
		int i=0;
		String answer="";
		while(number>0){
		a[i]=number%2;
		number=number/2;
		i++;
		}
		for(int j=i-1;j>=0;j--){
			answer+=a[j];
		}
		return answer;
	}
	static String addBinary(String str1,String str2){
		if(str1==null&&str2==null)
			return "";
		if(str1==null&&str2!=null)
			return str2;
		if(str1!=null&&str2==null)
			return str1;
		long number1=convertToDecimal(str1);
		long number2=convertToDecimal(str2);
		return convertToBinary(number1+number2)+"";

	}
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int t=input.nextInt();
		input.nextLine();
		for(int i=0;i<t;i++){
			String str1=input.nextLine();
			String str2=input.nextLine();
			System.out.println(str1+"+"+str2+"->"+addBinary(str1,str2));
		}
		
	}
}


// "100" + "1", return "101"
// "11" + "1", return "100"
// "1" + "0", return  "1"