package ch07;

// 공통부분을 뽑아서 Unit이라는 클래스를 만들고, 이 클래스를 상속받도록 변경
class Unit {
	int x, y;	// 현재 위치
	void move(int x, int y) { /* 지정된 위치로 이동 */ }
	void stop() 			{ /* 현재 위치에 정지 */ }
}

class Marine extends Unit { // 보병
	void stimPack() 		{ /* 스팀팩을 사용한다.*/}
}

class Tank extends Unit { // 탱크
	void changeMode() 		{ /* 공격모드를 변환한다. */}
}

class Dropship extends Unit { // 수송선
	void load() 			{ /* 선택된 대상을 태운다.*/ }
	void unload() 			{ /* 선택된 대상을 내린다.*/ }
}

public class Exercise7_17 {
	public static void main(String[] args) {
		
	}
}
