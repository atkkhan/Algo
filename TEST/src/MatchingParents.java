import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class MatchingParents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     char[] a1 = {'(', '[', ']', ')'};
	        System.out.println(matchParnets(a1));
	        char[] a2 = {'(', '(', ']', ')'};
	        System.out.println(matchParnets(a2));
	        char[] a3 = {'(', ')', '(', ')'};
	        System.out.println(matchParnets(a3));
	        char[] a4 = {'{', ')', '(', ')'};
	        System.out.println(matchParnets(a4));
	}

	
	public static boolean matchParnets(char[] ar){
		Map<Character, Character> map = new HashMap();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < ar.length; ++i){
			//char c = ar[]
			if(map.get(ar[i]) != null){
				stack.push(ar[i]);
			}
			else{
				if(map.get(stack.peek()) == ar[i]){
					stack.pop();
				}
				else{
					return false;
				}	
			}
		}
		
		return (stack.isEmpty())?true:false;
	}
}
