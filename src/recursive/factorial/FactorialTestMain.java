package recursive.factorial;

import java.util.Scanner;

public class FactorialTestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �� ������ �Է��ϼ���: ");
		int inputNumber = sc.nextInt();
		int result = Factorial.runFactorial(inputNumber);
		System.out.println("���: " + result);
	}

}
