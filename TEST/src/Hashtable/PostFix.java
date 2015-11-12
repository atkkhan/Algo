package Hashtable;

import java.util.Stack;

public class PostFix {
	public static void main(String[]  args){
		System.out.println(postFix(convertInToPost("3 + 3 * 2 - 3 + 1 * 2")));
		//System.out.println(convertInToPost("3 + 3 * 2 - 3 + 1 * 2"));
		// 3 3 2 * + 3 1 2 * -
		// 3 6 + 3 1 2 * -
		// 9 3 1 2 * -
		// 
	}
	
	public static int postFix(String str){
		int rtn = 0;
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		String[] strs = str.split(" ");
		while(i < strs.length){
			if(strs[i].equals("+") || strs[i].equals("-") || strs[i].equals("*") || strs[i].equals("/")){
				int b = stack.pop();
				int a = stack.pop();
				char op = strs[i].charAt(0);
				
				switch(op){
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
				stack.push(new Integer(strs[i]));
			}
			i++;
		}
		return stack.pop();
	}

	public static String convertInToPost(String str){
		String rtn = "";
		String[]strs = str.split(" ");
		Stack<String> stack = new Stack<String>();
		int i = 0;
		while(i < strs.length){
			if(strs[i].equals("+") || strs[i].equals("-")){
				if(!stack.isEmpty()){
					if(stack.peek().equals("/") || stack.peek().equals("*")){
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
}
