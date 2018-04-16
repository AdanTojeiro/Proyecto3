package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPopUpPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel ico, text;
	private JLabelControl control;
	private final Color COLOR_ERROR = new Color(219, 186, 70, 150);
	private final Color COLOR_CHECK = new Color(50, 205, 50, 150);
	
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

	public JLabelControl getControl() {
		return control;
	}

	public void setControl(JLabelControl control) {
		this.control = control;
	}

	

	
	
}
