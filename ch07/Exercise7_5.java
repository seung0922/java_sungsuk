package ch07;

class Product {
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수
	
	// 조상클래스인 Product 클래스에서 기본생성자 생성해야함
	Product() {}
	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv extends Product {
	// 반드시 생성자 첫줄에 다른 생성자 호출
	// 그렇지 않으면 컴파일러가 super(); 호출
	// 그런데 조상클래스인 Product에서 기본생성자가 없다
	// 그래서 기본생성자인 Product() {} 생성해줘야함
	Tv() {
	}
	
	public String toString() {
		return "Tv";
	}
}

class Exercise7_5 {
	public static void main(String[] args) {
		Tv t = new Tv();
	}
}