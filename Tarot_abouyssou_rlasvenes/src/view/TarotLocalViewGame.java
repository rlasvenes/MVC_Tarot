package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JFrame;
import controler.TarotControler;
import model.TarotModel;
import ressources.Card;

public class TarotLocalViewGame extends ATarotLocalView {

	private static final long serialVersionUID = 1636582173082201983L;

	public TarotLocalViewGame(TarotModel tm, TarotControler tc) throws IOException {
		super(null, tm, tc);
		setLayout(new FlowLayout());
	}

	public void showCardsOfPlayerOne(JFrame f) {
		for (Card c : model.getPlayerByIndex(0).getHand()) {
			add(c, BorderLayout.CENTER);
		}
		f.revalidate();
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
