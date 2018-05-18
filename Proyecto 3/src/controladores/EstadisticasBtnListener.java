package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import clases.Usuario;
import interfaz.Ventana;

public class EstadisticasBtnListener implements MouseListener {

	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	private Ventana ventana;
	
	

	public EstadisticasBtnListener(Ventana ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Usuario usuario = ventana.getUsuarioInspeccionado();
		int numeroTest = ventana.getGestorTest().getNumeroTest(usuario);
		int numeroAprobados = ventana.getGestorTest().getNumeroAprobados(usuario);
		float mediaFallos = ventana.getGestorTest().getMediaFallos(usuario);
		ventana.actualizarMostrarEstadisticas(numeroTest, numeroAprobados, mediaFallos);
		
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
