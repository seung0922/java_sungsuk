package ch07;

class Outer {
	int value = 10;

	class Inner {
		int value = 20;

		void method1() {
			int value = 30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(new Outer().value);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

class Exercise7_27 {
	public static void main(String args[]) {
		Outer o = new Outer();
		Outer.Inner inner = o.new Inner();
		inner.method1();
		System.out.println(0%10);
	}
}