
public class PrintSorted {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] array = {
                {1, 2, 4, 5},
                {2, 3, 6, 7}, 
                {2, 3, 7, 8}, 
                {3, 4, 8, 9}};
        printSorted(array, array[0][0]);
     //   System.out.println(5/2);
    }
    
	public static void printSorted(int[][] ar, int i){
		int row = 0;
		int col = 1;
		int next = Integer.MAX_VALUE;
		
		System.out.println(i);
		while(row < ar.length && col < ar[0].length){
			
			while(col < ar.length && ar[row][col] < i){
				col++;
			}
			
			while(col < ar.length && i == ar[row][col] ){
				System.out.println(ar[row][col]);		
				if(row == ar.length - 1 && col == ar[0].length - 1)
					return;
				col++;
			}
			if(next == i && col < ar.length)
				next = ar[row][col];
			else if( col < ar.length)
				next = Math.min(next, ar[row][col]);
			
			if(row+1 < ar.length && ar[row+1][0] <= i){
				row++;
				col = 0;
			}
			else {
				if(row+1 < ar.length)
					next = Math.min(next, ar[row + 1][0]);
				i = next;

				row = 0;
				col = 0;
				
			}
		}
		
	}
}
