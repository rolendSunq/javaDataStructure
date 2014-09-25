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
		
		System.out.print("시뮬레이션할 게임의 횟수를 입력하세요: ");
		numberOfGames = scanner.nextInt();
		System.out.print("게임당 최대 전투의 수를 입력하세요: ");
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
		
		// 결과를 출력
		System.out.println("시뮬레이션한 게임의 수: " + numberOfGames);
		System.out.println("중단된 게임의 수: " + numberOfDiscontinue);
		System.out.println("완료된 게임의 수: " + numberOfCompleted);
		System.out.println();
		
		if (numberOfCompleted > 0) {
			System.out.println("완료된 게임에서");
			System.out.println("전투의 총 수: " + totalOfBattles / numberOfCompleted);
		}
		System.out.println("\n프로그램 완료.");
	}

}
