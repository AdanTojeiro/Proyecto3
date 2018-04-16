package controladores;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Iterator;

import interfaz.JPanelOpt;

public class OptionListener implements MouseListener {
	
	private JPanelOpt opt;
	
	
	
	
	public OptionListener(JPanelOpt opt ){
		super();
		this.opt = opt;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Iterator<JPanelOpt> it = opt.getGrupo().iterator();
		while(it.hasNext()) {
			JPanelOpt o = it.next();
			if(!o.equals(opt)) {
				o.setSelected(false);
			}
		}
		opt.setSelected(true);
		opt.getVentana().setDisplay(opt.getDisplay(), opt.getDisplay().getGrupo());
		
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
