package interfaz.componentes;

import javax.swing.JPanel;

public class JRespuestaBtn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char indice;
	
	
	public JRespuestaBtn(char indice) {
		super();
		this.indice = indice;
	}


	public char getIndice() {
		return indice;
	}


	public void setIndice(char indice) {
		this.indice = indice;
	}
	
	

}
