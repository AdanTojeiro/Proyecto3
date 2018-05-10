package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import interfaz.Ventana;

public class SesionBtnListener implements MouseListener {
	
	private final Color COLOR_BACKGROUND = new Color(54, 33, 89);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	private Ventana ventana;
	
	

	public SesionBtnListener(Ventana ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(ventana.getSesionActual().isSesionPrincipal()) {
			ventana.getGestorSesiones().cerrarSesion(ventana.getSesionActual());
			ventana.cambiarVistaSesion("invitado");
		} else {
			ventana.cambiarVistaSesion(ventana.getSesionActual().getUsuario().getAcceso());
			ventana.getSesionActual().setSesionPrincipal(true);
		}

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
