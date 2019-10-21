package ch06;

class Exercise6_20 {
	static int[] shuffle(int[] arr) {
		// 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞음
		for(int i=0; i<arr.length; i++) {
			int x = (int)(Math.random()*arr.length);	// 꼭 괄호하기!
			int tmp = arr[i];
			arr[i] = arr[x];
			arr[x] = tmp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}