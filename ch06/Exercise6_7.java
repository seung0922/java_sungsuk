package ch06;

class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int x1, int y1) {
		// a = x2 - x1
		// b = y2 = y1
		// c = Math.sqrt(a*a+b*b)
		int a = x1 - x;
		int b = y1 - y;
		double result = Math.sqrt(a*a+b*b);
		return result;
		// return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
}

public class Exercise6_7 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		// p와 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2,2));
	}
	
}