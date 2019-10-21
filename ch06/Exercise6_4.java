package ch06;

public class Exercise6_4 {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름: " + s.name);
		System.out.println("총점: " + s.getTotal());
		System.out.println("평균: " + s.getAverage());
	}
	
}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int getTotal() {
		int result = kor + eng + math;
		return result;
	}
	
	float getAverage() {
		//int total = kor + eng + math;
		// 반올림 어떻게??
		float average = (float)(Math.round((float)getTotal/3*10))/10;
		// (int)(getTotal() / 3f * 10 + 0.5f) / 10f; 도 반올림	
		return average;
	}
	
}