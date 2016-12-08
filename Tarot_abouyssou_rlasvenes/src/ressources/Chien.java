package ressources;

import java.util.ArrayList;
import java.util.Comparator;


public class Chien{
	
	public final static int 	NB_CHIEN_CARDS 	= 6;
	private ArrayList<Card> 	chien 			= null;
	
	// un chien est une liste de 6 carte
	public Chien() {
		chien = new ArrayList<Card>(NB_CHIEN_CARDS);
	}
	
	public ArrayList<Card> getCards() {
		return chien;
	}
	
	public void removeCardFromChien(Card c) {
		chien.remove(c);
	}


	}

