package Hashtable;

public class PrintSpiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean findElement(int[][] matrix, int elem){
		int row = 0;
		int col = matrix[0].length - 1;
		
		while(row < matrix.length && col >= 0){
			if(matrix[row][col] == elem){
				return true;
			}
			else if(matrix[row][col] > elem){
				col--;
			}
			else{
				row++;
			}
		}
		return false;
	}
}
