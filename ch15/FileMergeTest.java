package ch15;

import java.io.*;

// 커맨드라인으로 부터 여러 파일의 이름을 입력받고
// 이 파일들을 순서대로 합쳐서 새로운 파일을 만들어 내는 프로그램
// 단, 합칠 파일의 개수에는 제한을 두지 않는다.

public class FileMergeTest {
	public static void main(String[] args) {
		// 파일명을 두개 이상 받아야 하므로 두개 미만이면 오류메세지
		if (args.length < 2) {
			System.out.println("USAGE : java FileMerge filename");
			System.exit(0);
		}

		// 첫번째 인자(파일명)은 새로운 파일 생성하고
		// 그 생성한 새로운 파일에 뒤의 파일들 내용 합쳐 저장
		// ex) result.txt 1.txt 2.txt => result에 1과 2 합친 내용 저장

		try {
			// 1. 파일을 읽고 쓸수있게 하는 reader&writer 스트림 생성
			FileReader fr = null;
			FileWriter fw = new FileWriter(args[0]); // 새로운 파일
			BufferedWriter bw = new BufferedWriter(fw);

			// 2. 두번째 인자부터 합치는 과정 적용
			for (int i = 1; i < args.length; i++) {
				// 2-1. 파일 내용 읽어옴
				String filename = args[i];
				fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);

				// 2-2. 읽어온 파일내용을 result에 저장
				String line = "";
				while ((line = br.readLine()) != null) {
					bw.write(line + "\n");
				}
				
				br.close();
				
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
