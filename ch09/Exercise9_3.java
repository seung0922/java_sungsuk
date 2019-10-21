package ch09;

class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		// 1. fullPath 끝에서부터 찾아 "//"있는 위치 반환
		int idx = 0;
		idx = fullPath.lastIndexOf("\\");
		
		// 2. 처음부터 "//" 있는 자리의 앞까지 path에 저장
		path = fullPath.substring(0, idx);
		
		// 3. "//" 있는 곳 다음부터 끝까지 fileName에 저장
		fileName = fullPath.substring(idx+1);
		
		System.out.println("fullPath:" + fullPath);
		System.out.println("path:" + path);
		System.out.println("fileName:" + fileName);
	}
}