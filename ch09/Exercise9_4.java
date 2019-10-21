class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		// 주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력
		// 1. dataArr의 값을 하나씩 읽는다.
		for(int i=0; i<dataArr.length; i++) {
			// 2. 읽은 숫자만큼 ch를 출력한다.
			for(int j=0; j<dataArr[i]; j++) {
				System.out.print(ch);
			}
			System.out.println(dataArr[i]);
		}

	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
	}
}
