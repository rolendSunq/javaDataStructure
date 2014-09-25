package queue.war_game;

import queue.BoundedQueueInterface;
import queue.QueueUnderflowException;
import queue.array_queue.ArrayBoundedQueue;

public class WarGame {
	
	BoundedQueueInterface<Integer> player1;			// ����1
	BoundedQueueInterface<Integer> player2;			// ����2
	private int maxNumberOfBattles;					// ������ ������ ���� ���Ǵ� �ִ� ������ ��
	private int numberOfBattles = 0;				// ���� ���ӿ��� �������� ������ ��
	RankCardDeck deck;								// ī�� ��
	BoundedQueueInterface<Integer> prize;			// ���� �������� ����� ī��
	private static final int NUMBER_OF_CARD = 52;	// ���� �ִ� ī���� �� 
	
	public WarGame(int maxNumberOfBattles) {
		this.maxNumberOfBattles = maxNumberOfBattles;
		deck = new RankCardDeck();
	}
	
	public int getNumberOfBattles() {
		return numberOfBattles;
	}
	
	/*
	 * ���� �ùķ��̼�
	 * ������ ������ ���� maxNumberOfBattles�� �����ϸ� ������ �ߴܵ�
	 * ������ ���������� ������ ����, ������ �ߴܵǸ� ������ ����
	 */
	public boolean play() {
		// ���� ����
		player1 = new ArrayBoundedQueue<Integer>(NUMBER_OF_CARD);
		player2 = new ArrayBoundedQueue<Integer>(NUMBER_OF_CARD);
		
		// ���̸� ����
		prize = new ArrayBoundedQueue<Integer>(NUMBER_OF_CARD);
		boolean gameOver = false;
		boolean gameOK	 = true;
		
		// ���� �տ� ����
		deck.shuffle();
		
		while (deck.hasMoreCards()) {
			player1.enqueue(deck.nextCard());
			
			if (deck.hasMoreCards()) {
				player2.enqueue(deck.nextCard());
			}
		}
		
		// �� ������ ī�带 ������ ������
		// �Ǵ� ������ ���� �ִ뿡 ���� ������ ����
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
	 * player1�� player2 ���� ���� ��
	 * ���￡�� �� �����κ��� �� ī��� �������� ��������
	 * ������ ��������� ��ӵ�
	 */
	private void battle() {
		// �� ������ ���� ī���
		int player1OfCard;
		int player2OfCard;
		
		// ������κ��� ī�带 ��� ���� ���� ����
		player1OfCard = player1.dequeue();
		prize.enqueue(player1OfCard);
		player2OfCard = player2.dequeue();
		prize.enqueue(player2OfCard);
		
		// ������ ����� �����ϰ� ó����
		if (player1OfCard > player2OfCard) {
			while (!prize.isEmpty()) {
				player2.enqueue(prize.dequeue());
			}
		} else {
			// �������� ����
			// �� ������ �� ���� ī�带 ���� ���� ����
			for (int i = 0; i < 3; i++) {
				prize.enqueue(player1.dequeue());
				prize.enqueue(player2.dequeue());
			}
			
			// ���� ���� ������ �����ϱ� ���� ������ ���
			battle();
		}
	}
}
