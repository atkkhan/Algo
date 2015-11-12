
public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//System.out.println(a^b);
		
		int allOnes = ~0;
		int right = 3 >> 10;
		right = right - 1;
		int left = allOnes << 7;
		int t = 123^123;
		print(intToBinary(123));
//		print(intToBinary(1<< 5));
		print(intToBinary((1 << 5) - 1));
		print(intToBinary(123 ^ (1 << 5) - 1));

//		print(intToBinary(left | right));

//		
//		boolean[] ar1 = intToBinary(-64);
//		boolean[] ar2 = intToBinary(-64 >> 2);
//		print(ar1);
//		print(ar2);
//		System.out.println(binaryToInt(ar2));
//		print(intToBinary(1^215));
//		int x = -4;
//	       System.out.println(x<<1);   
//	       int y = 4;
//	       System.out.println(y<<1);   
	}
	private static int bits = 8; 
	public static boolean[] intToBinary(int n){
		boolean[] ar = new boolean[bits];
		
		boolean isNegative = (n < 0)? true: false;
		n = Math.abs(n);
		
		int i = 0;
		while(i < bits){
			if(Math.pow(2, bits - i - 1) <= n){
				ar[i] = true;
				n = (int) (n -  Math.pow(2, bits - i - 1));
			}
			++i;	
		}
		
		if(isNegative){
			i = 0;
			while(i < bits){
				ar[i] = (ar[i])? false: true;
				++i;	
			}
			boolean carry = true;
			i = bits - 1;
			while(i >= 0){
				if(carry == false){
					break;
				}
				if(ar[i]){
					ar[i] = false; 
					carry = true;
				}
				else{
					ar[i] = true; 
					carry = false;
				}
				--i;	
			}		
		}
		return ar;
	}


	public static int binaryToInt(boolean[] ar){

		int i = 0, total = 0;
		while(i < ar.length){
			if(ar[i]){
				total += Math.pow(2, bits - i - 1);
			}
			++i;
		}
		return total;
	}
	
	public static void print(boolean[] ar){
		
		int i = 0;
		while(i < ar.length){
			System.out.print((ar[i])? "1": "0");
			++i;
		}
		System.out.println("");
	}
}
