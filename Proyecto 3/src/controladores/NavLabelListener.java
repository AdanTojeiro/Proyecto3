package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import interfaz.Ventana;
import interfaz.componentes.JNavLabel;

public class NavLabelListener implements MouseListener {
	
	private JNavLabel navLabel;
	private Ventana ventana;
	
	
	
	public NavLabelListener(JNavLabel navLabel, Ventana ventana) {
		super();
		this.navLabel = navLabel;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ventana.setRegDisplay(navLabel.getActualIndex(), navLabel.getFunction());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		navLabel.setIcon(new ImageIcon(Ventana.class.getResource(navLabel.getIco_hover_path())));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		navLabel.setIcon(new ImageIcon(Ventana.class.getResource(navLabel.getIco_path())));
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
