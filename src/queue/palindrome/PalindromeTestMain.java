package queue.palindrome;

import java.util.Scanner;

public class PalindromeTestMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Palindrome palindrome = null;
		String candidate = null;
		String more = null;
		
		do {
			System.out.println("ȸ���� �˻��� ���ڿ��� �Է��ϼ���.");
			System.out.print(">>: ");
			candidate = scanner.nextLine();
			
			palindrome = new Palindrome(candidate);
			palindrome.runPalindrome();
			
			System.out.println();
			System.out.print("�˻��� ������ �ֽ��ϱ�? (Y = Yes): ");
			more = scanner.nextLine();
			System.out.println();
		} while (more.equalsIgnoreCase("y"));
	}

}
