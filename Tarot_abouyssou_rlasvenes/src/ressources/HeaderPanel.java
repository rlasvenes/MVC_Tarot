package ressources;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controler.TarotControler;
import customRessources.CButton;
import model.TarotModel;

public class HeaderPanel extends JPanel {

	private static final long serialVersionUID = 396698955264125256L;

	// boutons correspondant aux actions pouvant être réalisé par l'ensemble des joueurs,
	// plus particuliérement, le joueur 1 (utilisateur).
	protected CButton actionFlip 	= new CButton("Retourner cartes"	, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionPasser 	= new CButton("Passer"				, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionPrendre = new CButton("Prendre"				, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionGarde 	= new CButton("Garde"				, CButton.MY_MEDIUM_MARGIN);

	public HeaderPanel(TarotModel model, TarotControler controler) {
		super();
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(1, 4, 5, 5));

		// appel au controller qui va par la suite modifier les donnees du model
		actionFlip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// pour chaque cartes dans NOTRE main (joeur 1), on les retournes.
				controler.flipCards();
				model.trierCartes();
				controler.getLocalView().showCardsOfPlayerOne(controler.getMainFrame());
			}
		});

		actionPasser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controler.restart(controler);
					actionPrendre.setEnabled(true);
					JOptionPane.showMessageDialog(controler.getMainFrame(), "Les cartes ont été redistribuées", "Nouveau tour", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		actionPrendre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.getChien().getCards().size() != 0) {
					String[] options = {"Prise", "Garde", "Garde sans le chien" ,"Garde contre le chien"}; 
					
					JOptionPane choicePane = new JOptionPane();
					int choice = JOptionPane.showOptionDialog(controler.getMainFrame(), "Bonjour, choisis le type de garde : ", "Prise",
												 0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (choice == 0 ||
						choice == 1) {
						controler.prendre();
						model.trierCartes();
						controler.getLocalView().showCardsOfPlayerOne(controler.getMainFrame());
						controler.getMainFrame().revalidate();	
					}
					else if (choice == 2 ||
							 choice == 3) {
						controler.getBottomPanel().removeAll();
						controler.getMainFrame().revalidate();
					}
					actionPrendre.setEnabled(false);
				}
			}
		});

		setBackground(Color.CYAN.darker().darker().darker());

		add(actionFlip);
		add(actionPasser);
		add(actionPrendre);
	}	
}
