package ressources;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Card extends JPanel {

	private static final long serialVersionUID = 3234893766917389503L;

	private BufferedImage 	image;
	private File 			file;
	private JLabel 			label;

	private int value;
	private int color;

	public Card() throws IOException {
		this("img/card.jpg");
	}

	public Card(String path) throws IOException {
		try {
			file 	= new File(path); // get the file located at "path"
			image 	= ImageIO.read(file); // load the image from file

			label 	= new JLabel(new ImageIcon(image)); // and create the image
			label.setSize(image.getWidth(null), image.getHeight(null));
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

			add(label); // first add -> so component[0]
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public Card(String path, int value, int color) throws IOException {
		this(path);
		this.setValue(value);
		this.setColor(color);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

//	public static void main(String[] args) throws IOException {
//		JFrame f = new JFrame("Yu-Gi-OH !");
//		Card c = new Card();
//		f.getContentPane().setPreferredSize(c.getComponent(0).getSize());
//
//		f.add(c);
//		f.pack();
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
//	}
}
