package interfaz;

import java.util.ArrayList;

import javax.swing.JPanel;

public class JFormDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String titulo, icoPath; 
	private ArrayList<JFormDisplay> grupo;
	private int index;
	private boolean backChecker, nextChecker;
	
	public JFormDisplay(String titulo, String icoPath, ArrayList<JFormDisplay> grupo, int index, boolean backChecker,
			boolean nextChecker) {
		super();
		this.titulo = titulo;
		this.icoPath = icoPath;
		this.grupo = grupo;
		this.index = index;
		this.backChecker = backChecker;
		this.nextChecker = nextChecker;
		grupo.add(this);
	}


	public boolean isBackChecker() {
		return backChecker;
	}


	public void setBackChecker(boolean backChecker) {
		this.backChecker = backChecker;
	}


	public boolean isNextChecker() {
		return nextChecker;
	}


	public void setNextChecker(boolean nextChecker) {
		this.nextChecker = nextChecker;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
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


	public ArrayList<JFormDisplay> getGrupo() {
		return grupo;
	}


	public void setGrupo(ArrayList<JFormDisplay> grupo) {
		this.grupo = grupo;
	}
	
	
	
}
