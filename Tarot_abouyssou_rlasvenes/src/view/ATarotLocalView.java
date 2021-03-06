package view;

import java.util.Observer;

import javax.swing.JPanel;
import controler.TarotControler;

import model.TarotModel;

public abstract class ATarotLocalView extends JPanel implements Observer {

	private static final long serialVersionUID = 7592512737671356657L;
	
	protected TarotModel 		model;
	protected TarotControler 	controler;
	
	public ATarotLocalView(String title, TarotModel tm, TarotControler tc) {
		super();
	
		
		model 		= tm;
		controler 	= tc;
		
		validate();
		
		tm.addObserver(this);
		setVisible(true);
	}

}
