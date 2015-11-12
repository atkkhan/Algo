package Hashtable;

public class MoveToLeft {

	public static void main(String[] args){
		
		int[] arr = {2, 3, 0, 0, 4, 5, 0};
		
		moveToLeft(arr);
	}
	public static int[] moveToLeft(int[] arr){
		int lastIndexOfZero = arr.length;
		
		for(int i = 0; i < lastIndexOfZero; ++i){
			if(arr[i] == 0){
				while(arr[--lastIndexOfZero] == 0){}
				arr[i] = arr[lastIndexOfZero];
				arr[lastIndexOfZero] = 0;
			}
		}
		return arr;
	}
}
