package ch13;

import java.util.Scanner;
import java.util.Vector;

class Exercise13_8 {
	Vector words = new Vector();
	String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };
	int interval = 2 * 1000; // 2초
	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) {
		Exercise13_9 game = new Exercise13_9();
		game.wg.start();
		Vector words = game.words;

		while (true) {
			System.out.println(words);
			String prompt = ">>";
			System.out.print(prompt);

			// 화면으로부터 라인단위로 입력받는다.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = words.indexOf(input);

			if (index != -1) {
				words.remove(index);
			}
		}
	} // main

	class WordGenerator extends Thread {
		public void run() {
			// 1. interval(2초)마다 배열 data의 값 중 하나를 임의로 선택해서
			// 2. words에 저장한다.
			for(int i=0; i<data.length; i++) {
				int r = (int)(Math.random()*data.length);
				
				words.add(data[r]);
				
				try {
					Thread.sleep(interval);
				} catch(Exception e) {}
			}
			
		} // end of run()
	} // class WordGenerator
} // Exercise13_9