public class BubbleSort {
	
	void bubbleSort(int a[], int n){
		for(int pass = n -1; pass >= 0; pass--){
			for(int i = 0; i < pass; i++){
				if(a[i] > a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
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
		
		BubbleSort b = new BubbleSort();
		
		b.printArray(a);
		b.bubbleSort(a, a.length);
		b.printArray(a);
	}
	
}
