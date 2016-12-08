package ressources;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controler.TarotControler;
import model.TarotModel;

public class BottomPanel extends JPanel {

	private static final long serialVersionUID = 8360486961489971790L;
	
	public BottomPanel(TarotModel m, TarotControler c) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		for (Card card : m.getChien().getCards()) {
			add(card, gbc);
		}
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	public void showCardsOfChien(BottomPanel bp, TarotModel tm) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		for (Card c : tm.getChien().getCards()) {
			add(c, gbc);
			c.update(c.getGraphics());
		}
		bp.update(bp.getGraphics());
		revalidate();
	}
}
