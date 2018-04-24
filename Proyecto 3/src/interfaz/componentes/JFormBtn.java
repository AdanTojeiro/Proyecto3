package interfaz.componentes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import interfaz.grupos.TextFieldGroup;

public class JFormBtn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	private final Color COLOR_DISABLED = new Color(128, 128, 128);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	ArrayList<TextFieldGroup> grupo_logico;
	
	private String function;
	
	
	
	public JFormBtn(String function, ArrayList<TextFieldGroup> grupo_logico) {
		super();
		this.function = function;
		this.grupo_logico = grupo_logico;
		
	}

	public void setStatus() {
		if(this.isEnabled()) {
			this.setBackground(COLOR_CHECK);
		} else {
			this.setBackground(COLOR_DISABLED);
		}
	}

	public Color getCOLOR_CHECK() {
		return COLOR_CHECK;
	}

	public Color getCOLOR_DISABLED() {
		return COLOR_DISABLED;
	}

	public Color getCOLOR_HOVER() {
		return COLOR_HOVER;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	

	public boolean isGroupAllTrue() {
		Iterator<TextFieldGroup> it = grupo_logico.iterator();
		boolean control = true;
		TextFieldGroup tFGroup;
		while(it.hasNext()) {
			tFGroup = it.next();
			if(!tFGroup.isCheck()) {
				control = false;
			}
		}
		return control;
	}
	
	
	
	
	
	

}
