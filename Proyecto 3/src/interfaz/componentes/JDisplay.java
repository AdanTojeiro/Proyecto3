package interfaz.componentes;

import javax.swing.JPanel;

import interfaz.grupos.DisplayGroup;

public class JDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String icoPath;
	private DisplayGroup grupo; 
	
	public JDisplay(String titulo, String icoPath,  DisplayGroup grupo) {
		super();
		this.titulo = titulo;
		this.icoPath = icoPath;
		this.grupo = grupo;
		grupo.addDisplay(this);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIcoPath() {
		return icoPath;
	}

	public void setIcoPath(String icoPath) {
		this.icoPath = icoPath;
	}

	public DisplayGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(DisplayGroup grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	
	

}
