package ch11;

import java.util.*;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // 전교등수
	int classRank; // 반등수

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

	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student tmp = (Student) o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank + "," + classRank // 새로추가
		;
	}
} // class Student

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		// 반별 총점기준 내림차순 정렬
		if(!(o1 instanceof Student || o2 instanceof Student))
			return -1;
		
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		// 반별로 나눠서 정렬함
		if(s1.ban > s2.ban) {
			return 1;
		} else if(s1.ban < s2.ban) {
			return -1;
		} else {
			return s1.total > s2.total ? -1 : (s1.total < s2.total ? 1 : 0);
		}
		
		
	}
}

class Exercise11_9 {
	public static void calculateClassRank(List list) {
// 먼저 반별 총점기준 내림차순으로 정렬한다.
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		// 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다. 
		for(int i=0, n=0; i<length; i++, n++) {
			Student s = (Student)list.get(i);
			// 1.1 반이 달라지면,(ban과 prevBan이 다르면)
			// 이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화한다. 
			if(s.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				n = 0;	// 반별 등수 저장하기위한 변수
			}
			
			// 1.2 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(classRank)로 한다. 
			if(s.total == prevTotal) {
				s.classRank = prevRank;
			} else {
				// 1.3 총점이 서로 다르면, 등수(classRank)의 값을 알맞게 계산해서 저장한다.
				// 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야한다. (실행결과 참고) 
				s.classRank = n + 1;
			}
			// 1.4 현재 반과 총점과 등수를 이전 반(prevBan), 이전 총점(prevTotal), 이전등수(prevRank)에 저장
			prevBan = s.ban;
			prevTotal = s.total;
			prevRank = s.classRank;
		}
		
	} // public static void calculateClassRank(List list) {

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.

		// prevRank를 -1로 해놓고 결과가 나올수있는 방법이 있을까
		int prevRank = 0; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();

		// 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		for (int i = 0; i < length; i++) {
			Student s = (Student) list.get(i);

			// 1.1 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다.
			if (s.total == prevTotal) {
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
		calculateClassRank(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}