package interfaz;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JPanelOpt extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean selected;
	private Ventana ventana;
	private JDisplay display;
	private String text;
	private String ico_path;
	private final Color COLOR_HOVER = new Color(110, 89, 222);
    private final Color COLOR_SELECTED = new Color(85, 65, 118);
    private final Color COLOR_BACKGROUND = new Color(54,33,89);
    ArrayList<JPanelOpt> grupo;
	
	
	
	public JPanelOpt(Ventana ventana, JDisplay display, String text, String ico_path, ArrayList<JPanelOpt> grupo) {
		super();
		this.ventana = ventana;
		this.display = display;
		this.text = text;
		this.ico_path = ico_path;
		this.grupo = grupo;
		grupo.add(this);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if (selected){
			this.setBackground(COLOR_SELECTED);
		}else {
			this.setBackground(COLOR_BACKGROUND);
		}
	}

	public JDisplay getDisplay() {
		return display;
	}

	public void setDisplay(JDisplay display) {
		this.display = display;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIco_path() {
		return ico_path;
	}

	public void setIco_path(String ico_path) {
		this.ico_path = ico_path;
	}

	public Color getCOLOR_HOVER() {
		return COLOR_HOVER;
	}

	public Color getCOLOR_SELECTED() {
		return COLOR_SELECTED;
	}

	public Color getCOLOR_BACKGROUND() {
		return COLOR_BACKGROUND;
	}

	public ArrayList<JPanelOpt> getGrupo() {
		return grupo;
	}

	public Ventana getVentana() {
		return ventana;
	}
	
	
	

}
