package ressources;

import java.util.ArrayList;

public class Player {

	// donnees relatives joueurs
	public static final int MAXIMUM_CARDS_IN_HAND_WITHOUT_CHIEN = 18;
	public static final int MAXIMUM_CARDS_IN_HAND_WITH_CHIEN 	= MAXIMUM_CARDS_IN_HAND_WITHOUT_CHIEN + Chien.NB_CHIEN_CARDS;
	private ArrayList<Card> hand = null;
	
	public Integer 			last_index							= null;

	public Player() {
		hand = new ArrayList<Card>(MAXIMUM_CARDS_IN_HAND_WITHOUT_CHIEN);
	}

	// SECURITE: vérifie juste que l'on ai pas trop de cartes en main.
	public boolean addCardToHand(Card c) {
		if (hand.size() < MAXIMUM_CARDS_IN_HAND_WITHOUT_CHIEN) {
			hand.add(c);
			return true;
		}
		return false;
	}

	public void addCardOfChien(Card c) {
		while (hand.size() < MAXIMUM_CARDS_IN_HAND_WITHOUT_CHIEN + Chien.NB_CHIEN_CARDS)
			hand.add(c);
	}

	// permet de connaître les cartes en main de notre joueur.
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	// permet d'obtenir l'index de la prochaine carte à retourner
	public int getNextIndex() {
		for (int i=0; i<hand.size(); ++i) {
			if (!hand.get(i).isFlipped()) {
				return i;
			}
		}
		return hand.size();
	}
}
