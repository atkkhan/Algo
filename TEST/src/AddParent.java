import java.util.ArrayList;


public class AddParent {

	public static void main(String[] args) {
	
		int count = 3; 
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParent(list, count, count, str, 0);
		System.out.println("");
	}
	public static void addParent(ArrayList<String> list,
			int leftRem, int rightRem, 
			char[] str, int count){
		
		
		if(leftRem < 0 || rightRem < leftRem) return;
		
		if(leftRem == 0 && rightRem == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		}
		else{
			if(leftRem > 0){
				str[count] = '(';
				addParent(list, leftRem - 1, rightRem, str, count + 1);
			}
			if(rightRem > leftRem){
				str[count] = ')';
				addParent(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
		
	}
}
