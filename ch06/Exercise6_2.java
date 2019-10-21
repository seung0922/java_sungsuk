package ch06;

public class Exercise6_2 {
	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
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
	
	String info() {
		String result = "";
		if(isKwang==true) {
			result = num + "K";
		} else {
			result = num + "";
		}
		return result;
		
		// 위의 내용을 간단하게 한줄로 표현가능
//		String info() {
//			return num + (isKwang? "K" : "");
//		}		
	}
}