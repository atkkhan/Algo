package Hashtable;

public class FindMaxRow{


public static void main(String[] args){
	int[][] arr= {	{0,0,0,1},
				{0,0,1,1},
				{0,0,1,1},
				{0,1,1,1}};
	System.out.println(findMaxRow(arr));
}

public static int findMaxRow(int[][] arr){
	int maxRow = -1;
	int maxCount = -1;

	for(int row = 0; row < arr. length; ++row){

		int count = 0;
		for(int col = 0; col < arr[row].length; ++col){
			if(arr[row][col] == 0){
				count++;
			}
			else
				break;
		}
		count = arr[row].length - count;
		if(count > maxCount){
			maxCount = count;
			maxRow = row;
		}
	}

	return maxRow;
}
}
