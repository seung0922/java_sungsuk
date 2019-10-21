package ch15;

import java.io.*;

// 커맨드라인으로 부터 파일명과 숫자를 입력받아서
// 입력받은 파일의 내용의 처음부터 입력받은 숫자만큼의 라인을 출력
// (BufferedReader의 readLine() 사용)

public class FileHead {
	public static void main(String[] args) {
		// 입력요소는 1.파일명 2.숫자 => 총 2개
		// 입력요소가 2개가 아니면 종료
		if(args.length != 2) {
			System.out.println("USAGE : java FileHead 10 FILENAME");
			System.exit(0);
		}
		
		// 입력받은 파일명과 숫자를 변수에 저장
		File filename = new File(args[0]);
		int num = Integer.parseInt(args[1]);
		
		// 입력받은 파일이 존재하는지, 디렉토리는 아닌지 확인
		if(!filename.exists() || filename.isDirectory()) {
			System.out.println(filename + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
			System.exit(0);
		}
		
		try {
			
			// 입력받은 파일을 읽어옴
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			// 한줄씩 읽고 입력받은 숫자만큼만 출력 
			String line = "";
			for(int i=1; i<=num; i++) {
				line = br.readLine();
				System.out.println(i + ":" + line);
			}
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
