/*package ressources;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.lang.Comparable;

import customRessources.CButton;

public class Card extends CButton implements ActionListener, Comparable<Card> {

	private static final long serialVersionUID = 3234893766917389503L;

	private BufferedImage imageRecto;
	private static BufferedImage imageVerso;
	private File file;
	private JLabel label;

	private int value; // valeur numérique de la carte (ex: 1, 2, 3, ..., 10,
						// etc...)
	private String symbole; // symbole de la carte (ex: Carreau, Trefle, Pique,
							// et Coeur)
	private String path; // contient le chemin de l'image
	private boolean flipped = false; // pour savoir si la carte a été retournée

	// constructeur par défaut, inutile dans cette application, mais utile pour
	// test.
	public Card() throws IOException {
		this("img/card.jpg");
	}

	// constructeur avec un paramètre seuelement (utilisé seulement pour
	// délégation de constructeur)
	public Card(String path) throws IOException { // constructor used as
													// "blueprint" for
													// delegations
		super(null, CButton.NULL_MARGIN);
		this.path = path;

		try {
			file = new File(path); // get the file located at "path"
			imageRecto = ImageIO.read(file); // load the image from file
			imageVerso = ImageIO.read(new File("img/ressources-100/cache.jpg"));

			label = new JLabel(new ImageIcon(
					imageVerso.getScaledInstance(imageVerso.getWidth() / 2, imageVerso.getHeight() / 2, 1))); // and
																												// create
																												// the
																												// image
			label.setSize(imageRecto.getWidth(null), imageRecto.getHeight(null));

			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

			add(label); // first add -> so component[0]
			addActionListener(this);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage() + " :\n" + path, "Exception raised !",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// constructeur le + utile, initialise tout les attributs nécéssaires de
	// notre carte
	public Card(String path, int value, String symbole) throws IOException {
		this(path);
		this.setValue(value);
		this.setSymbole(symbole);
	}

	// méthode pour retourner notre carte (en changeant d'icone)
	public void flip() {
		if (!flipped) {
			label.setIcon(new ImageIcon(
					imageRecto.getScaledInstance(imageRecto.getWidth() / 2, imageRecto.getHeight() / 2, 2)));
			setToolTipText(this.toString());
			flipped = true;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		symbole2FullSymbole();
		return (value + " : " + symbole);
	}

	// Permet de distinguer les Valet, Dames, Roi et Cavalier
	// en fonction de leur valeur numérique "value"
	// et de "renommer" leurs symboles.
	public void symbole2FullSymbole() {

		if (symbole != "Atout" && symbole != "Excuse") {
			switch (value) {
			case 11:
				symbole = "Valet de " + symbole;
				break;

			case 12:
				symbole = "Cavalier de " + symbole;
				break;

			case 13:
				symbole = "Dame de  " + symbole;
				break;

			case 14:
				symbole = "Roi de " + symbole;
				break;

			default:
				break;
			}
		}
	}

	// Une carte = un bouton; si on clique dessus, on flip la carte.
	@Override
	public void actionPerformed(ActionEvent e) {
		flip();
	}

	@Override
	public int compareTo(Card o) {
		if (this.getValue() < o.getValue())
			return -1;
		else if (this.getValue() == o.getValue())
			return 0;
		else if (this.getValue()> o.getValue())
			return 1;
		return 42;
		
		/*	int returnValue = 0;
		switch(this.getSymbole()){
			
			
		case "Pique":
			if(o.getSymbole()=="Pique")
				
				if(this.getValue()<o.getValue())
					returnValue=-1;
			
				else if(this.getValue()==o.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			
			else
				returnValue=-1;
			
			break;
			
			
			
		case "Coeur":
			
			if(o.getSymbole()=="Pique")
					returnValue=1;
	
			else if(o.getSymbole()=="Coeur")
				
				if(this.getValue()<o.getValue())
					returnValue=-1;
			
				else if(this.getValue()==o.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			
			else 
				returnValue=-1;
			
			break;
			
		case "Carreau":
			
			if(o.getSymbole()=="Pique" || o.getSymbole()=="Coeur")
				returnValue=1;
			
			else if(o.getSymbole()=="Carreau")
				
				if(this.getValue()<o.getValue())
					returnValue=-1;
			
				else if(this.getValue()==o.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			else 
				
				returnValue=-1;
			
			break;
			
		case "Trefle":
			
			if(o.getSymbole()=="Pique" || o.getSymbole()=="Coeur" || o.getSymbole()=="Carreau")
				returnValue=1;
			
			else if(o.getSymbole()=="Trefle")
			
				if(this.getValue()<o.getValue())
					returnValue=-1;
			
				else if(this.getValue()==o.getValue())
					returnValue=0;
			
				else 
					returnValue=1;
			
			else 
				returnValue=-1;
			
			 break;
		
			 
			 
			 default:
			 break;
		}
		
				
			 return returnValue;

	}

	}
}*/

package ressources;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import customRessources.CButton;

public class Card extends CButton implements ActionListener, Comparable<Card> {

	private static final long serialVersionUID = 3234893766917389503L;

	private 	BufferedImage 			imageRecto;
	private 	static BufferedImage 	imageVerso;
	private 	File 					file;
	private 	JLabel 					label;

	private 	int 					value; // valeur numérique de la carte (ex: 1, 2, 3, ..., 10, etc...)
	private 	String 					symbole; // symbole de la carte (ex: Carreau, Trefle, Pique, et Coeur)
	private 	int 					rank;
	private 	String					path; // contient le chemin de l'image
	private 	boolean 				flipped = false; // pour savoir si la carte a été retournée

	// constructeur par défaut, inutile dans cette application, mais utile pour test.
	public Card() throws IOException {
		this("img/card.jpg");
	}

	// constructeur avec un paramètre seuelement (utilisé seulement pour délégation de constructeur)
	public Card(String path) throws IOException { // constructor used as "blueprint" for delegations
		super(null, CButton.NULL_MARGIN);
		this.path = path;

		try {
			file 		= new File(path); // get the file located at "path"
			imageRecto 	= ImageIO.read(file); // load the image from file
			imageVerso  = ImageIO.read(new File("img/ressources-100/cache.jpg"));


			label 		= new JLabel(new ImageIcon(imageVerso.getScaledInstance(imageVerso.getWidth()/2, imageVerso.getHeight()/2, 1))); // and create the image
			label.setSize(imageRecto.getWidth(null), imageRecto.getHeight(null));

			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

			add(label); // first add -> so component[0]
			addActionListener(this);
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage() + " :\n" + path, "Exception raised !", JOptionPane.ERROR_MESSAGE);
		}
	}

	// constructeur le + utile, initialise tout les attributs nécéssaires de notre carte
	public Card(String path, int value, String symbole) throws IOException {
		this(path);
		this.setValue(value);
		this.setSymbole(symbole);
	}

	// méthode pour retourner notre carte (en changeant d'icone)
	public void flip() {
		if (!flipped) {
			label.setIcon(new ImageIcon(imageRecto.getScaledInstance(imageRecto.getWidth()/2, imageRecto.getHeight()/2, 2)));
			setToolTipText(this.toString());
			flipped = true;
		}
	}
	
	public boolean isFlipped() {
		return flipped;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		//symbole2FullSymbole();
		return (value + " : " + symbole);
	}
	
	// Permet de distinguer les Valet, Dames, Roi et Cavalier
	// en fonction de leur valeur numérique "value"
	// et de "renommer" leurs symboles.
	public void symbole2FullSymbole() {
		
		if (symbole != "Atout" && symbole != "Excuse") {
			switch (value) {
				case 11:
					symbole = "Valet de " + symbole;
					break;
	
				case 12:
					symbole = "Cavalier de " + symbole;
					break;
	
				case 13:
					symbole = "Dame de " + symbole;
					break;
	
				case 14:
					symbole = "Roi de " + symbole;
					break;
	
				default:
					break;
			}
		}
	}
	
	// chaque type de carte correspond à un rang qui va définir la priorité pour l'ordre de tri
	public void initRanks() {
		switch (symbole) {
			case "Pique":
				rank = 1;
				break;
				
			case "Coeur":
				rank = 2;
				break;
				
			case "Carreau":
				rank = 3;
				break;
				
			case "Trefle":
				rank = 4;
				break;

			case "Excuse":
				rank = 5;
				break;
				
			case "Atout":
				rank = 6;
				break;
	
			default:
				break;
		}
	}
	
	public int getRank() {
		return rank;
	}

	// Une carte = un bouton; si on clique dessus, on flip la carte.
	@Override
	public void actionPerformed(ActionEvent e) {
		flip();
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
