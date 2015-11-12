package Hashtable;

public class PrintSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[][] array = {
				{1, 2, 4, 5},
				{2, 3, 6, 7}, 
				{2, 3, 7, 8}, 
				{3, 4, 8, 9}};
		printSorted(array, array[0][0]);
	}

	public static void printSorted1(int[][] arr, int cv){

		int next = Integer.MAX_VALUE;
		if(cv != arr[arr.length -1][arr[0].length - 1]){
			int row = 0; int col = 0;
			while( row < arr.length && arr[row][col] <= cv){	
				while( col < arr[row].length && arr[row][col] <= cv){
					if(arr[row][col] == cv){
						System.out.println(arr[row][col]);
					}
					col++;
				}
				if(row <= arr.length -1 && col <= arr[row].length -1  && arr[row][col] > cv){
					next = Math.min(next, arr[row][col]);
				}
				col = 0;
				row++;
			}
			cv = next;
			next = Integer.MAX_VALUE;	
		}
		System.out.println(arr[arr.length -1][arr[0].length - 1]);
	}
	public static void printSorted(int[][] arr, int c){

		int next = Integer.MAX_VALUE;

		while(c != arr[arr.length -1][arr[0].length - 1]){
			int row = 0;
			int col = 0;
			while( row < arr.length && arr[row][col] <= c){	
				while( col < arr[row].length && arr[row][col] <= c){
					if(arr[row][col] == c)
						System.out.println(arr[row][col]);
						col++;
				}
				if(row <= arr.length -1 && col <= arr[row].length -1  && arr[row][col] > c){
					next = Math.min(next, arr[row][col]);
				}
				col = 0;
				row++;
			}
			c = next;
			next = Integer.MAX_VALUE;	
		}
		System.out.println(arr[arr.length -1][arr[0].length - 1]);
	} 
}
class Pos{
	public int row;
	public int col;
	public int val;
}
