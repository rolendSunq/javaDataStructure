package recursive.blob;

import java.util.Scanner;

public class BlobAppTestMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		final int GRIDR = 10;
		final int GRIDC = 40;
		
		// ��� ������ ������� ����
		int percentage;
		System.out.print("������� ���� ������ �Է��ϼ��� (0 ~ 100): ");
		
		if (scanner.hasNextInt()) {
			percentage = scanner.nextInt();
		} else {
			System.out.println("����: �ݵ�� ���� ���� �Է��ϼ���.");
			System.out.println("���α׷��� �����մϴ�.");
			return;
		}
		
		System.out.println();
		
		// ���ڸ� ����
		Grid grid = new Grid(GRIDR, GRIDC, percentage);
		
		// ���ڸ� ���̰� ����� ���
		System.out.println(grid);
		System.out.println("\n ���: ��� �� " + grid.blobCount() + "��");
	}

}
