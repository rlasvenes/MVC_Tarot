package tarot;

import java.io.IOException;

import controler.TarotControler;
import model.TarotModel;
import view.TarotViewMenu;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Main du tarot : utiliser Comparator et Comparable<Card>");
		
		TarotModel 		m 	= new TarotModel();
		TarotControler 	c 	= new TarotControler(m);

		TarotViewMenu view 	= new TarotViewMenu("Tarot - [abouyssou / rlasvenes] Groupe = { S3A } ", m, c);
		m.addObserver(view);
	}
}