package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import interfaz.JLabelControl;
import interfaz.Ventana;



public class WindowListener  implements MouseListener {
	
	private JLabelControl lbl;
	private JFrame frame;
	
	
	
	
	public WindowListener(JLabelControl lbl, JFrame frame) {
		this.lbl = lbl;
		this.frame = frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(lbl.getFunction()) {
		case 0:
			System.exit(0);
			break;
		case 1:
			frame.setState(JFrame.ICONIFIED);
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