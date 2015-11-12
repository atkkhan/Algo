
public class Distance {
	public static void main(String[] str){
		System.out.println(findDistance(1,3, 4,3));
	}
	
	public static double findDistance(double x1, double y1, double x2, double y2){
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
