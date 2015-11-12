package roblox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1 {
 
	
    public static void main(String[] args){
    
    	List<Integer> l1 = new ArrayList<>();
    	l1.add(-2);
    	l1.add(3);
    	l1.add(-4);
    	l1.add(-1);
    	l1.add(1);
    	
    	System.out.println(list1(l1));
    }
   
	public static int list1(List<Integer> list)
    {        
		int i = 0;
		int j = 1;
		int k = 2;
		
		int max = 0;
		
		while(k < list.size()){
			int m = k;
			while(m < list.size()){
				int p = list.get(m++) * list.get(i) * list.get(j);
				max = Math.max(max, p);
			}
			i++; j++; k++;
		}
		return max;
    }
}





