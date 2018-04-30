package interfaz;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class JRowBtn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	private JLabel text;
	private int pk_usuario;
	
	public JRowBtn(int pk_usuario) {
		this.pk_usuario = pk_usuario;
		this.setBackground(COLOR_CHECK);
		text  = new JLabel("Inspeccionar");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(text);
		
	}
	
	

}
