package recursive.factorial;

import java.util.Scanner;

public class FactorialTestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("계승을 할 정수를 입력하세요: ");
		int inputNumber = sc.nextInt();
		int result = Factorial.runFactorial(inputNumber);
		System.out.println("결과: " + result);
	}

}
