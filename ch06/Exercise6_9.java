package ch06;

/*[6-9] 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버
중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
(단, 모든 병사의 공격력과 방어력은 같아야 한다.)
*/

// weapon, armor, weaponUp(), armorUp()
// 클래스 변수는 모든 객체의 공통사항이고 두개의 메서드는 클래스변수를 조정하는 메서드이므로.
// 클래스 변수 : 같은 클래스의 모든 인스턴스들이 공유하는 변수

class Marine {
	int x=0, y=0; // Marine의 위치좌표(x,y)
	int hp = 60; // 현재 체력
	int weapon = 6; // 공격력
	int armor = 0; // 방어력
	
	void weaponUp() {
		weapon++;
	}
	
	void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}