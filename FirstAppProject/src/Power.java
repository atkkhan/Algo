
public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2,8));
	}

	
	public static int pow(int x, int n){
		if(n == 0) return 1;
		
		else if(n % 2 == 0){
			int tmp = pow(x, n/2);
			return tmp * tmp;
		}
		else
			return (x * pow(x,n-1));
	}
}
