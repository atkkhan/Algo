
public class RotateArray {
	public static void main(String[] args){
		int[] arr = {0,1,2,3,4,6,7};
		int r = 4;
		arr = rotateArr(arr, r);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ",");
	}
	
	public static int[] rotateArr(int[] arr, int r){
		if(arr.length < 2 || r % arr.length == 0)
			return arr;
		
		int move, temp, from = 0, to, i =0;
		move = arr[from];
		while(i < arr.length){
			to = (from + r) % arr.length;
			
			temp = arr[to];
			arr[to] = move;
			
			move = temp;
			from = to;
			++i;
			
		}
		return arr;
	}
}
