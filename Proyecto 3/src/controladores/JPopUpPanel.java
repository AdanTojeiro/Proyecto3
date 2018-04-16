package controladores;

import java.awt.Color;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPopUpPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel ico, text;
	
	
	public void showPanel(String text, String ico_path) {
		
	}
	
	public void errorStyle() {
		text.setForeground(Color.BLACK);
	}
	public void infoStyle() {
		text.setForeground(Color.WHITE);
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



	
	
}
