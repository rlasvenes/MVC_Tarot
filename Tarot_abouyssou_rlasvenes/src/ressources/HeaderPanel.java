package ressources;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
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
	protected CButton actionFlip = new CButton("Flip cards"		, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionPasser = new CButton("Passer"			, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionEcart = new CButton("Constituer écart"	, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionPrendre = new CButton("Prendre"			, CButton.MY_MEDIUM_MARGIN);
	protected CButton actionGarde = new CButton("Garde"			, CButton.MY_MEDIUM_MARGIN);

	public HeaderPanel(TarotModel model, TarotControler controler) {
		super();
		
		// appel au controller qui va par la suite modifier les donnees du model
		actionFlip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// pour chaque cartes dans NOTRE main (joeur 1), on les retournes.
				controler.flipCards();
			}
		});
		
		actionPasser.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controler.restart();
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		actionEcart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new TarotEcartView("Ta race",model, controler);
			
			}
		});
		actionPrendre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Constituez votre écart");
				controler.prendre();
				model.trier();
				controler.getLocalView().showCardsOfPlayerOne(controler.getMainFrame());
				
				controler.getMainFrame().setSize(controler.getMainFrame().getWidth() - 1, controler.getMainFrame().getHeight());
				
				
			}
		});
		
		setBackground(Color.CYAN.darker().darker().darker());
		
		// Layout pour espacement entre les boutons
		FlowLayout flow = new FlowLayout();
		flow.setHgap(5);
		flow.setVgap(5);
		flow.setAlignment(FlowLayout.CENTER);
		
		setLayout(flow);
		
		add(actionFlip);
		add(actionPasser);
		add(actionEcart);
		add(actionPrendre);
	}	
}
