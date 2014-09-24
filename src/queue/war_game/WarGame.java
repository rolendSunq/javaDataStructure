package queue.war_game;

import queue.BoundedQueueInterface;

public class WarGame {
	
	BoundedQueueInterface<Integer> player1;	// 선수1
	BoundedQueueInterface<Integer> player2;	// 선수2
	
	private int maxNumberOfBattles;	// 게임이 끝나기 전에 허용되는 최대 전투의 수
	private int numberOfBattles = 0;// 현재 게임에서 행해지는 전투의 수
	RankCardDeck deck;				// 카드 덱
	BoundedQueueInterface<Integer> price;
	
}
