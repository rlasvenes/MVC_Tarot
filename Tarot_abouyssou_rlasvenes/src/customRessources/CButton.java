package customRessources;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class CButton extends JButton {

	private static final long serialVersionUID = -1233671002941395259L;
	
	// mes margins personnalisés (gain de code (refactoring) sur l'ensemble de l'appli)
	public static final Insets MY_LARGE_MARGIN 	= new Insets(25, 25, 25, 25);
	public static final Insets MY_MEDIUM_MARGIN = new Insets(10, 10, 10, 10);
	public static final Insets NULL_MARGIN 		= new Insets(0, 0, 0, 0);
	
	public CButton(String title, Insets inset) {
		super(title);
		setMargin(inset);
		setFont(new Font("Gentium", Font.BOLD, 22));
		setFocusable(false);
	}

	public CButton(String title) {
		super(title);
	}
	
	public CButton() {
		super();
	}
	
	public CButton(String title, Icon icon) {
		super(title, icon);
	}
	
	public CButton(Action action) {
		super(action);
	}
}
