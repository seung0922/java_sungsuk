package ch07;

// Shape 클래스를 조상으로 하는 Circle 클래스와 Rectangle 클래스 작성
class Circle extends Shape {
	double r;
	
	Circle() {	// 기본생성자
		this(0.0);
	}
	Circle(double r) {
		this.r = r;
	}
	
	double calcArea() {	// 도형의 면적 계산하여 반환
		return Math.PI * r * r;
	}
}

class Rectangle extends Shape {
	double width;
	double height;
	
	Rectangle() {	// 기본생성자
		this(0.0, 0.0);
	}
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	double calcArea() {	// 도형의 면적 계산하여 반환
		return width * height;
	}
	
	boolean isSquare() {	// 정사각형인지 아닌지
		return width == height;
	}
}

abstract class Shape {	// 도형을 정의
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0, 0);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

class Exercise7_23 {
	// 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
	static double sumArea(Shape[] arr) {
		double sum = 0.0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i].calcArea();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println("면적의 합 : " + sumArea(arr));
	}
}