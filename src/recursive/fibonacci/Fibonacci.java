package recursive.fibonacci;

import java.util.Scanner;

public class Fibonacci {
	
	private int inpNum;
	
	private int fibo(int n) {
	    if(n <= 1) {
	        return n;
	    } else {
	        return fibo(n - 1) + fibo(n - 2);
	    }
	}
	
	private void inputNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		inpNum = scanner.nextInt();
	}
	
	public void runFibonacci() {
		inputNumber();
		int result = fibo(inpNum);
		System.out.println("���: " + result);
	}
	
}
