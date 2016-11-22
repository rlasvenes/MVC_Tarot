package ressources;

import java.util.ArrayList;

public class Player {

	private static final int MAXIMUM_CARDS_IN_HAND = (78 - 6) / 4;
	private boolean donneur = false;
	private ArrayList<Card> hand;
	
	public Player() {
		donneur = !donneur;
		hand = new ArrayList<>(MAXIMUM_CARDS_IN_HAND);
		hand.get(0);
	}
	
}
