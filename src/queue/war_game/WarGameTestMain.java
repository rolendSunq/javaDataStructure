package queue.war_game;

import java.util.Scanner;

public class WarGameTestMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		WarGame game;
		
		int numberOfGames;
		int maxNumberOfBattles;
		int numberOfDiscontinue = 0;
		int numberOfCompleted = 0;
		int totalOfBattles = 0;
		
		System.out.print("�ùķ��̼��� ������ Ƚ���� �Է��ϼ���: ");
		numberOfGames = scanner.nextInt();
		System.out.print("���Ӵ� �ִ� ������ ���� �Է��ϼ���: ");
		maxNumberOfBattles = scanner.nextInt();
		game = new WarGame(maxNumberOfBattles);
		
		for (int i = 0; i < numberOfGames; i++) {
			if (game.play()) {
				numberOfCompleted = numberOfCompleted + 1;
				totalOfBattles = totalOfBattles + game.getNumberOfBattles();
			} else {
				numberOfDiscontinue = numberOfDiscontinue + 1;
			}
		}
		
		// ����� ���
		System.out.println("�ùķ��̼��� ������ ��: " + numberOfGames);
		System.out.println("�ߴܵ� ������ ��: " + numberOfDiscontinue);
		System.out.println("�Ϸ�� ������ ��: " + numberOfCompleted);
		System.out.println();
		
		if (numberOfCompleted > 0) {
			System.out.println("�Ϸ�� ���ӿ���");
			System.out.println("������ �� ��: " + totalOfBattles / numberOfCompleted);
		}
		System.out.println("\n���α׷� �Ϸ�.");
	}

}
