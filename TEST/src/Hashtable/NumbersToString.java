package Hashtable;

public class NumbersToString {
	public static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen" };
    public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million"};

    
    
    public static void main(String[] args){
    	
    	
    }
    
    
    public static String numbersToString(int num){
    	if(num ==  0)
    		return "Zero";
    	else if(num < 0)
    		return "Negative" + numbersToString(num * (-1));
    	
    	
    	
    	
    	return "";
    }
    
    public static String numbersToString100(int number){
    	
    	String str = "";
    	
    	if(number >= 100){
    		str += digits[number / 100 - 1] + " Humdred ";
    		number %= 100;
    	}
    	
    	if(number >= 11 && number <=19){
    		str += teens[number - 11] + " ";
    	}
    	else if (number == 10 || number >= 20){
    		str += tens[number / 10 - 1] + " ";
    		number %= 10;
    	}
    	
    	if(number < 1 && number < 9)
    		str += digits[number - 1] + " ";
    	return str;
    }
    
}
