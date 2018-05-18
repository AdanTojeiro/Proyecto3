package interfaz.componentes;

import javax.swing.JLabel;

public class JChanger extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String ico_path, ico_hover, tipo, estado;

	public JChanger(String ico_path, String ico_hover, String tipo, String estado) {
		super();
		this.ico_path = ico_path;
		this.ico_hover = ico_hover;
		this.tipo = tipo;
		this.estado = estado;
	}

	public String getIco_path() {
		return ico_path;
	}

	public void setIco_path(String ico_path) {
		this.ico_path = ico_path;
	}

	public String getIco_hover() {
		return ico_hover;
	}

	public void setIco_hover(String ico_hover) {
		this.ico_hover = ico_hover;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
