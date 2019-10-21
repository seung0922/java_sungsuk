package ch11;

import java.util.*;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // 총점
	int schoolRank; // 전교등수

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	// Q. 기본정렬 - 총점기준으로 내림차순 정렬하시오
	public int compareTo(Object o) {
		if(!(o instanceof Student))
			return -1;
		Student s = (Student)o;
		
		// 내림차순은 오름차순 반대로
		return (this.total > s.total ? -1 : (this.total < s.total ? 1 : 0));
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank // 새로추가
		;
	}
} // class Student

class Exercise11_8 {
	// 총점을 기준으로 각 학생의 전교등수를 계산하고 전교등수를 기준으로 오름차순 정렬하여 출력
	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		
		// prevRank를 -1로 해놓고 결과가 나올수있는 방법이 있을까
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		
		// 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		for(int i=0; i<length; i++) {
			Student s = (Student)list.get(i);
			
			//1.1 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다.
			if(s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				// 1.2 총점이 서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
				// 이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. (실행결과 참고)
				s.schoolRank = i + 1;
			}
			// 1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));
		
		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
	}
}