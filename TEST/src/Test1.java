import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Test1 {

	public static void main(String[] args){

//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		ArrayList<ArrayList<Integer>> subsets = subsets(list, 0);
		
//		int[] a = {2,3,4,5,-1,-1,-1,-1};
//		int[] b = {3,5,6,7};
//		
//		int[] m = merge(a, b, 4);
		
//		int[] a = {0, 1, 2, 3,6};
//		findMissingNumber(a, 5);
		
		
//		int[][] m = 
////			   {{1, 2},
////				{2, 4}};
//		   {{1, 2, 3, 4},
//				{2, 4, 5, 6},
//				{4, 6, 7, 8},
//				{7, 8, 8, 8}};
//		printSpiral(m);
		
		
//		System.out.println(convertToInFix(convertInToPost("3 + 3 * 2 - 3 + 1 * 2")));
//        System.out.println(convertInToPost2("3 + 3 * 2 - 3 + 1 * 2"));
//        // 3 3 2 * + 3 1 2 * -
//        // 3 6 + 3 1 2 * -
//        // 9 3 1 2 * -
//        // 
		
////		int a[] = {1, 3, 5, 7, 9}; 
//		System.out.println(findSum(a, 6));
		
		
		
//		System.out.println(isMatch("ababababaca", "ababaca"));
//		System.out.println(isMatch("abababbaca", "ababaca"));
//		System.out.println(isMatch("ababababxca", "ababaca"));
	
//		int[] a = {5, 1, -3, 3, 2, 2, -1};
//		System.out.println(maxSequence(a));
		
		int[] a = {1,2, 4, 6, 5, 7};
		LCS(a);
	} 
	
	
	public static void LCS(int[] a){
		ArrayList<ArrayList<Integer>> lis = new ArrayList<ArrayList<Integer>>();;
		ArrayList<Integer> _lis = new ArrayList<Integer>();
		_lis.add(a[0]);
		lis.add(_lis);
		
		int i = 1;
		while(i < a.length){
			if(a[i] < a[i - 1]){	 
				ArrayList<Integer> x = new ArrayList<>();
				x.add(a[i]);
				lis.add(x);
			}
			else{
				ArrayList<Integer> t = null;			
				for(ArrayList<Integer> al:  lis){
					if(t == null)
						t = al;
					else if(t.size() <= al.size())
						t = al;
					
						
					
				}
				ArrayList<Integer> x = new ArrayList<>();
				
				x.addAll(t);
				x.add(a[i]);
				lis.add(x);
			}
			++i;
		}

		ArrayList<Integer> t = null;			
		for(ArrayList<Integer> al:  lis){
			if(t == null)
				t = al;
			else if(t.size() < al.size())
				t = al;
		}
		for(Integer j : t){
			System.out.println(j +  " " );
		}

	}
	public static int maxSequence(int[] a){
		int current = 0;
		int max = 0;
		
		for(int i = 0; i < a.length; i++){
		
			if(current < 0 || current + a[i] < max) 
				current = 0;
			current += a[i];
			if(current > max)
				max = current;
		}

		return max;
	}

	
	
  //ababababaca
	  //ababaca
	//0012301

	public static int isMatch(String text, String pattern){
		int[] f = preProcessPattern(pattern);
		
		int i =0, j = 0;
		while(i < text.length()){
			if(text.charAt(i) == pattern.charAt(j)){
				if(j == pattern.length() - 1)
					return i - (pattern.length() -1);
				else{
					i++;
					j++;
				}
			}
			else if(j > 0){
				j = f[j - 1];
			}
			else{
				i++;
			}
		}
	
		return -1;
		
	}
	//ababaca
	//0
	private static int[] preProcessPattern(String p){
	
		int[] f = new int[p.length()];
		int i = 1;
		int j = 0;
		f[0] = 0;
		
		while(i < p.length()){
			if(p.charAt(i) == p.charAt(j)){
				f[i] = j + 1;
				i++;
				j++;
			}
			else if(j > 0){
				j = f[j - 1];
			}
			else
				i++;
		}
		return f;
	}
	
	
	
	
	
	

public static boolean findSum(int[] a, int n){
		
	int i = 0, j = 1;
	while(j < a.length){
		int sum = sum(a, i, j);
		if(sum == n)
			return true;
		else if(sum > n){
			i++;
			if(i == j)
				j++;
		}
		else{
			j++;
		}
	}
	return false;
}

private static int sum(int[] a, int i , int j){
	int sum = 0;
	while(i < j){
		sum += a[i++];
	}
	return sum;
}

	
	
	
	public static String convertInToPost2(String str){
		String rtn = "";
		String[]strs = str.split(" ");
		Stack<String> stack = new Stack<String>();
		int i = 0;
		while(i < strs.length){
			if(strs[i].equals("+") || strs[i].equals("-")){
				if(!stack.isEmpty()){
					if(!stack.peek().equals("/") || !stack.peek().equals("*")){
						while(!stack.isEmpty()){
							rtn = rtn + stack.pop() + " ";
						}
					}
					stack.push(strs[i]);
				}
				else
					stack.push(strs[i]);
			}
			else if(strs[i].equals("/") || strs[i].equals("*")){
				stack.push(strs[i]);
			}			
			else{
				rtn = rtn + strs[i] + " ";
			}
			++i;
		}
		while(!stack.isEmpty()){
			rtn = rtn + stack.pop() + " ";
		}
		return rtn;
	}

	
	public static int convertToInFix(String str){
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				//do nothing
			}
			else{
				if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*'){
					int b = stack.pop();
					int a = stack.pop();
					switch(str.charAt(i)){
						case '+':
							stack.push(a + b);
							break;
						case '-':
							stack.push(a - b);
							break;
						case '/':
							stack.push(a / b);
							break;
						case '*':
							stack.push(a * b);
							break;
					}
				}
				else{
					stack.push(Integer.parseInt(str.charAt(i) + ""));
				}
			}
			
		}	
		return stack.pop();
	}	
	

public static String convertInToPost(String str){
	
	StringBuilder sb = new StringBuilder();
	Stack<Character> stack = new Stack<>();

	for(int i = 0; i < str.length(); i++){
		if(str.charAt(i) == ' '){
			//do nothing
		}
		else{
			if(str.charAt(i) == '+' || str.charAt(i) == '-'){
				if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
					while(!stack.isEmpty()){
						sb.append(stack.pop());	
					}
				}
				else if(!stack.isEmpty() && (stack.peek() == '-' || stack.peek() == '-')){
					sb.append(stack.pop());	

				}	stack.push(str.charAt(i));
			}
			else if(str.charAt(i) == '*' || str.charAt(i) == '/'){
				stack.push(str.charAt(i));
			}		
			else{
				sb.append(str.charAt(i));
				sb.append(' ');
			}
		}
	}
	
	while(!stack.isEmpty()){
		sb.append(stack.pop());	
	}
	return sb.toString();
}
	
	public static void printSorted(int[][] m){
		int row = 0, col = 0;
		int current = m[0][0];
		int next = Integer.MAX_VALUE;
		
			while(row < m.length){
				col = 0;
				while(col < m.length){
					if(m[row][col] == current)
						System.out.println(m[row][col]);
					if(m[row][col] > current){
						next = Math.min(next, m[row][col]);
						
						if(row + 1 < m.length){
							row++;
							col = 0;
						
							if(m[row][0] > current){
								next = Math.min(next, m[row][col]);
								current = next;
								next = Integer.MAX_VALUE;
								row = -1;
								col = m.length;
							}
						}
						else{
							current = next;
							next = Integer.MAX_VALUE;
							row--;
							col--;
						}
					}
					col++;
				}
				row++;
			}
	}
	
	
	public static void printSpiral(int[][] a){

		int layer = 0;
		int layers = a.length / 2;
		
		while(layer < layers){
			int start = layer , end = a.length - layer;
			for(int i = start; i < end; i++){
				System.out.println(a[start][i]);
			}
			
			for(int i = 1 + start; i < end; i++){
				System.out.println(a[i][end - 1]);
			}		
			for(int i = end - 2; i >= start; --i){
				System.out.println(a[end - 1 ][i]);
			}
			for(int i = end - 2; i > start; --i){
				System.out.println(a[i][start]);
			}
			++layer;
		}
	}
	
	
	public static int findMissingNumber(int[] arr,int n){
	    int i;

	    i = n;
	    while (i-- > 0) {
	        n ^= i ^ arr[i];
	    }

	    return n;
	}
	
	//
	
	public static ArrayList<ArrayList<Integer>> fundSum(int[] a){

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		
		int i = 0;
		while(i < a.length){
			if(!map.containsKey(a[i])){
				map.put(a[i], a[i]);
			}
			++i;
		}

		i = 0;
		while(i < a.length){
			if(map.containsKey(0 - a[i])){
				ArrayList<Integer> l = new ArrayList<>();
				l.add(a[i]);
				l.add(0 - a[i]);
				list.add(l);
			}
			++i;
		}
		return list;
	}
	
	
//merge two sorted arrays
	public static int[] merge(int[] a, int[] b, int len){

		int lastIndexOfB = b.length - 1;
		int lastIndexOfA = len - 1;
		int mergeIndex = len + lastIndexOfB;
		
		while(mergeIndex > 0){
			if( (lastIndexOfA < 0 && lastIndexOfB >= 0)|| a[lastIndexOfA] < b[lastIndexOfB]){
				a[mergeIndex] = b[lastIndexOfB--];
			}
			else{
				a[mergeIndex] = a[lastIndexOfA--];
			}
			mergeIndex--;
		}
		return a;
	}

//all subsets
public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set, int index){

	ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
	if(index == set.size()){
		allSubsets.add(new ArrayList<Integer>());
		
	}
	else{
		allSubsets = subsets(set,index + 1);
		int item = set.get(index);
		
		ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> subset : allSubsets){
			ArrayList<Integer> newSubsets = new ArrayList<>();
			
			newSubsets.addAll(subset);
			newSubsets.add(item);
			moreSubsets.add(newSubsets);		
		}
		allSubsets.addAll(moreSubsets);
	}
	return allSubsets;	
}


}