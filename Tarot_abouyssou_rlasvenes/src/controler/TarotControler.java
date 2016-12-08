package controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.TarotModel;
import ressources.BottomPanel;
import ressources.Card;
import ressources.Chien;
import ressources.HeaderPanel;
import view.TarotLocalViewGame;
import view.TarotViewMenu;

public class TarotControler {

	private TarotModel model;
	private TarotLocalViewGame view;
	private BottomPanel bottomPanel;
	private JFrame f;
	private TarotViewMenu tarotViewMenu;

	public TarotControler(TarotModel model) {
		this.model = model;
	}

	// va retourner nos cartes en main.
	public void flipCards() {

		// obligatoire pour initialiser "last_index"
		model.getPlayerByIndex(0).last_index = 0;

		Timer t = new Timer(110, new ActionListener() {

			int i = model.getPlayerByIndex(0).last_index;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (i == model.getPlayerByIndex(0).getHand().size()) {
					((Timer) e.getSource()).stop();
				} else {
					model.getPlayerByIndex(0).getHand().get(i).flip();
					i = model.getPlayerByIndex(0).getNextIndex();
				}
			}
		});

		t.start();
	}

	public void constituerEcart() {

	}

	public void prendre() {
		for (int i = 0; i < Chien.NB_CHIEN_CARDS; i++) {
			model.getPlayerByIndex(0).getHand().add(model.getChien().getCards().get(i));
		}

		for (int i = 0; i < Chien.NB_CHIEN_CARDS; i++) {
			model.getChien().getCards().remove(0);
		}

		model.trierCartes();
	}

	// on lance le jeu (du moins, tout les composants graphiques nécéssaire)
	// en cliquant sur le bouton "Lancer le jeu".
	public void launchGame(JFrame f, TarotModel tm, TarotControler tc) {
		try {
			// on réinitialise le Panel conteneur principale
			f.getContentPane().removeAll();

			// on ajoute notre nouvel vue locale pour le jeu (toujours dans la
			// même frame)
			TarotLocalViewGame tlvg = new TarotLocalViewGame(tm, tc);
			f.add(tlvg);

			tc.setLocalView(tlvg);
			tc.setMainFrame(f);

			f.add(new HeaderPanel(tm, tc), BorderLayout.PAGE_START);
			BottomPanel bottomPanel = new BottomPanel(tm, tc);
			tc.setBottomPanel(bottomPanel);
			f.add(bottomPanel, BorderLayout.PAGE_END);

			// on va venir ajouter les cartes du joueur 1 (nous) dans notre
			// fenêtre principale
			tlvg.showCardsOfPlayerOne(f);

			// on rafraichit notre fenêtre et on valide ses composants
			f.revalidate();
			f.repaint();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	// affiche les règles (quelques) du jeu.
	// aucun retour en arrière depuis cette vue (A CORRIGER)
	public void displayRules(JFrame f) {
		// IMPORTANT !!
		// Note à moi-même :
		// Penser à faire une classe du genre; DisplayRulesView

		f.getContentPane().removeAll();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		// quelques règles sur le tarot
		JPanel pan = new JPanel(new GridBagLayout());
		JLabel title = new JLabel("Voici quelques règles élémentaires du Tarot : ");
		JLabel rulesText = new JLabel("<html><style> p {text-align: center;} </style><p>"
				+ "- Le donneur distribue les cartes 3 par 3. [...] Au cours de la "
				+ "distribution, le donneur constitue carte par carte, un talon "
				+ "de 6 cartes appellé <span style = \"color: black;\">le chien.</span></p><br>"
				+ "<p>-Les joueurs ne révèlent leur jeu que lorsque la distribution "
				+ "est entièrement terminée.</p><br>"
				+ "<p>-Un joueur possédant le <span style = \"color: black;\">Petit sec.</span> "
				+ "(c'est son seul atout et il n'a pas l'Excuse) doit obligatoirement "
				+ " l'annoncer, étaler son jeu, et annuler la donne.</p><br>" + "</html>");

		rulesText.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 24));
		title.setFont(new Font("Gentium", Font.BOLD, 32));
		title.setForeground(Color.RED);
		rulesText.setForeground(Color.BLUE);

		rulesText.setHorizontalAlignment(JLabel.CENTER);
		pan.add(title, gbc);
		pan.add(rulesText, gbc);
		f.add(pan, BorderLayout.NORTH);

		f.revalidate();
		f.repaint();
	}

	public void restart(TarotControler tc) throws IOException {
		// on recupere les cartes des 4 joueurs et on reconstitue le paquet
		// initiale
		for (int i = 0; i < model.NB_PLAYER; i++) {
			for (Card c : model.getPlayerByIndex(i).getHand()) {
				model.getCards().add(c);
			}
		}

		// on supprimes les cartes de tout les joeurs
		for (int i = 0; i < model.NB_PLAYER; i++) {
			for (Card c : model.getPlayerByIndex(i).getHand()) {
				model.getCards().remove(c);
			}
		}

		// on recupere les cartes du chien
		for (Card c : model.getChien().getCards()) {
			model.getCards().add(c);
		}

		// on supprimes les cartes du chien (separement)
		if (model.getChien().getCards().size() > 0) {
			for (int i = 0; i < Chien.NB_CHIEN_CARDS; i++) {
				model.getChien().getCards().remove(0);
			}
		}

		tc.getLocalView().removeAll();
		tc.getBottomPanel().removeAll();
		tc.getBottomPanel().update(tc.getBottomPanel().getGraphics());
		tc.getLocalView().update(tc.getLocalView().getGraphics());

		model.initCards();
		model.initChien();
		model.initPlayers();
		model.distribuateCards();

		tc.getLocalView().showCardsOfPlayerOne(tc.getMainFrame());
		tc.getBottomPanel().showCardsOfChien(tc.getBottomPanel(), model);
	}

	public void petitSec() throws IOException {
		int cpt = 0;
		boolean isPresent = false;

		for (Card c : model.getPlayerByIndex(0).getHand()) {
			if (c.getSymbole() == "Atout" || c.getSymbole() == "Excuse") {
				cpt++;
				if (c.getValue() == 1)
					isPresent = true;
			}
			if (isPresent && cpt == 1)
				restart(this);
		}
	}

	// va permettre de pouvoir quitter notre application
	public void exitApplication(JFrame f) {
		f.dispose();
	}

	public void setLocalView(TarotLocalViewGame view) {
		this.view = view;
	}

	public TarotLocalViewGame getLocalView() {
		return view;
	}

	public void setBottomPanel(BottomPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	public BottomPanel getBottomPanel() {
		return this.bottomPanel;
	}

	public void setMainFrame(JFrame f) {
		this.f = f;
	}

	public JFrame getMainFrame() {
		return this.f;
	}

	public void setTarotViewMenu(TarotViewMenu tarotViewMenu) {
		this.tarotViewMenu = tarotViewMenu;
	}

	public TarotViewMenu getTarotViewMenu() {
		return this.tarotViewMenu;
	}
}
