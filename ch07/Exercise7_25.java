package ch07;

class Outer {
	class Inner {
		int iv = 100;
	}
}

class Exercise7_25 {
	public static void main(String[] args) {
		// Outer 클래스의 내부 클래스 Inner의 멤버벼수 iv의 값을 출력하시오.
		Outer o = new Outer();
		Outer.Inner oi = o.new Inner();
		System.out.println(oi.iv);
		
	}
}