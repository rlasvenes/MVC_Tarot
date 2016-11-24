package controler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.TarotModel;
import ressources.BottomPanel;
import ressources.Card;
import ressources.HeaderPanel;
import view.TarotLocalViewGame;

public class TarotControler {
	
	private TarotModel model;
	
	public TarotControler(TarotModel model) {
		this.model = model;
	}
	
	// va retourner nos cartes en main.
	public void flipCards() {
		for (Card c : model.getPlayerByIndex(0).getHand()) {
			c.flip();
			c.update(c.getGraphics());
		}
	}
	
	// on lance le jeu (du moins, tout les composants graphiques nécéssaire)
	// en cliquant sur le bouton "Lancer le jeu".
	public void launchGame(JFrame f, TarotModel tm, TarotControler tc) {
		try {
			// on réinitialise le Panel conteneur principale
			f.getContentPane().removeAll();

			// on ajoute notre nouvel vue locale pour le jeu (toujours dans la même frame)
			TarotLocalViewGame tlvg = new TarotLocalViewGame(tm, tc);
			f.add(tlvg);
			f.add(new HeaderPanel(tm, tc), BorderLayout.PAGE_START);
			f.add(new BottomPanel(tm, tc), BorderLayout.PAGE_END);
			
			// on va venir ajouter les cartes du joueur 1 (nous) dans notre fenêtre principale
			tlvg.showCardsOfPlayerOne(f);
			
			// on rafraichit notre fenêtre et on valide ses composants
			f.revalidate();
			f.repaint();
		}
		catch (IOException ex) {
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
									+ " l'annoncer, étaler son jeu, et annuler la donne.</p><br>"
									+ "</html>");
		
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
	
	// va permettre de pouvoir quitter notre application
	public void exitApplication(JFrame f) {
		f.dispose();
	}
}
