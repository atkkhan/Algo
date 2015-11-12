
public class IsRotation {

	public boolean isRotation (String s1, String s2){
		int len = s1.length();
		if(s2.length() == len & len > 0){
			String s1s1 = s1 + s1;
			return (s1s1.indexOf(s2) == -1)?false:true;
		}
		else 
			return false;
	}
	
	
	
	public static void mail(String[] args){


	}
}
