package ch06;

public class Exercise6_5 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		
		System.out.println(s.info());
	}
	
}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	String info() {
		String result = name + ", " + ban + ", " + no + ", " + kor+ ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
		return result;
	}
	
	int getTotal() {
		int result = kor + eng + math;
		return result;
	}
	
	float getAverage() {
//		int total = kor + eng + math;
		// 반올림 어떻게??
		float average = (float)(Math.round((float)getTotal()/3*10))/10;
		return average;
	}
	
}