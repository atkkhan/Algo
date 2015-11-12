

public class ArrRotate {
	
	private static int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args){
		
		arr = rotate90(arr);
		System.out.println(arr);
	}
	
	
	
	public static int[][] rotate90(int[][] ar){
		int n = ar.length - 1;
		int layers = n/2;
		int layer = 0;
		
		while(layer < layers){
		
			for(int i = layer; i < n - layer; ++i){
				int tmp = ar[layer][i];
				ar[layer][i] = ar[n - i][layer];
				ar[n - i][layer] = ar[n - layer][n - i];
				ar[n - layer][n - i] = ar[i][n - layer];
				ar[i][n - layer] = tmp;
			}
			++layer;
		}
		return ar;

	}
	
	public static void rotate(int[][] arr){
		int layers = arr.length / 2;
		for(int layer = 0; layer < layers; ++layer){
			int row = layer;
			int col = layer;
			int temp = arr[layer][layer];
			for(row = layer + 1; row < arr.length - layer; ++row){
				arr[row - 1][col] = arr[row][col];
			}
			
			row = arr.length - layer - 1;	
			for(col = layer + 1; col < arr.length - layer; ++col){
				arr[row][col - 1] = arr[row][col];
			}
			
			col = arr.length - layer - 1;
			for(row = arr.length - layer - 2; row >= layer; --row){
				arr[row + 1][col] = arr[row][col];
			}	
			
			row = layer;	
			for(col = arr.length - layer - 2; col > layer; --col){
				arr[row][col + 1] = arr[row][col];
			}
			
			arr[layer][layer + 1] = temp;
			
		}
	}
}
