package ressources;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import customRessources.CButton;

public class BottomPanel extends JPanel {

	private static final long serialVersionUID = 8360486961489971790L;

	protected CButton validate = new CButton("Valider", CButton.MY_MEDIUM_MARGIN);
	
	public BottomPanel() {
		super();
		
		add(validate, BorderLayout.PAGE_END);
	}
}
