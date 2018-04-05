package interfaz;

import javax.swing.JLabel;

public class JLabelControl extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pathIco, pathIcoHover;
	private int function;
	
	public JLabelControl(int function, String pathIco, String pathIcoHover) {
		super();
		this.function = function;
		this.pathIco = pathIco;
		this.pathIcoHover = pathIcoHover;
	}

	public String getPathIco() {
		return pathIco;
	}

	public void setPathIco(String pathIco) {
		this.pathIco = pathIco;
	}

	public String getPathIcoHover() {
		return pathIcoHover;
	}

	public void setPathIcoHover(String pathIcoHover) {
		this.pathIcoHover = pathIcoHover;
	}

	public int getFunction() {
		return function;
	}

	public void setFunction(int function) {
		this.function = function;
	}
	
	
	
	
	
	

}
