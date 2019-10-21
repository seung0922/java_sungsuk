package ch11;

import java.util.*;

class Student implements Comparable {
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

	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}

	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student tmp = (Student) o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
} // class Student

class Exercise11_6 {
//	 해당 범위에 속한 학생의 수를 반환하는 메서드
//	 TreeSet의 subSet(Object from, Object to)이용
	static int getGroupCount(TreeSet tset, int from, int to) {
		// subSet() 매개변수에는 Student객체들어가야한다.
		Student s1 = new Student("", 0, 0, from, from, from);
		Student s2 = new Student("", 0, 0, to, to, to);
		
		return tset.subSet(s1, s2).size();
		
	}

	public static void main(String[] args) {
		// Q. TreeSet이 학생들의 평균을 기준으로 정렬
		// getAverage()를 비교
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if(!(o1 instanceof Student || o2 instanceof Student))
					return -1;
				Student s1 = (Student)o1;
				Student s2 = (Student)o2;
//				if(s1.getAverage() > s2.getAverage())
//					return 1;
//				else if(s1.getAverage() < s2.getAverage())
//					return -1;
//				else
//					return 0;
				// s1과 s2의 average는 float형인데 반환이 int형임
				return (s1.getAverage() > s2.getAverage() ? 1 : (s1.getAverage() < s2.getAverage() ? -1 : 0));
			}
		});
		
		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("김자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("안자바", 1, 5, 60, 100, 80));
		
		Iterator it = set.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println();
		
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}