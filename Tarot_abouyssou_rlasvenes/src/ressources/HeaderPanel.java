package ressources;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import customRessources.CButton;

public class HeaderPanel extends JPanel {

	private static final long serialVersionUID = 396698955264125256L;
	
	protected CButton action1 = new CButton("Flip cards"		, CButton.MY_MEDIUM_MARGIN);
	protected CButton action2 = new CButton("Passer"			, CButton.MY_MEDIUM_MARGIN);
	protected CButton action3 = new CButton("Constituer écart"	, CButton.MY_MEDIUM_MARGIN);

	public HeaderPanel() {
		super();
		
		setBackground(Color.CYAN.darker().darker());
		
		// Layout pour espacement entre les boutons
		FlowLayout flow = new FlowLayout();
		flow.setHgap(5);
		flow.setVgap(5);
		flow.setAlignment(FlowLayout.CENTER);
		
		setLayout(flow);
		
		add(action1);
		add(action2);
		add(action3);
	}	
}
