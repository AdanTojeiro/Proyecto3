package interfaz.componentes;

import java.awt.Color;
import javax.swing.JPanel;
import interfaz.grupos.OptionGroup;

public class JOption extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean selected;
	private JDisplay display;
	private String text;
	private String ico_path;
	private OptionGroup grupo;
	private final Color COLOR_HOVER = new Color(110, 89, 222);
    private final Color COLOR_SELECTED = new Color(85, 65, 118);
    private final Color COLOR_BACKGROUND = new Color(54,33,89);
   
	
	
	
	public JOption(JDisplay display, String text, String ico_path, OptionGroup grupo) {
		super();
		this.display = display;
		this.text = text;
		this.ico_path = ico_path;
		this.grupo = grupo;
		grupo.addOption(this);

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

	public OptionGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(OptionGroup grupo) {
		this.grupo = grupo;
	}

	
	
	

}
