
public class SelectionSort {
	public void sort(int a[], int n){
		int i, j, min, temp;
		for(i = 0; i < n - 1; i++){
			min = i;
			for(j = i + 1;  j < n; j++){
				if(a[j] < a[min])
					min = j;
			}
			temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}

	void printArray(int[] a){
		for(int i : a){
			System.out.print(i + ",");
		}
		System.out.println("");
	}
	

	public static void main(String[] args) {
		int[] a = {6,3,11,7,43,44,8,3,22,92,33,6};
	
		
		SelectionSort sort = new SelectionSort();
		
		sort.printArray(a);
		sort.sort(a, a.length);
		sort.printArray(a);
	}

}
