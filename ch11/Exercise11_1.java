package ch11;

import java.util.*;

// 정수집합 1,2,3,4와 3,4,5,6의 교집합, 차집합, 합집합을 구하는 코드
class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // 교집합
		ArrayList cha = new ArrayList(); // 차집합
		ArrayList hap = new ArrayList(); // 합집합
		
		// list1 = { 1, 2, 3, 4 }
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		// list2 = { 3, 4, 5, 6 }
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		// ArrayList클래스의 addAll() - 주어진 컬렉션 모두 저장
		// removeAll() - 지정 컬렉션에 저장된 것과 동일한 객체들 제거
		// retianAll() - 주어진 컬렉션과 공통된 것들만 남기고 제거
		
		// 1. 교집합 - list1과 list2의 공통된 값
		kyo.addAll(list1);
		kyo.retainAll(list2);
		
		// 2. 차집합 - (list1 + list2) - list2
		cha.addAll(list1);
		cha.removeAll(list2);
		
		// 3. 합집합 - list1과 list2의 모든값 (중복x)
		hap.addAll(cha);
		hap.addAll(list2);
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}