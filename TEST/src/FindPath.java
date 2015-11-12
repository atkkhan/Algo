
public class FindPath {
	
	public static int[][] arr = {
		{0, 0, 1, 0, 1}, 
		{0, 0, 0, 0, 0},
		{1, 0, 1, 1, 1},
		{0, 0, 0, 0, 0}
		};
	public static boolean[][] visited = new boolean[arr.length][arr[0].length];
//	0,0,0
//	0,0,0
//	0,0,0
	
	public static void  main(String[] args){
		System.out.println(findPath(4, 1, 3, 2));
	}
	
	public static boolean findPath(int x, int y, int ex, int ey){
		if(x == ex && y == ey){
			return true;
		}
		visited[y][x] = true;
		boolean rtn = false;
		if(x < arr[0].length - 1 && arr[y][x + 1] != 1 && visited[y][x + 1] != true){
			rtn = findPath(x + 1, y, ex, ey);
		}
		if(rtn != true && x != 0 && arr[y][x - 1] != 1 && visited[y][x - 1] != true){
			rtn = findPath(x - 1, y, ex, ey);
		}
	
		if(rtn != true && y < arr.length - 1 && arr[y + 1][x] != 1 && visited[y + 1][x ] != true){
			rtn = findPath(x, y + 1, ex, ey);
		}

		if(rtn != true && y != 0 && arr[y - 1][x] != 1 && visited[y - 1][x] != true){
			rtn = findPath(x, y - 1, ex, ey);
		}
		return rtn;
	}
}
