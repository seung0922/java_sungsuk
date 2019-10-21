package dd;

class Exercise9_9 {
	// 주어진 문자열에서 금지된 문자들을 제거하여 반환하는 함수
	static String delChar(String src, String delCh) {
		// StringBuffer와 CharAt(int i), indexOf(int ch) 사용
		// 1. 금지된 문자들을 제거한 문자열을 저장할 StringBuffer 생성
		// 2. src을 delCh과 하나씩 비교하여 src에 delCh가 있는지 확인
		// 있으면, 넘어가고
		// 없으면, StringBuffer에 삽입
		
		return "";
	}

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
	}
}