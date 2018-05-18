package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import interfaz.Ventana;
import interfaz.componentes.JChanger;

public class ChangerBtnListener implements MouseListener {
	
	JChanger changer;
	Ventana ventana;
	
	

	public ChangerBtnListener(JChanger changer, Ventana ventana) {
		super();
		this.changer = changer;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ventana.getGestorUsuarios().actualizarUsuario(changer.getTipo(), changer.getEstado(), "pk_usuario="+ventana.getUsuarioInspeccionado().getPk_usuario());
		switch(changer.getTipo()) {
		case "acceso":
			ventana.getUsuarioInspeccionado().setAcceso(changer.getEstado());
			break;
		case "estado":
			ventana.getUsuarioInspeccionado().setEstado(changer.getEstado());
			break;	
		}
		ventana.actualizarMostraUsuario(ventana.getUsuarioInspeccionado());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		changer.setIcon(new ImageIcon(Ventana.class.getResource(changer.getIco_hover())));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		changer.setIcon(new ImageIcon(Ventana.class.getResource(changer.getIco_path())));
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
