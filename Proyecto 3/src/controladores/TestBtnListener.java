package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaz.Ventana;

public class TestBtnListener implements MouseListener {
	
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	private Ventana ventana;
	
	

	public TestBtnListener(Ventana ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ventana.setTestActual(ventana.getGestorTest().empezarTest(ventana.getSesionActual().getUsuario()));
		ventana.actualizarPregunta(ventana.getGestorTest().getPreguntaDisponible(ventana.getTestActual()));
		
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
