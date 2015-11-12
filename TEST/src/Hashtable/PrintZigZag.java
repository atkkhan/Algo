package Hashtable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class bTree{
	bTree left;
	bTree right;
	int data;
	public bTree(int data, bTree left, bTree right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}


public class PrintZigZag {
	public static void main(String[] args){
		
		bTree r = new bTree(1, 
				new bTree(2, new bTree(4, new bTree(8, null, null), new bTree(9, null, null)), new bTree(5, null, null)), 
				   new bTree(3, new bTree(6, null, null), new bTree(7, null,null)));
		
		printZigZag(r);
	}
	
	public static void printZigZag(bTree root){
		Queue<bTree> q = new LinkedList<bTree>(); 
		q.add(root);
		q.add(null);
		int level = 0;
		Stack<bTree> s = new Stack<bTree>();
		
		
	//	while(current != null)
		while(!q.isEmpty()){
			
			bTree current = q.remove();
			if(current == null){
				if(q.size() == 0)
					break;
				q.add(null);
				level++;
				while(!s.isEmpty()){
					System.out.print(s.pop().data + ", ");
				}
				System.out.println("\n");
				
				s = new Stack<bTree>();
			}
			else{
				if(level % 2 != 0){
					System.out.print(current.data + "-");
					if(current.left != null)
						q.add(current.left);
					if(current.right != null)
						q.add(current.right);
				}
				else{
					if(current.left != null)
						q.add(current.left);
					if(current.right != null)
						q.add(current.right);
					s.add(current);
				}
			}
		}		
	}
}
