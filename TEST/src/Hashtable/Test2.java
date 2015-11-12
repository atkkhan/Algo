package Hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
	public int data;
	public Node next;
	public Node(int d, Node n){
		this.data = d;
		this.next = n;
	}
}


class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}




public class Test2 {
	public static void main(String[] args){
//		System.out.println(isPerm("abc", "bca"));
//		System.out.println(isPerm("abc", "ccb"));
//		char[] x = {'a','b', ' ', 'c', ' ', 'd', 'x', 'x', 'x', 'x'};
//        char[] a = replaceSpace(x, 6);
		//System.out.println();

	//	System.out.println(compress("aabbccc"));
		
	//	int[][] arr2 = rotate(arr);
//		int[][] arr = {
//				{1, 2, 3, 4},
//				{5, 0, 7, 8},
//				{9, 10,0, 2},
//				{3, 5, 6, 7}};
//		
//		int[][] ar = fillXZero(arr);
		
//		Node n6 = new Node(8,null);
//		Node n5 = new Node(6,n6);
//		Node n4 = new Node(3,n5);
//		Node n3 = new Node(5,n4);
//		Node n2 = new Node(3,n3);
//		Node n1 = new Node(4,n2);
//		Node n = partition(n1, 4);
//		System.out.println(n.data);

		
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode n = toBst(arr);
//							5		
//			2						7
//		1		3				6		8
//					4						9
		List<ArrayList<TreeNode>> l = levelOrder(n);

	
	
	}

	
	
	
	public static List<ArrayList<TreeNode>> levelOrder(TreeNode root){

		List<ArrayList<TreeNode>> list = new ArrayList<ArrayList<TreeNode>>();
		
		if(root == null){
			list.add(new ArrayList<TreeNode>());
			return list;
		}

		ArrayList<TreeNode> current = new ArrayList<>();
		current.add(root);
		
		while(current.size() > 0){
			list.add(current);
			List<TreeNode> parents = current;
			current = new ArrayList<>();
			
			for(TreeNode n : parents){
				if(n.left != null)
					current.add(n.left);
				if(n.right != null){
					current.add(n.right);
				}
			}
		}	
		return list;
	}
	
	//array to bst
	public static TreeNode toBst(int[] arr){
		return toBst(arr, 0, arr.length - 1);
	}

	private static TreeNode toBst(int[] arr, int start, int end){

		if(end < start)
			return null;

		int mid = (start + end ) / 2;
		return new TreeNode(arr[mid], 
				toBst(arr, start, mid - 1), 
				toBst(arr, mid + 1, end)
				);
	}


	
	public static Node partition(Node head, int v){

		Node lessList = null;
		Node lessListTail = null;
		Node moreList = null;
		Node moreListTail = null;
		
		Node current = head;
		
		while(current != null){
			if(current.data < v){
				if(lessList == null){
					lessList = new Node(current.data, null);
					lessListTail = lessList;
				}
				else{
					lessListTail.next = new Node(current.data, null);
					lessListTail = lessListTail.next;
				}
			}
			else{
				if(moreList == null){
					moreList = new Node(current.data, null);
					moreListTail = moreList;
				}
				else{
					moreListTail.next = new Node(current.data, null);
					moreListTail = moreListTail.next;
				}
			}
			current = current.next;
		}
		
		if(lessList == null)
			return moreList;
		
		lessListTail.next = moreList;
		return lessList;
	}

	
	
	//4 -> 3  -> 5  -> 3  -> 3  -> 8 -> null
	public static Node deleteNode(Node n){
		if(n == null || n.next == null){
			return null;
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return n;
	}

	
	
	//4 -> 3  -> 5  -> 3  -> 3  -> 8
	public static Node findKth(Node head, int k){
		Node current = head;
		Node runner = head;
		
		int i = 0;
		while(i < k){
			runner = runner.next;
			++i;
		}
		while(runner != null){
			runner = runner.next;
			current = current.next;
		}
		
		return current;
	}

	
	
	//4 -> 3  -> 5  -> 3  -> 3  -> 8 -> null	
	public static void removeDups2(Node head){
		Node current = head;
		Node runner = head;
		
		while(current.next != null){
			runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}	
			current = current.next;
		}
	}
	
	public static void removeDups(Node head){

	if(head == null)
		return;

	Map<Integer, Boolean> map = new HashMap();
	Node current = head;
	map.put(current.data, true);

	while(current.next != null){
		if(map.get(current.next.data) != null){
			current.next = current.next.next;
		}
		else{
			map.put(current.next.data, true);
			current = current.next;
		}
	}
	}
	
	
//	int[][] arr = {
//			{1, 2, 3, 4},
//			{5, 0, 7, 8},
//			{9, 10,0, 2},
//			{3, 5, 6, 7}};
	
	public static int[][] fillXZero(int[][] arr){
		boolean[] rows = new boolean[arr.length];
		boolean[] cols = new boolean[arr[0].length];
		
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				if(arr[row][col] == 0){
					rows[row] = true;
					cols[col] = true;
				}
			}
		}
		for(int row = 0; row < arr.length; row++){
			if(rows[row]){
				for(int col = 0; col < arr[row].length; col++){
					arr[row][col] = 0;
				}
			}
		}
		for(int col = 0; col < arr[0].length; col++){
			if(cols[col]){
				for(int row = 0; row < arr.length; row++){
					arr[row][col] = 0;
				}
			}
		}
		return arr;
	}
	

static int[][] arr = {
{1, 2, 3},
{4, 5, 6},
{7, 8, 9}};

public static int[][] rotate(int[][] arr){
	int n = arr.length;
	int layers = n /2;
	int layer = 0;

	while(layer < layers){
		int start = layer;
		int end = n - layer - 1;
		for(int i = 0; i < end - start; i++){
			int temp = arr[start][start + i];
			arr[start][start + i] = arr[end - i][start];
			arr[end - i][start] = arr[end][end - i];
			arr[end][end - i] = arr[start + i][end];
			arr[start + i][end] = temp; 
		}
		++layer;
	}
	return arr;
}
	
	public static char[] replaceSpace(char[] str, int strLen){

		int count = 0;
		for(int i = 0; i < strLen; i++){
			if(str[i] == ' ')
				count++;
		}

		int lastIndex = strLen + 2 * count ;
		for(int i = strLen - 1; i > 0; i--){
			if(str[i] == ' '){
				str[--lastIndex] = '0';
				str[--lastIndex] = '2';
				str[--lastIndex] = '%';
			}
			else{
				str[--lastIndex] = str[i];
			}
		}
		return str;
	}
	
	
	public static boolean isPerm(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() != str2.length()){
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str1.length(); i++){
			char c = str1.charAt(i);
			if(map.get(c) != null){
				int v = map.get(c);
				map.put(c, ++v);
			}
			else{
				map.put(c, 1);
			}
		}
		
		for(int i = 0; i < str2.length(); i++){
			char c = str2.charAt(i);
			if(map.get(c) == null || map.get(c) == 0){
				return false;
			}
			else{
				int v = map.get(c);
				map.put(c, --v);
			}
		}
		return true;
	}	
	
	public static String compress(String  str){
		
		char lastChar = str.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == lastChar){
				count++;
			}
			else{
				sb.append(lastChar);
				sb.append(count);
				count = 1;
				lastChar = str.charAt(i);
			}
			
		}
		sb.append(lastChar);
		sb.append(count);
		return sb.toString();
	}
	
	
	
	public static boolean isUnique(String str){
		if(str.length() > 256)
			return false;
			
		boolean[] vals = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(vals[c] == true)
				return false;
			else 
				vals[c] =  true;
		}

		return true;
	}
	
	public static boolean isUnique2(String str){
		
		if(str.length() > 256)
			return false;
		byte flags = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			byte m = (byte) (1 << c);
			if((flags & m) > 0){
				return false;
			}
			else{
				flags = (byte) (flags | m);
			}
		}
		
		return true;
		
	}
}




