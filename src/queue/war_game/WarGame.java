package queue.war_game;

import queue.BoundedQueueInterface;

public class WarGame {
	
	BoundedQueueInterface<Integer> player1;	// ����1
	BoundedQueueInterface<Integer> player2;	// ����2
	
	private int maxNumberOfBattles;	// ������ ������ ���� ���Ǵ� �ִ� ������ ��
	private int numberOfBattles = 0;// ���� ���ӿ��� �������� ������ ��
	RankCardDeck deck;				// ī�� ��
	BoundedQueueInterface<Integer> price;
	
}
