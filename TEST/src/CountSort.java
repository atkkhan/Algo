import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CountSort {
	public static void main(String[] args){
		int[] arr = {8,8,8,8,9,9,9,9,9,10, 11,11,11,12,12};
		
		count(arr, 0, arr.length - 1);
		
		Set<Integer> keys = map.keySet();
		for(int key : keys){
			System.out.println(key + ": " + map.get(key));
		}
		
	}
	
	static Map map = new HashMap<Integer, Integer>();
	
	public static void count(int[] arr, int start, int end){
		if(start > end)
			return;
		
		if(arr[start] == arr[end]){
			if(map.get(arr[start]) != null){
				map.put(arr[start], (int)map.get(arr[start]) + end - start + 1);
			}
			else{
				map.put(arr[start], end - start + 1);
			}
		}
		else{		
			int mid = (start + end) / 2;
			count(arr, start, mid);
			count(arr, mid + 1, end);	
		}
	}
}
