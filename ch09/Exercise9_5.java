package dd;

class Exercise9_5 {
	public static int count(String src, String target) {
		int count = 0; // 찾은 횟수
		int pos = 0; // 찾기 시작할 위치
		
		//반복문을 사용해서 아래의 과정을 반복한다.
		boolean b = true;
		while(b) {
			//1. src에서 target을 pos의 위치부터 찾는다.
			int idx = src.indexOf(target, pos); 
			if(idx != -1) {
				//2. 찾으면 count의 값을 1 증가 시키고,
				count++;
				//pos의 값을 target.length만큼 증가시킨다.
				pos = idx;
				pos += target.length();
			} else {
				//3. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
				b = false;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}
}