package ch15;

import java.io.*;

// 디렉토리 요약정보 보여주는 프로그램
class DirectoryInfoTest {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java DirectoryInfoTest DIRECTORY");
			System.exit(0);
		}
		File dir = new File(args[0]);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		countFiles(dir);
		System.out.println();
		System.out.println(" 총" + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
		System.out.println("크기 " + totalSize + " bytes");
	} // main

	// 디렉토리 요약정보 - 파일의 개수, 디렉토리의 개수, 파일의 총 크기를 계산
	public static void countFiles(File dir) {
		// 1. dir의 파일목록(File[])을 얻어온다.
		File[] fArr = dir.listFiles();
		
		// 2. 얻어온 파일목록의 파일 중에서...
		// 디렉토리이면, totalDirs의 값을 증가시키고 countFiles()를 재귀호출한다.
		for(int i=0; i<fArr.length; i++) {
			if(fArr[i].isDirectory()) {
				totalDirs++;
				countFiles(fArr[i]);
			} else if(fArr[i].isFile()) {
				// 3. 파일이면, totalFiles를 증가시키고 파일의 크기를 totalSize에 더한다.
				totalFiles++;
				totalSize += fArr[i].length();
			}
		}
		

	} // countFiles
}
