package ch1;

public class SetZeros {
	public static void main(String args[]) {
		int[][] matrix = {{1,0,1},{1,1,1},{1,1,1}};
		SetZeros.printMatrix(matrix);
		SetZeros.printMatrix(SetZeros.setZeros(matrix));
	}
	
	public static int[][] setZeros(int[][] matrix){
		System.out.println("Setting zeros...");
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; ++i){
	          for(int j = 0; j < matrix[0].length; ++j){
	            if(matrix[i][j] == 0){
	            	rows[i] = true;
	            	cols[j] = true;
	            }       
	          }
	     }
		
		
		for(int r = 0; r < rows.length; r++){
			if(rows[r] == true){
				for(int c = 0; c < matrix[r].length; ++c){
					matrix[r][c] = 0;
				}
			}
		}
		
		for(int c = 0; c < cols.length; c++){
			if(cols[c] == true){
				for(int r = 0; r < matrix.length; ++r){
					matrix[r][c] = 0;
				}
			}
		}
		return matrix;
	}
	
	 public static void printMatrix(int[][] matrix){
	      System.out.println("print matrix\n--------------------");
	      
	      for(int i = 0; i < matrix.length; ++i){
	          for(int j = 0; j < matrix[0].length; ++j){
	            System.out.print(matrix[i][j]);       
	          }
	          System.out.println("");
	      }
          System.out.println("-----------------------");
	  }
}
