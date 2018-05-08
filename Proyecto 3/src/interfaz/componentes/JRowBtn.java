package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;

import controladores.JRowBtnListener;
import interfaz.Ventana;

public class JRowBtn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	private Ventana ventana;
	
	private JLabel text;
	private int pk_usuario;
	
	public JRowBtn(int pk_usuario, Ventana ventana) {
		this.ventana = ventana;
		this.pk_usuario = pk_usuario;
		this.setBackground(COLOR_CHECK);
		text  = new JLabel("Inspeccionar");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(text);
		this.addMouseListener(new JRowBtnListener(this, this.ventana));
		
	}

	public Color getCOLOR_CHECK() {
		return COLOR_CHECK;
	}

	public Color getCOLOR_HOVER() {
		return COLOR_HOVER;
	}

	public int getPk_usuario() {
		return pk_usuario;
	}

	public void setPk_usuario(int pk_usuario) {
		this.pk_usuario = pk_usuario;
	}
	
	
	
	
	

}
