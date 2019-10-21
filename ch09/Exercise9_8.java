package dd;

class Exercise9_8 {
	// 주어진 값을 반올림하여, 소수점 이하 n자리의 값을 반환
	// ex) n=3 이면, 소수점 4째 자리에서 반올림하여 소수점 이하 3자리 수 반환
	static double round(double d, int n) {
		// Math.round()와 Math.pow() 이용
		// Math.pow(밑, 지수) => 제곱함수
		// 1. 반올림 하기 위해 곱하고 나누기 위한 변수 생성 
		int m = (int) Math.pow(10, n);
		
		// 2. 주어진 값을 m으로 곱하여 round함수로 반올림해준다.
		d = d * m;
		d = Math.round(d);
		
		// 3. 반올림한 값을 다시 m으로 나눈다.
		d = d / m;
		
		return d;
	}

	public static void main(String[] args) {
		System.out.println(Math.round(3.1415));
		
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}