package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import controler.TarotControler;
import model.TarotModel;
import ressources.Card;
import utility.MyLogger;

public class TarotLocalViewGame extends ATarotLocalView {

	private static final long serialVersionUID = 1636582173082201983L;

	public TarotLocalViewGame(TarotModel tm, TarotControler tc) throws IOException {
		super(null, tm, tc);
		setLayout(new FlowLayout());
		// code pour teste, à enlever si besoin est
		Logger logger = MyLogger.getLogger();
		for (Card c : model.getCartes()) {
			if (c.getValue() < 5)
				add(c, BorderLayout.CENTER); logger.log(Level.INFO, "Ajout de la carte " + c + " dans la vue.");
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
