package interfaz.componentes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.Ventana;

public class JPopUp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel ico, text;
	private JControlLabel control;
	private final Color COLOR_ERROR = new Color(219, 186, 70);
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	
	public void showPanel(String text, String ico_path) {
		this.setVisible(true);
		this.text.setText(text);
		this.ico.setIcon(new ImageIcon(Ventana.class.getResource(ico_path)));
		

	}
	
	public void errorStyle() {
		text.setForeground(Color.BLACK);
		this.setBackground(COLOR_ERROR);
	
		
	}
	public void infoStyle() {
		text.setForeground(Color.WHITE);
		this.setBackground(COLOR_CHECK);
		
		
	}
	
	public JLabel getIco() {
		return ico;
	}

	public void setIco(JLabel ico) {
		this.ico = ico;
	}

	public JLabel getText() {
		return text;
	}

	public void setText(JLabel text) {
		this.text = text;
	}

	public JControlLabel getControl() {
		return control;
	}

	public void setControl(JControlLabel control) {
		this.control = control;
	}

	

	
	
}
