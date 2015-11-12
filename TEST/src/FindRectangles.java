import java.util.ArrayList;
import java.util.List;

class Point{
	public int x;
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")"; 
	}
}
class Rectangle{
	
    Point leftTop = null;
    Point rightTop = null;
    Point leftBottom = null;
    Point rightBottom = null;
    
    public Rectangle(Point leftTop, Point rightTop, Point leftBottom, Point rightBottom){
    	this.leftTop = leftTop;
    	this.rightBottom = rightBottom;
    	this.rightTop = rightTop;
    	this.leftBottom = leftBottom;
    }
    
    public boolean isInRectangle(Point p){
    	if((p.x >= leftTop.x && p.x <= rightTop.x) 
    		&& (p.y <= leftBottom.y && p.y >= leftTop.y ))
    		return true;
    	else 
    		return false;
    	
    }
    
    public String toString(){
    	return "top left: " + leftTop.toString() 
    			+ " top right: " + rightTop.toString() 
    			+ " left bottom: " + leftBottom.toString()
    			+ " right bottom: " + rightBottom.toString();
    }
}

public class FindRectangles {
	public static int[][] image = {
	             {1, 1, 1, 1, 1, 1, 1},
	             {1, 1, 1, 1, 1, 1, 1},
	             {1, 1, 1, 0, 0, 0, 0},
	             {1, 0, 1, 0, 0, 0, 0},
	             {1, 0, 1, 1, 1, 1, 1},
	             {1, 0, 1, 0, 0, 1, 1},
	             {1, 1, 1, 0, 0, 1, 1},
	             {1, 1, 1, 1, 1, 1, 1},
	             };
	
	public static void main(String[] args){
		List<Rectangle> rects = findRectangle(image); 
		for(Rectangle r : rects){
			System.out.println(r.toString());
		}
		
	}
	
	public static List<Rectangle> findRectangle(int[][] arr){

	    List<Rectangle> rectangles = new ArrayList<>();
	    
	    for(int row = 0; row < arr.length; ++row){
	    	for(int col = 0; col < arr[row].length; ++col){
	    		if(arr[row][col] == 0 && !isNewRectangle(new Point(col, row), rectangles)){
	    		    Point leftTop = null;
	    		    Point rightTop = null;
	    		    Point leftBottom = null;
	    		    Point rightBottom = null;
	    		    
	    			leftTop = new Point(col, row);
	    			while(col < arr[row].length){
	    				if(arr[row][col] == 1){
	    					break;
	    				}
	    				++col;
	    			}
					rightTop = new Point(--col, row);	
					
					while(row < arr.length){
						if(arr[row][col] == 1){
							break;
						}
						++row;
					}
					rightBottom = new Point(col, --row);
					leftBottom = new Point(leftTop.x, rightBottom.y);
					rectangles.add(new Rectangle(leftTop, rightTop, leftBottom, rightBottom));
					
					row = rightTop.y;
					col = rightTop.x;
	    		}
	    	}
	    }
	    
		return rectangles;
	}
	
	private static boolean isNewRectangle(Point p, List<Rectangle> rects){		
		for(Rectangle r : rects){
			if(r.isInRectangle(p))
				return true;
		}
		return false;
	}
}
