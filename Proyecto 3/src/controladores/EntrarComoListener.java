package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import interfaz.Ventana;

public class EntrarComoListener implements MouseListener {
	
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	private Ventana ventana;
	private JLabel lbl;
	
	public EntrarComoListener(Ventana ventana, JLabel lbl) {
		super();
		this.ventana = ventana;
		this.lbl = lbl;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ventana.cambiarVistaSesion(lbl.getText());
		ventana.getSesionActual().setSesionPrincipal(false);
		ventana.showPopUp("entrarcomo"+lbl.getText());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setBackground(COLOR_HOVER);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setBackground(COLOR_BACKGROUND);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
