package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controler.TarotControler;
import customRessources.CButton;
import model.TarotModel;
import ressources.BottomPanel;
import ressources.HeaderPanel;

public class TarotViewMenu extends ATarotView implements ActionListener {

	private static final long serialVersionUID = -1554923287140530650L;

	protected JPanel 	header 		= new JPanel();

	protected JPanel 	fixedPanel 	= new JPanel(new GridBagLayout());
	protected JPanel 	jpanel 		= new JPanel();
	protected CButton	btnPlay		= new CButton("Lancer le jeu"	, CButton.MY_MEDIUM_MARGIN);
	protected CButton	btnRules	= new CButton("Les règles"		, CButton.MY_MEDIUM_MARGIN);
	protected CButton 	btnQuit		= new CButton("Quitter"			, CButton.MY_MEDIUM_MARGIN); 

	public TarotViewMenu(String title, TarotModel tm, TarotControler tc) {
		super(title, tm, tc);
		initGUI();
		initListeners(tm, tc);
	}

	private void initGUI() {
		Insets margin = new Insets(20, 150, 20, 150);
		btnPlay.setMargin(margin);
		btnRules.setMargin(margin);
		btnQuit.setMargin(margin);

		fixedPanel.setPreferredSize(this.getSize());

		// ---------------- Contraintes/alignements ----------------

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		// ------------ JPanel central (dans le JFrame) ------------

		jpanel.setLayout(new GridBagLayout());
		jpanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		jpanel.setBackground(Color.GRAY);
		jpanel.add(btnPlay , gbc);
		jpanel.add(btnRules, gbc);
		jpanel.add(btnQuit , gbc);	

		// --------------- Composition de la JFrame ----------------

		fixedPanel.add(jpanel);
		this.add(fixedPanel);
	}

	private void initListeners(TarotModel tm, TarotControler tc) {
		btnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// on réinitialise le Panel conteneur principale
					getContentPane().removeAll();

					// on ajoute notre nouvel vue locale pour le jeu (toujours dans la même frame)
					add(new TarotLocalViewGame(tm, tc));
					add(new HeaderPanel(), BorderLayout.PAGE_START);
					add(new BottomPanel(), BorderLayout.PAGE_END);
					
					// on rafraichit notre fenêtre et on valide ses composants
					revalidate();
					repaint();
				}
				catch (IOException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		btnRules.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				getContentPane().removeAll();

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.insets = new Insets(10, 10, 10, 10);


				JPanel pan = new JPanel(new GridBagLayout());
				JLabel lab = new JLabel("Voici quelques règles élémentaires du Tarot : ");
				JLabel lab2 = new JLabel("<html><p style = \"text-align: center; \">- Vous devez perdre ! Le petit chien n'a pas le droit de se faire enculer à sec avec du gravier !</p></html>");
				lab2.setFont(new Font("Gentium", Font.BOLD, 32));
				lab.setFont(new Font("Gentium", Font.BOLD, 32));
				lab.setForeground(Color.RED);
				lab2.setForeground(Color.BLUE);

				lab2.setHorizontalAlignment(JLabel.CENTER);
				pan.add(lab, gbc);
				pan.add(lab2, gbc);
				add(pan, BorderLayout.NORTH);

				revalidate();
				repaint();
			}
		});

		btnQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.out.println("You quit the application...");
			}
		});

		validate();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// do nothing
	}
}
