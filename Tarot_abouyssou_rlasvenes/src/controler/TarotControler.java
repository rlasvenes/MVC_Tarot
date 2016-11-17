package controler;

import model.TarotModel;

public class TarotControler {
	
	private TarotModel model;
	
	public TarotControler(TarotModel model) {
		this.model = model;
		this.model.countObservers();
		System.out.println("Number of oberservers : " + model.countObservers());
	}

}
