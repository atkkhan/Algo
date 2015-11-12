
public class NextBigNumber {
	public static void main(String[] arg){
		
		//System.out.println(100%1000);
		System.out.println(nextBigNumber(99));
		System.out.println(nextBigNumber(123));
	}
	
	public static int nextBigNumber(int v){
		int nextNumber = 0;
		int i = 0;
		char[] str = new String("" + v).toCharArray();
		
		char c = str[i];
		
		
		while(i < )
		if(c == 9){
			nextNumber = (int)Math.pow(new Double(10), new Double(str.length));
		}
		else {
			if(i != 0)
				
						nextNumber = c + 1;
		}
		
		//int digit = i %
		
		
		return nextNumber;
	}
}
