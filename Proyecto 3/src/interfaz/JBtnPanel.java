package interfaz;

import java.awt.Color;

import javax.swing.JPanel;

public class JBtnPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Color COLOR_CHECK = new Color(50, 205, 50);
	private final Color COLOR_DISABLED = new Color(128, 128, 128);
	private final Color COLOR_HOVER = new Color(110, 89, 222);
	
	private String function;
	
	
	
	public JBtnPanel(String function) {
		super();
		this.function = function;
		
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
	
	
	
	

}
