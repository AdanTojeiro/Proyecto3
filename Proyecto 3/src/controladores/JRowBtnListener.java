package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaz.JRowBtn;
import interfaz.Ventana;

public class JRowBtnListener implements MouseListener {
	
	private JRowBtn btn;
	private Ventana ventana;
	
	

	public JRowBtnListener(JRowBtn btn, Ventana ventana) {
		super();
		this.btn = btn;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		btn.setBackground(btn.getCOLOR_HOVER());

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		btn.setBackground(btn.getCOLOR_CHECK());

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
