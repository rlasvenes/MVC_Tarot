package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import ressources.Card;
import ressources.CardComparator;
import ressources.Chien;
import ressources.Player;
import utility.MyLogger;


public class TarotModel extends Observable {

	// donnees relatives au jeu
	public final int NB_TOTAL_CARDS 		= 78;
	public final int NB_PLAYER 			= 4;

	// donnees relatives aux cartes
	private final int 	INDEX_FIRST_CARD 	= 0;
	private final int 	INDEX_LAST_CARD 	= NB_TOTAL_CARDS - 2;
	private Card 		first_card			= null;
	private Card 		last_card 			= null;

	// les 4 joueurs
	protected Player[] players = null;

	// notre paquet de cartes 
	private ArrayList<Card> cards = null;

	// le chien
	private Chien chien = null;

	// le logger (logfile)
	Logger logger = MyLogger.getLogger();

	// ===== Constructor =====
	public TarotModel() throws IOException {
		initPlayers();
		initCards();
		initChien();
		distribuateCards();
		trierCartes();
	}

	public void initPlayers() {
		players = new Player[NB_PLAYER];

		for (int i=0; i<NB_PLAYER; i++) {
			players[i] = new Player();
		}
	}

	public void initChien() {
		chien = new Chien();
	}

	// méthode qui va charger toutes les images du dossier "ressources-100", pour
	// pouvoir constituer notre paquet de 78 cartes. 
	// Mélanges également les cartes.
	public void initCards() throws IOException {
		cards = new ArrayList<Card>(NB_TOTAL_CARDS);
		int nb_cards = 0;

		for (int i=1; i<=21; i++) {
			// on charge les atouts (1 à 21)
			if (i <= 21) {
				cards.add(new Card("img/ressources-100/" + i + ".jpg", i, "Atout"));
				logger.log(Level.INFO, "Ajout carte atout n°" + i + "  : img/ressources-100/" + i + ".jpg");
				++nb_cards;
			}
			// on charges les cartes (carreau, trefle, coeur, et pique (1 à 14)
			if (i <= 14) {
				cards.add(new Card("img/ressources-100/" + i + "Carreau.jpg"	, i, "Carreau"));
				logger.log(Level.INFO, "Ajout carte : carreau : img/ressources-100/Carreau" + i + ".jpg");
				++nb_cards;

				cards.add(new Card("img/ressources-100/" + i + "Coeur.jpg" 	, i, "Coeur"));
				logger.log(Level.INFO, "Ajout carte : coeur 	: img/ressources-100/Coeur" + i + ".jpg");
				++nb_cards;

				cards.add(new Card("img/ressources-100/" + i + "Pique.jpg"		, i, "Pique"));
				logger.log(Level.INFO, "Ajout carte : pique 	: img/ressources-100/Pique" + i + ".jpg");
				++nb_cards;

				cards.add(new Card("img/ressources-100/" + i + "Trefle.jpg"	, i, "Trefle"));
				logger.log(Level.INFO, "Ajout carte : trefle 	: img/ressources-100/Trefle" + i + ".jpg");
				++nb_cards;
			}
			// on charge une seule fois l'excuse dans le paquet
			if (i < 2) {
				cards.add(new Card("img/ressources-100/excuse.jpg", i, "Excuse"));
				logger.log(Level.INFO, "Ajout carte : excuse  : " +  "img/ressources-100/excuse.jpg");
				++nb_cards;
			}
		}

		logger.info("Nombre de cartes : " + nb_cards);
		// on mélange les cartes
		Collections.shuffle(cards);
	}

	// va distribuer les cartes en suivant les regles (cf: regles tarot) entre les 4 joueurs
	// et le chien.
	// A la fin, notre paquet de 78 cartes est vide.
	public void distribuateCards() {
		first_card 	= cards.get(INDEX_FIRST_CARD); // plus facile pour etre sur que l'on ne vas pas
		cards.remove(INDEX_FIRST_CARD);
		last_card 	= cards.get(INDEX_LAST_CARD);  // ajouter une de ces deux cartes en premier/dernier
		cards.remove(INDEX_LAST_CARD);

		// tant qu'il y a des cartes dans le paquet, on les distribues
		while (!cards.isEmpty()) {
			for (int i=0; i<NB_PLAYER; i++) {
				for (int j=0; j<3; j++) {
					players[i].addCardToHand(cards.get(INDEX_FIRST_CARD));			 // parent ne le permettra jamais (?).
					cards.remove(INDEX_FIRST_CARD);
				}

				// si il y a au moins une carte dans le chien, et qu'il reste aussi au moins deux place
				// alors on va ajouter les premiere/derniere carte (cf: regle tarot)

				if ((!chien.getCards().isEmpty()) && (chien.getCards().size() < Chien.NB_CHIEN_CARDS - 2)) {
					chien.getCards().add(first_card);// elles sont déjà retiré du paquet (en "avance")
					chien.getCards().add(last_card);
				}
				// on remplit le chien avec la premiere carte qu'on tire du paquet 
				// (paquet courant, qui diminu au fur et à mesure).
				if ((chien.getCards().size() < Chien.NB_CHIEN_CARDS) && (cards.size() > 0)) {
					chien.getCards().add(cards.get(INDEX_FIRST_CARD));
					cards.remove(cards.get(INDEX_FIRST_CARD));
				}
			}
		}
	}

	public void trierCartes()
	{
		Collections.sort(players[0].getHand(), new CardComparator() );
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public Player getPlayerByIndex(int indexPlayer) {
		return players[indexPlayer];
	}

	public Player[] getPlayers() {
		return players;
	}

	public Chien getChien() {
		return chien;
	}

}
