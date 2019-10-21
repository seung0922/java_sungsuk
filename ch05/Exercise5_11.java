package ch05;

public class Exercise5_11 {

	public static void main(String[] args) {
		int[][] score = { 
				{ 100, 100, 100 }, 
				{ 20, 20, 20 }, 
				{ 30, 30, 30 }, 
				{ 40, 40, 40 }, 
				{ 50, 50, 50 } 
			};
		int[][] result = new int[score.length + 1][score[0].length + 1];
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				// result에 score의 값 저장
				result[i][j] = score[i][j];
				// 행의 총합
				result[i][3] += score[i][j];
				//열의 총합
				result[5][j] += score[i][j];
				// 마지막요소 총합
				result[5][3] += result[i][j];
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}

	}

}
