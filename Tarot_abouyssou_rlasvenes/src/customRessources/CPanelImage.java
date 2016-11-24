package customRessources;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CPanelImage extends JPanel {

	private static final long serialVersionUID = -3214038976769781687L;
	
	private BufferedImage backgroudnImg = null;
	private Integer width = null, height = null;
	
	public CPanelImage(String path) {
		try {
			backgroudnImg = ImageIO.read(new File(path));
			width 	= backgroudnImg.getWidth();
			height	= backgroudnImg.getHeight();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroudnImg, 0, 0, this);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("test");
		f.setSize(500, 500);
		f.setPreferredSize(new CPanelImage("img/ressources-100/tapis.jpg").getPreferredSize());
		f.pack();
		f.setLocationRelativeTo(null);
		f.add(new CPanelImage("img/ressources-100/tapis.jpg"));
		f.setVisible(true);
	}
}
