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

public class Card extends CButton implements ActionListener {

	private static final long serialVersionUID = 3234893766917389503L;

	private BufferedImage 			imageRecto;
	private static BufferedImage 	imageVerso;
	private File 			file;
	private JLabel 			label;

	private int 	value;
	private String 	symbole;
	private String	path;

	public Card() throws IOException {
		this("img/card.jpg");
	}

	public Card(String path) throws IOException { // constructor used as "blueprint" for delegations
		super(null, CButton.NULL_MARGIN);
		this.path = path;
		
		try {
			file 		= new File(path); // get the file located at "path"
			imageRecto 	= ImageIO.read(file); // load the image from file
			imageVerso  = ImageIO.read(new File("img/ressources-100/cache.jpg"));
			
			
			label 		= new JLabel(new ImageIcon(imageVerso.getScaledInstance(imageVerso.getWidth()/2, imageVerso.getHeight()/2, 1))); // and create the image
			label.setSize(imageRecto.getWidth(null), imageRecto.getHeight(null));
			
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
			
			add(label); // first add -> so component[0]
			addActionListener(this);
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage() + " :\n" + path, "Exception raised !", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Card(String path, int value, String symbole) throws IOException {
		this(path);
		this.setValue(value);
		this.setSymbole(symbole);
	}
	
	public void flip() {
		label.setIcon(new ImageIcon(imageRecto.getScaledInstance(imageRecto.getWidth()/2, imageRecto.getHeight()/2, 2)));
	}
	
	public void flipDelay(int millis) throws InterruptedException {
		Thread.sleep(millis);
		flip();
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
		return (getValue() + " : " + getSymbole());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		flip();
	}
}
