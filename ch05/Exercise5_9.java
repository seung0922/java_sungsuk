package ch05;

public class Exercise5_9 {

	public static void main(String[] args) {
		char[][] star = { 
				{ '*', '*', ' ', ' ', ' ' }, 
				{ '*', '*', ' ', ' ', ' ' }, 
				{ '*', '*', '*', '*', '*' },
				{ '*', '*', '*', '*', '*' } 
		};

		char[][] result = new char[star[0].length][star.length];
		
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				// 그림을 그려보면 star[][]의 이차원배열인 j순서는 result의 첫번째 배열 순서와 같다
				// star[0][] -> result[][3]
				// star[1][] -> result[][2]
				// star[2][] -> result[][1]
				// star[3][] -> result[][0]
				result[j][3-i] = star[i][j];
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

	}

}
