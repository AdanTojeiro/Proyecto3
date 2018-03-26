package interfaz;

import java.util.ArrayList;

import javax.swing.JPanel;

public class JDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String icoPath;
	private ArrayList<JDisplay> grupo; 
	
	public JDisplay(String titulo, String icoPath,  ArrayList<JDisplay> grupo) {
		super();
		this.titulo = titulo;
		this.icoPath = icoPath;
		this.grupo = grupo;
		grupo.add(this);
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

	public ArrayList<JDisplay> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<JDisplay> grupo) {
		this.grupo = grupo;
	}
	
	
	
	

}
