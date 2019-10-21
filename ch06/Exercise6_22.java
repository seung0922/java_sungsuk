package ch06;

class Exercise6_22 {
	//(1) isNumber메서드를 작성하시오.
	
	static boolean isNumber(String str) {
		// 주어진 문자열이 모두 숫자로만 이루어져 있는지 확인
		// 모두 숫자 -> true, 그렇지않으면 -> false
		// 주어진 문자열이 null 이거나 빈문자열 "" -> false
		boolean result = false;
		
		if(str==null || str=="") {
			result = false;
		} else {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)<'0' || str.charAt(i)>'9') {
					result = false;
					break;
				} else {
					result = true;
				}
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
	}
}