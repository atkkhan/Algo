
public class FizzBuzz {
	public static void main(String[]  args){
		int a = 3;
		int b = 5;
		int n = 15;

		int i = 1;
		while(i <= n){
			boolean fizz = false; 
			boolean buzz = false;
			if(i % a == 0){
				fizz = true;
			}
			if(i % b == 0){
				buzz = true;
			}
			if(fizz && buzz)
				System.out.println(i + " Fizz buzz");
			if(fizz && !buzz)
				System.out.println(i + " fizz");
			if(!fizz && buzz)
				System.out.println(i + " buzz");
			++i;		
		}		
	}
}
