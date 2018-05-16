package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

import interfaz.Ventana;
import interfaz.componentes.JControlLabel;



public class ControlLabelListener  implements MouseListener {
	
	private JControlLabel lbl;
	private Ventana ventana;
	
	
	
	
	public ControlLabelListener(JControlLabel lbl, Ventana ventana) {
		this.lbl = lbl;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(lbl.getFunction()) {
		case 0:
			if(ventana.getSesionActual() != null) {
				ventana.getGestorSesiones().cerrarSesion(ventana.getSesionActual());
			}
			try {
				ventana.cerrarConexion();
			}catch(NullPointerException err) {
				
			}
			
			System.exit(0);
			break;
		case 1:
			ventana.getFocusFixer().requestFocus();
			ventana.getFrame().setState(JFrame.ICONIFIED);
			break;
		case 2:
			ventana.hidePopUp();
			break;
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			lbl.setIcon(new ImageIcon(Ventana.class.getResource(lbl.getPathIcoHover())));
		
		
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
			lbl.setIcon(new ImageIcon(Ventana.class.getResource(lbl.getPathIco())));
	
		
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