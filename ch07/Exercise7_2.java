package ch07;

// 섯다카드 20장을 포함하는 섯다카드 산 벌을 정의한 것이다.
// 섯다카드 20장을 담는 SutaCard배열을 초기화하시오
// 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고
// 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광이어야 한다.

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		int i = 0;
		for (int n = 1; n <= CARD_NUM; n++) {
			if (n <= 10) { // 1~10
				if (n == 1 || n == 3 || n == 8) { // 숫자가 1, 3, 8인 경우 광
					cards[i++] = new SutdaCard(n, true);
				} else { // 그렇지 않으면 광 x
					cards[i++] = new SutdaCard(n, false);
				}
			} else { // 10 초과면 -10 해줘서 1~10되도록 만듦
				cards[i++] = new SutdaCard(n - 10, false);
			}
		}
	}

	// Q7-2-1) 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
	void shuffle() {
			// cards의 첫번째 인덱스부터 반복
			// 1. 첫번째 위치의 값을 tmp에 넣음
			// 2. 랜덤한 위치의 값을 첫번째 위치에 넣음
			// 3. tmp의 값을 랜덤한 위치에 넣음
			for (int i=0; i<cards.length; i++) {
				int x = (int)(Math.random()*cards.length);
				SutdaCard tmp;
				
				tmp = cards[i];
				cards[i] = cards[x];
				cards[x] = tmp;
			}
		}

	// Q7-2-2) 배열 cards에 지정된 위치의 SutdaCard를 반환
	SutdaCard pick(int index) {
		return cards[index];
	}

	// Q7-2-3) 배열 cards에서 임의의 위치의 SutdaCard를 반환 (Math.random() 사용)
	SutdaCard pick() {
		int x = (int)(Math.random()*cards.length);
		return cards[x];
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info() 대신 Object클래스의 toString()을 오버라이딩
	public String toString() {
		return num + (isKwang ? "K" : "");
	}

}

public class Exercise7_2 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
		
		System.out.println();
		System.out.println(deck.pick(0));
	}
}
