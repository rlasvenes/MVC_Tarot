package view;

import controler.TarotControler;
import model.TarotModel;

import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JFrame;

public abstract class ATarotView extends JFrame implements Observer {

	private static final long serialVersionUID = 307012392061471884L;
	
	protected TarotControler 	controler;
	protected TarotModel		model;
	
	public ATarotView(String title, TarotModel tm, TarotControler tc) {
		super(title);
		model 		= tm;
		controler 	= tc;
		
		setSize(1500, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		
		controler.setMainFrame(this);
		
		validate();
		
		tm.addObserver(this);
		setVisible(true);
	}

}
