package recursive.factorial;

import java.util.Scanner;

public class TraceFactorialTestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �� ������ �Է��ϼ���: ");
		int inputNumber = sc.nextInt();
		int result = TraceFactorial.runFactorial(inputNumber);
		System.out.println("��� ���: " + result);
	}

}