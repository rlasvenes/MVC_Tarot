package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;

import controler.TarotControler;
import model.TarotModel;

public class TarotViewGame extends ATarotView implements ActionListener{

	private static final long serialVersionUID = -3216945101359899037L;

	public TarotViewGame(String title, TarotModel tm, TarotControler tc) {
		super(title, tm, tc);
		JPanel jp = new JPanel(new GridBagLayout());
		
		add(jp, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
