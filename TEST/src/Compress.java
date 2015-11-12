
public class Compress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("rrraaabbbc"));
	    System.out.println(compress("rabc"));

	}

	public static String compress(String str){
		
		if(str == null || str.length() == 0)
			return str;
		
		StringBuilder sb = new StringBuilder();
		
		char current = str.charAt(0);
		int count = 1;
		
		for(int i = 1; i < str.length(); ++i){
			if(current == str.charAt(i)){
				count++;
			}
			else{
				sb.append(current);
				sb.append(count);
				
				current = str.charAt(i);
				count = 1;
			}
		}		
		sb.append(current);
		sb.append(count);
		return sb.toString();
	}
}
