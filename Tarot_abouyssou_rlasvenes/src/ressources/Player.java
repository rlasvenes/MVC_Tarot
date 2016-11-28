package ressources;

import java.util.ArrayList;

public class Player {

	// donnees relatives joueurs
	private static final int 	MAXIMUM_CARDS_IN_HAND 	= 18;
	private boolean 			donneur 				= false;
	private ArrayList<Card> 	hand 					= null;
	
	public Player() {
		hand = new ArrayList<Card>(MAXIMUM_CARDS_IN_HAND);
	}
	
	// SECURITE: vérifie juste que l'on ai pas trop de cartes en main.
	public boolean addCardToHand(Card c) {
		if (hand.size() < MAXIMUM_CARDS_IN_HAND) {
			hand.add(c);
			return true;
		}
		return false;
	}
	public void addCardOfChien(Card c) {
		while(hand.size()< MAXIMUM_CARDS_IN_HAND + Chien.NB_CHIEN_CARDS)
		hand.add(c);
	}

	
	// permet d'enlever une carte de la main du joueur.
	// Utile pour constituer l'écart, ou bien pour remélanger si les 4 joueurs passent.
	public boolean removeCardFromHand(Card c) {
		if (hand.remove(c)){
			return true;
		}
		return false;
	}
	
	// permet de connaître les cartes en main de notre joueur.
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	// NON-GERE
	public void setDonneur(boolean value) {
		donneur = value;
	}
	
	// NON-GERE | INFO: Un seul donneur par partie.
	// permet de savoir si le l'instance du joueur sur laquelle
	// on appelle la méthode est le donneur de carte.
	public boolean isDonneur() {
		return donneur;
	}
	
}
