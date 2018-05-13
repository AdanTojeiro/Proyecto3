package controladores;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Iterator;

import interfaz.componentes.JOption;

public class OptionListener implements MouseListener {
	
	private JOption opt;
	
	
	
	
	public OptionListener(JOption opt ){
		super();
		this.opt = opt;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Iterator<JOption> it = opt.getGrupo().getGrupo().iterator();
		while(it.hasNext()) {
			JOption o = it.next();
			if(!o.equals(opt)) {
				o.setSelected(false);
			}
		}
		opt.setSelected(true);
		if(opt.getDisplay() == null) {
			System.out.println("falla");
		}
		opt.getDisplay().getGrupo().getVentana().getFocusFixer().requestFocus();
		opt.getDisplay().getGrupo().mostarDisplay(opt.getDisplay());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		opt.setBackground(opt.getCOLOR_HOVER());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(opt.isSelected()) {
		 opt.setBackground(opt.getCOLOR_SELECTED());
		}else {
			opt.setBackground(opt.getCOLOR_BACKGROUND());
		}	
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
