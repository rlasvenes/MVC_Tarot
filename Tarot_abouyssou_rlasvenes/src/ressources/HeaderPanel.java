package ressources;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controler.TarotControler;
import customRessources.CButton;
import model.TarotModel;
import view.TarotEcartView;

public class HeaderPanel extends JPanel {

	private static final long serialVersionUID = 396698955264125256L;

	// boutons correspondant aux actions pouvant être réalisé par l'ensemble des joueurs,
	// plus particuliérement, le joueur 1 (utilisateur).
	protected CButton actionFlip 	= new CButton("Retourner cartes"	, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionPasser 	= new CButton("Passer"				, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionEcart 	= new CButton("Constituer écart"	, CButton.MY_MEDIUM_MARGIN);
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
					JOptionPane.showMessageDialog(null, "Les cartes ont été redistribuées", "Nouveau tour", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});

		actionEcart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TarotEcartView("Drag and Drop",model, controler);
			}
		});

		actionPrendre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.prendre();
				model.trierCartes();
				controler.getLocalView().showCardsOfPlayerOne(controler.getMainFrame());
				controler.getMainFrame().revalidate();
			}
		});

		setBackground(Color.CYAN.darker().darker().darker());

		add(actionFlip);
		add(actionPasser);
		add(actionEcart);
		add(actionPrendre);
	}	
}
