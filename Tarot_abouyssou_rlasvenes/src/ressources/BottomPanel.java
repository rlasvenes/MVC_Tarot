package ressources;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import controler.TarotControler;
import customRessources.CButton;
import model.TarotModel;

public class BottomPanel extends JPanel {

	private static final long serialVersionUID = 8360486961489971790L;

	protected CButton validate = new CButton("Valider", CButton.MY_LARGE_MARGIN);
	
	public BottomPanel(TarotModel m, TarotControler c) {
		super(new GridBagLayout());
		
		for (Card card : m.getChien().getCards()) {
			add(card);
		}
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		add(validate, gbc);
	}
}
