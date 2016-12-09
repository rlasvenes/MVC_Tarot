package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controler.TarotControler;
import model.TarotModel;
import ressources.Card;
public class TarotEcartView extends JPanel {

	private static final long serialVersionUID 	= -2539790255028446405L;
	
	private static final int 		NB_SLOTS 	= 6;
	private static final Dimension 	slotDim 	= new Dimension(100, 177);
	private JPanel[] 				slots 		= new JPanel[NB_SLOTS];

	public TarotEcartView(String title, TarotModel tm, TarotControler tc) {
		super();
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(1000, 177 + 10));
		
		initSlots();
	}
	
	public void initSlots() {
		for (int i=0; i<NB_SLOTS; i++) {
			slots[i] = new JPanel();
			slots[i].setPreferredSize(new Dimension(slotDim));
			slots[i].setBackground(Color.BLUE);
			slots[i].setBounds(150, 150, 150, 150);
			
			add(slots[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		TarotModel tm = new TarotModel();
		TarotControler tc = new TarotControler(tm);
		
		TarotEcartView tev = new TarotEcartView("test", tm, tc);
		
		// =====================
		
		JPanel top = new JPanel();
		Card[] actions = new Card[6];
		
		for (int i=0; i<6; i++) {
			actions[i] = new Card();
			
			top.add(actions[i]);
		}
		
		// =====================
		
		JFrame f = new JFrame("test");
		
		f.setSize(1000, 600);
		f.setLocationRelativeTo(null);
		
		f.add(top, BorderLayout.PAGE_START);
		f.add(tev, BorderLayout.PAGE_END);
		
		f.setVisible(true);
	}
}
