package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JPanel;
import controler.TarotControler;
import customRessources.CButton;
import model.TarotModel;

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
		initListeners();
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

	private void initListeners() {
		btnPlay.addActionListener(this);
		btnRules.addActionListener(this);
		btnQuit.addActionListener(this);

		validate();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPlay) {
			controler.launchGame(this, model, controler);
		}
		else if (e.getSource() == btnRules) {
			controler.displayRules(this);
		}
		else if (e.getSource() == btnQuit) {
			controler.exitApplication(this);
		}
	}
}
