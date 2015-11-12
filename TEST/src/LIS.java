
public class LIS {

	public static int[] LIS(int x[]){
		int parent[] =  new int[x.length];
		int increasingSub[] = new int[x.length];
		int length = 0;
		
		for(int i = 0; i < x.length; i++){
			int low = 1;
			int high = length;
			
			//binary search
			while(low <= high){
				int mid = (int) Math.ceil((low + high)/2);
				
				if(x[increasingSub[mid]] < x[i])
					low = mid + 1;
				else
					high = mid - 1;
			}
			
			int pos = low;
			//udate parent/previous element for LIS
			parent[i] = increasingSub[pos -1];
			//replace or append
			increasingSub[pos] = i;
			
			//Update the length of the longest subsequence
			if(pos > length)
				length = pos;
		}
		
		int LIS[] = new int[length];
		int k = increasingSub[length];
		for(int j = length -1 ; j >= 0; j--){
			LIS[j] = x[k];
			k = parent[k];
		}
		return LIS;
	}
	
	public static void main (String[] args){
		
		int[] a = {3, 2, 5, 1, 6, 7};
		LIS(a);
	}
}
