package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import ressources.Card;
import utility.MyLogger;

public class TarotModel extends Observable {

	protected final int NB_CARDS 	= 74;
	protected final int NB_PLAYER 	= 4;
	
	private ArrayList<Card> cartes;
	
	Logger logger = MyLogger.getLogger();
	
	// ===== Constructor =====
	
	public TarotModel() throws IOException {
		InitCards();
	}
	
	public void InitCards() throws IOException {
		cartes = new ArrayList<Card>(78);
		int nb_cards = 0;
		
		for (int i=1; i<=21; i++) {
			// on charge les atouts (1 à 21)
			if (i <= 21) {
				cartes.add(new Card("img/ressources-100/" + i + ".jpg", i, "Atout"));
				logger.log(Level.INFO, "Ajout carte atout n°" + i + "  : img/ressources-100/" + i + ".jpg");
				++nb_cards;
			}
			// on charges les cartes (carreau, trefle, coeur, et pique (1 à 14)
			if (i <= 14) {
				cartes.add(new Card("img/ressources-100/" + i + "Carreau.jpg"	, i, "Carreau"));
				logger.log(Level.INFO, "Ajout carte : carreau : img/ressources-100/Carreau" + i + ".jpg");
				++nb_cards;
				
				cartes.add(new Card("img/ressources-100/" + i + "Coeur.jpg" 	, i, "Coeur"));
				logger.log(Level.INFO, "Ajout carte : coeur 	: img/ressources-100/Coeur" + i + ".jpg");
				++nb_cards;
				
				cartes.add(new Card("img/ressources-100/" + i + "Pique.jpg"		, i, "Pique"));
				logger.log(Level.INFO, "Ajout carte : pique 	: img/ressources-100/Pique" + i + ".jpg");
				++nb_cards;
				
				cartes.add(new Card("img/ressources-100/" + i + "Trefle.jpg"	, i, "Trefle"));
				logger.log(Level.INFO, "Ajout carte : trefle 	: img/ressources-100/Trefle" + i + ".jpg");
				++nb_cards;
			}
			// on charge une seule fois l'excuse dans le paquet
			if (i < 2) {
				cartes.add(new Card("img/ressources-100/excuse.jpg"));
				logger.log(Level.INFO, "Ajout carte : excuse  : " +  "img/ressources-100/excuse.jpg");
				++nb_cards;
			}
		}
		
		logger.info("Nombre de cartes : " + nb_cards);
		// on mélange les cartes
		Collections.shuffle(cartes);
	}
	
	public ArrayList<Card> getCartes() {
		return cartes;
	}
}
