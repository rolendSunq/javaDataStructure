package recursive.towers_of_hannoi;

import java.util.Scanner;

public class TowersOfHannoi {
	private static String indent = "";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 시작 펙에 있는 링의 개수
		int n;
		System.out.print("고리의 개수를 입력하세요: ");
		if (scanner.hasNext()) {
			n = scanner.nextInt();
		} else {
			System.out.println("오류: 반드시 정수를 입력해야 합니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		System.out.println("하노이탑에는 " + n + " 개의 고리가 있습니다.\n");
		doTowers(n, 1, 2, 3);
	}
	
	private static void doTowers(int n, int startPeg, int auxPeg, int endPeg) {
		if (n > 0) {
			indent = indent + "  ";
			System.out.println(indent +  n + "개의 고리를 " + startPeg + "기둥 에서 " + endPeg +"기둥으로 이동" );
			
			// n-1 개의 고리를 시작 기둥에서 보조 기둥으로 이동
			doTowers(n - 1, startPeg, endPeg, auxPeg);
			
			// n 번째 링을 시작 기둥에서 목적지 기둥으로 이동
			System.out.println(indent  + "고리를 " + startPeg + "기둥 에서 " + endPeg + "기둥으로 이동" );
			
			// n-1 개의 링을 보조 기둥에서 목적지 기둥으로 이동
			doTowers(n - 1, auxPeg, startPeg, endPeg);
			
			indent  = indent.substring(2);
		}
	}
}
