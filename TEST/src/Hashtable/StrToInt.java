package Hashtable;

public class StrToInt {

		public static void main(String[] args){
			System.out.println(strToInt("123"));
			
		}
		
		public static int strToInt(String str){
			int i = 0, total = 0, v = 0;
			
			while(i < str.length()){
				i++;
				char c = str.charAt(str.length() - i);
				v = 0;
				switch(c){
				case '0' : v = 0;
				break;
				case '1' : v = 1;
				break;
				case '2' : v = 2;
				break;
				case '3' : v = 3;
				break;
				case '4' : v = 4;
				break;
				case '5' : v = 5;
				break;
				case '6' : v = 6;
				break;
				case '7' : v = 7;
				break;
				case '8' : v = 8;
				break;
				case '9' : v = 9;
				break;				
				}
			
//				if(i != 1)
					v = (int) (v * Math.pow(10, i - 1));
				total = total + v;
			}
			return total;
		}
}
