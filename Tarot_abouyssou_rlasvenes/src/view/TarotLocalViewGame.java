package view;

import java.io.IOException;
import java.util.Observable;

import controler.TarotControler;
import model.TarotModel;
import ressources.Card;

public class TarotLocalViewGame extends ATarotLocalView {

	private static final long serialVersionUID = 1636582173082201983L;

	public TarotLocalViewGame(TarotModel tm, TarotControler tc) throws IOException {
		super(null, tm, tc);
		
		for (int i = 1; i <= 21; i++) {
			add( new Card("img/ressources-100/cache.jpg"));
			//add( new Card("img/ressources-100/" + i + ".jpg") );
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {

	}

}