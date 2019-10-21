package ch06;

public class Exercise6_6 {
	// 두 점 (x,y)와 (x1, y1)간의 거리를 구한다.
	// a = x2 - x1
	// b = y2 = y1
	// c = Math.sqrt(a*a+b*b)
	static double getDistance(int x, int y, int x1, int y1) {
		int a = x1 - x;
		int b = y1 - y;
		double result = Math.sqrt(a*a+b*b);
		return result;
		// return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}
	
}