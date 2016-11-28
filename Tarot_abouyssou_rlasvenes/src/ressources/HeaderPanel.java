package ressources;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controler.TarotControler;
import customRessources.CButton;
import model.TarotModel;

public class HeaderPanel extends JPanel {

	private static final long serialVersionUID = 396698955264125256L;
	
	// boutons correspondant aux actions pouvant être réalisé par l'ensemble des joueurs,
	// plus particuliérement, le joueur 1 (utilisateur).
	protected CButton action1 = new CButton("Flip cards"		, CButton.MY_MEDIUM_MARGIN);
	protected CButton action2 = new CButton("Passer"			, CButton.MY_MEDIUM_MARGIN);
	protected CButton action3 = new CButton("Constituer écart"	, CButton.MY_MEDIUM_MARGIN);
	protected CButton action4 = new CButton("Prendre"			, CButton.MY_MEDIUM_MARGIN);

	public HeaderPanel(TarotModel model, TarotControler controler) {
		super();
		
		// appel au controller qui va par la suite modifier les donnees du model
		action1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// pour chaque cartes dans NOTRE main (joeur 1), on les retournes.
				controler.flipCards();
			}
		});
		
		action4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.prendre(model);
				
			}
		});
		
		setBackground(Color.CYAN.darker().darker().darker());
		
		// Layout pour espacement entre les boutons
		FlowLayout flow = new FlowLayout();
		flow.setHgap(5);
		flow.setVgap(5);
		flow.setAlignment(FlowLayout.CENTER);
		
		setLayout(flow);
		
		add(action1);
		add(action2);
		add(action3);
		add(action4);
	}	
}
