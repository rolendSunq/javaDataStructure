package queue.war_game;

import java.util.Random;

public class RankCardDeck {
	private static final int QUANTITY_CARD = 52;
	private int[] cardDeck = new int[QUANTITY_CARD];
	private int currentCardPosition = 0;
	private Random rand = new Random();
	
	public RankCardDeck() {
		for (int i = 0; i < QUANTITY_CARD; i++) {
			cardDeck[i] = i / 4;
		}
	}
	
	public void shuffle() {
		int randLocation;
		int temp;
		
		for (int i = (QUANTITY_CARD - 1); i > 0; i--) {
			randLocation = rand.nextInt(i);
			temp = cardDeck[randLocation];
			cardDeck[randLocation] = cardDeck[i];
			cardDeck[i] = temp;
		}
		
		currentCardPosition = 0;
	}
	
	public boolean hasMoreCards() {
		return (currentCardPosition != QUANTITY_CARD);
	}
	
	public int nextCard() {
		currentCardPosition = currentCardPosition + 1;
		return (cardDeck[currentCardPosition - 1]);
	}
}
