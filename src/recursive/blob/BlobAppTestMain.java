package recursive.blob;

import java.util.Scanner;

public class BlobAppTestMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		final int GRIDR = 10;
		final int GRIDC = 40;
		
		// 블롭 문자의 백분율을 얻음
		int percentage;
		System.out.print("백분율의 값을 정수로 입력하세요 (0 ~ 100): ");
		
		if (scanner.hasNextInt()) {
			percentage = scanner.nextInt();
		} else {
			System.out.println("오류: 반드시 정수 값을 입력하세요.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		System.out.println();
		
		// 격자를 생성
		Grid grid = new Grid(GRIDR, GRIDC, percentage);
		
		// 격자를 보이고 블롭을 계산
		System.out.println(grid);
		System.out.println("\n 결과: 블롭 수 " + grid.blobCount() + "개");
	}

}
