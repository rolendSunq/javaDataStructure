package stack.postfix.calculator;

import java.util.Scanner;

public class PostFixConsoleMain {

	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String line = null;	// 계산될 문자열
		String more = null;	// flag variable 반복문에서 반복 중지 / 계속 판단.
		int result;			// 최종 계산 결과
		
		do {
			// 처리할 다음 수식을 가져옴
			System.out.print("후위식을 입력하세요: ");
			line = conIn.nextLine();
			
			// 수식 계산의 결과를 얻고 출력함
			try {
				result = PostFixEvaluator.evaluate(line);
				//결과를 출력
				System.out.println();
				System.out.println("결과: " + result);
			} catch (PostFixException e) {
				// 오류 메세지 출력
				System.out.println();
				System.out.println("표현식 문제 발생: " + e.getMessage());
			}
			
			// 처리할 다음 수식이 있는지 결정
			System.out.println();
			System.out.print("평가할 다른 표현식이 있습니까? (Y = Yes): ");
			more = conIn.nextLine();
			System.out.println();
		} while (more.equalsIgnoreCase("y"));
		
		System.out.println("프로그램을 종료합니다.");
	}

}
