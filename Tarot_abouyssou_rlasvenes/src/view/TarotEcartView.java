package view;
import java.util.Observable;

import controler.TarotControler;
import model.TarotModel;
public class TarotEcartView extends ATarotView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2539790255028446405L;

	public TarotEcartView(String title, TarotModel tm, TarotControler tc) {
		super(title, tm, tc);
		setSize(1000,200);
		setDefaultCloseOperation(ATarotView.DISPOSE_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
