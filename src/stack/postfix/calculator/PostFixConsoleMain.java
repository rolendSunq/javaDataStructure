package stack.postfix.calculator;

import java.util.Scanner;

public class PostFixConsoleMain {

	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		String line = null;	// ���� ���ڿ�
		String more = null;	// flag variable �ݺ������� �ݺ� ���� / ��� �Ǵ�.
		int result;			// ���� ��� ���
		
		do {
			// ó���� ���� ������ ������
			System.out.print("�������� �Է��ϼ���: ");
			line = conIn.nextLine();
			
			// ���� ����� ����� ��� �����
			try {
				result = PostFixEvaluator.evaluate(line);
				//����� ���
				System.out.println();
				System.out.println("���: " + result);
			} catch (PostFixException e) {
				// ���� �޼��� ���
				System.out.println();
				System.out.println("ǥ���� ���� �߻�: " + e.getMessage());
			}
			
			// ó���� ���� ������ �ִ��� ����
			System.out.println();
			System.out.print("���� �ٸ� ǥ������ �ֽ��ϱ�? (Y = Yes): ");
			more = conIn.nextLine();
			System.out.println();
		} while (more.equalsIgnoreCase("y"));
		
		System.out.println("���α׷��� �����մϴ�.");
	}

}
