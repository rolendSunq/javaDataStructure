package queue.palindrome;

import java.util.Scanner;

public class PalindromeTestMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Palindrome palindrome = null;
		String candidate = null;
		String more = null;
		
		do {
			System.out.println("회문을 검사할 문자열을 입력하세요.");
			System.out.print(">>: ");
			candidate = scanner.nextLine();
			
			palindrome = new Palindrome(candidate);
			palindrome.runPalindrome();
			
			System.out.println();
			System.out.print("검사할 문장이 있습니까? (Y = Yes): ");
			more = scanner.nextLine();
			System.out.println();
		} while (more.equalsIgnoreCase("y"));
	}

}
