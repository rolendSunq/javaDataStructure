package recursive.towers_of_hannoi;

import java.util.Scanner;

public class TowersOfHannoi {
	private static String indent = "";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// ���� �忡 �ִ� ���� ����
		int n;
		System.out.print("���� ������ �Է��ϼ���: ");
		if (scanner.hasNext()) {
			n = scanner.nextInt();
		} else {
			System.out.println("����: �ݵ�� ������ �Է��ؾ� �մϴ�.");
			System.out.println("���α׷��� �����մϴ�.");
			return;
		}
		System.out.println("�ϳ���ž���� " + n + " ���� ���� �ֽ��ϴ�.\n");
		doTowers(n, 1, 2, 3);
	}
	
	private static void doTowers(int n, int startPeg, int auxPeg, int endPeg) {
		if (n > 0) {
			indent = indent + "  ";
			System.out.println(indent +  n + "���� ���� " + startPeg + "��� ���� " + endPeg +"������� �̵�" );
			
			// n-1 ���� ���� ���� ��տ��� ���� ������� �̵�
			doTowers(n - 1, startPeg, endPeg, auxPeg);
			
			// n ��° ���� ���� ��տ��� ������ ������� �̵�
			System.out.println(indent  + "���� " + startPeg + "��� ���� " + endPeg + "������� �̵�" );
			
			// n-1 ���� ���� ���� ��տ��� ������ ������� �̵�
			doTowers(n - 1, auxPeg, startPeg, endPeg);
			
			indent  = indent.substring(2);
		}
	}
}
