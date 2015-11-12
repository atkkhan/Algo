
public class Pow {
	public static void main(String[] args){
		System.out.println(pow(3,3));
		System.out.println(pow(10,10));
	} 
	
	public static double pow(double base, double pow){
		
		if(base == 0)
			return 0;
		if(pow == 0)
			return 1;
		if(pow == 1)
			return base;
		return pow(base, 1) * pow(base, pow - 1);
	}
}
