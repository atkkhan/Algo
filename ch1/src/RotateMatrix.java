public class RotateMatrix {

  public static void main(String args[]) {
      int[][] matrix = {
    		  {1,2, 3,11},
    		  {4,5, 6,12}, 
    		  {7,8,9,13},
    		  {22,23,24,25}
    		  };
      int n = 4;
      RotateMatrix.printMatrix(matrix, n);
      RotateMatrix.printMatrix(RotateMatrix.rotate(matrix, n), n);
  }
  
  public static int[][] rotate(int[][] matrix, int n){
      System.out.println("rotate matrix");
      for(int layer = 0; layer < n/2; layer++){
        int first = layer;
        int last = n - 1 - layer;
        for(int i = first; i < last; i++){
            int offset = i - first;
            
            int top = matrix[first][i];
            matrix[first][i] = matrix[last - offset][first];
            matrix[last - offset][first] = matrix[last][last - offset];
            matrix[last][last - offset] = matrix[i][last];
            matrix[i][last] = top;
        } 
      }
      return matrix;
  }
  
  
  public static void printMatrix(int[][] matrix, int n){
      System.out.println("print matrix");
      
      for(int i = 0; i < n; ++i){
          for(int j = 0; j < n; ++j){
            System.out.print(matrix[i][j]);       
          }
          System.out.print("\n");
      }
  }
}