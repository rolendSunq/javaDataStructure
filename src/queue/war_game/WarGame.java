package queue.war_game;

import queue.BoundedQueueInterface;
import queue.QueueUnderflowException;
import queue.array_queue.ArrayBoundedQueue;

public class WarGame {
	
	BoundedQueueInterface<Integer> player1;			// 선수1
	BoundedQueueInterface<Integer> player2;			// 선수2
	private int maxNumberOfBattles;					// 게임이 끝나기 전에 허용되는 최대 전투의 수
	private int numberOfBattles = 0;				// 현재 게임에서 행해지는 전투의 수
	RankCardDeck deck;								// 카드 덱
	BoundedQueueInterface<Integer> prize;			// 현재 전투에서 얻어진 카드
	private static final int NUMBER_OF_CARD = 52;	// 덱에 있는 카드의 수 
	
	public WarGame(int maxNumberOfBattles) {
		this.maxNumberOfBattles = maxNumberOfBattles;
		deck = new RankCardDeck();
	}
	
	public int getNumberOfBattles() {
		return numberOfBattles;
	}
	
	/*
	 * 게임 시뮬레이션
	 * 행해진 전투의 수가 maxNumberOfBattles에 도달하면 게임은 중단됨
	 * 게임이 정상적으로 끝나면 참을, 게임이 중단되면 거짓을 리턴
	 */
	public boolean play() {
		// 선수 생성
		player1 = new ArrayBoundedQueue<Integer>(NUMBER_OF_CARD);
		player2 = new ArrayBoundedQueue<Integer>(NUMBER_OF_CARD);
		
		// 더미를 생성
		prize = new ArrayBoundedQueue<Integer>(NUMBER_OF_CARD);
		boolean gameOver = false;
		boolean gameOK	 = true;
		
		// 원래 손에 딜함
		deck.shuffle();
		
		while (deck.hasMoreCards()) {
			player1.enqueue(deck.nextCard());
			
			if (deck.hasMoreCards()) {
				player2.enqueue(deck.nextCard());
			}
		}
		
		// 한 선수가 카드를 소진할 때까지
		// 또는 전투의 수가 최대에 달할 때까지 행함
		numberOfBattles = 0;
		
		while (!gameOver) {
			
			try {
				numberOfBattles = numberOfBattles + 1;
				battle();
			} catch (QueueUnderflowException ex) {
				gameOver = true;
			}
			
			if (numberOfBattles == maxNumberOfBattles) {
				gameOver = true;
				gameOK = false;
			}
		}
		return gameOK;
	}

	/* 
	 * player1과 player2 간의 전투 모델
	 * 전쟁에서 각 선수로부터 세 카드는 더미위에 놓여지고
	 * 전투는 재귀적으로 계속됨
	 */
	private void battle() {
		// 이 전투를 위한 카드들
		int player1OfCard;
		int player2OfCard;
		
		// 선수들로부터 카드를 얻어 더미 위에 놓음
		player1OfCard = player1.dequeue();
		prize.enqueue(player1OfCard);
		player2OfCard = player2.dequeue();
		prize.enqueue(player2OfCard);
		
		// 전투의 결과를 결정하고 처리함
		if (player1OfCard > player2OfCard) {
			while (!prize.isEmpty()) {
				player2.enqueue(prize.dequeue());
			}
		} else {
			// 전쟁으로 돌입
			// 각 선수가 세 개의 카드를 더미 위에 놓음
			for (int i = 0; i < 3; i++) {
				prize.enqueue(player1.dequeue());
				prize.enqueue(player2.dequeue());
			}
			
			// 누가 상을 얻을지 결정하기 위해 전투를 계속
			battle();
		}
	}
}
