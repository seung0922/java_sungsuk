

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exercise13_1 extends Frame {

	Button[][] btArr = new Button[5][5];	// 버튼 배열
	int[][] bingoArr = new int[5][5];	// 눌려진 버튼 저장하기 위한 빙고 배열
	
	Exercise13_1(String title) {
		super(title);
		setSize(300, 300);
		setLayout(new GridLayout(5, 5));

		// 1. 가로, 세로 크기가 5인 빙고판을 만드시오.
		// 버튼 배열 만들고 프레임에 버튼배열 추가
		for (int i = 0; i < btArr.length; i++) {
			for (int j = 0; j < btArr[i].length; j++) {
				btArr[i][j] = new Button("새" + (i * 5 + j + 1));
				add(btArr[i][j]);
				EventHandler handle = new EventHandler();
				btArr[i][j].addActionListener(handle);
			}
		}
		
		addWindowListener(new EventHandler());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Exercise13_1 ex = new Exercise13_1("Bingo game");
		
	}
	
	int bingoCheck(int[][] arr) {	// 빙고가 몇개있는지 세기위한 메서드
		int result = 0;
		int cntW = 0; // 가로 카운트
		int cntH = 0; // 세로 카운트
		int cntDiagR = 0; // 오른쪽방향 대각선 카운트
		int cntDiagL = 0; // 왼쪽방향 대각선 카운트
		
		for (int i = 0; i < arr.length; i++) {
			cntW = 0; // 가로 카운트 초기화
			cntH = 0; // 세로 카운트 초기화
			
			for (int j = 0; j < arr[i].length; j++) {
				// 가로
				if (arr[i][j] == 1) cntW++;
				
				// 세로
				if (arr[j][i] == 1) cntH++;
				
				// 오른쪽 대각선
				if (arr[i][j] == 1 && i == j) cntDiagR++;
				
				// 왼쪽 대각선
				if (arr[i][j] == 1 && i + j == 4) cntDiagL++;
				
			}
			// 가로 빙고
			if (cntW == 5) result++;
			
			// 세로 빙고
			if (cntH == 5) result++;
			
			// 오른쪽 방향 대각선 빙고
			if (cntDiagR == 5) result++;
			
			// 왼쪽 방향 대각선 빙고
			if (cntDiagL == 5) result++;
		}
		return result;
	}

	class EventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			// 2. 버튼을 누르면, 버튼의 배경색이 밝은 회색(Color.LIGHT_GRAY)로 바뀌고
			Button b = (Button) ae.getSource();
			b.setBackground(Color.LIGHT_GRAY);

			// 누른 버튼의 글자가 콘솔에 출력되게 하시오. -> 단순하게 생각!!
			// 콘솔에 출력되게 하는 것은 System.out.println(); 사용!
			// 버튼 이름을 가져오는 방법?
			System.out.println(b.getLabel());

			// 누른 버튼 b의 값이 btArr의 해당위치에 있으면 bingoArr의 해당위치에 1넣음
			for (int i = 0; i < btArr.length; i++) {
				for (int j = 0; j < btArr[i].length; j++) {
					if (btArr[i][j] == b) {
						bingoArr[i][j] = 1;
						break;
					}
				}
			}
			
			// bingo 개수 반환
			// bingo가 +1 되는 순간만 출력할순없을까?
			System.out.println("빙고개수 = " + bingoCheck(bingoArr));
		} // public void actionPerformed(ActionEvent ae) {
		
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
		
	} // EventHandler 메서드
		
}