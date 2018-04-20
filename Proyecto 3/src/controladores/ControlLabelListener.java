package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import interfaz.JLabelControl;
import interfaz.Ventana;



public class ControlLabelListener  implements MouseListener {
	
	private JLabelControl lbl;
	private Ventana ventana;
	
	
	
	
	public ControlLabelListener(JLabelControl lbl, Ventana ventana) {
		this.lbl = lbl;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(lbl.getFunction()) {
		case 0:
			if(ventana.getSesionActual() != null) {
				Timestamp tiempo_final =  new Timestamp(new java.util.Date().getTime());
				String where = "nick='"+ventana.getSesionActual().getUsuario().getNick()+"'";
				ventana.getMysqlc().Update("usuario", "estado='offline'",where);
				ventana.getMysqlc().Update("sesion", "tiempo_final='"+tiempo_final+"'", "codigo='"+ventana.getSesionActual().getCodigo()+"'");
			}
			System.exit(0);
			break;
		case 1:
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