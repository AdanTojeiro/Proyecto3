package interfaz.grupos;

import java.util.ArrayList;

import javax.swing.JPanel;

import interfaz.componentes.JOption;

public class OptionGroup {
	
	private JPanel nav_panel;
	private ArrayList<JOption> grupo;
	
	public OptionGroup() {
		super();
		this.grupo = new ArrayList<JOption>();
	}

	public void mostarNavPanel() {
		nav_panel.setVisible(true);
	}
	
	public void ocultarNavPanel() {
		nav_panel.setVisible(false);
	}
	
	public void  addOption(JOption option) {
		grupo.add(option);
	}

	public JPanel getNav_panel() {
		return nav_panel;
	}

	public void setNav_panel(JPanel nav_panel) {
		this.nav_panel = nav_panel;
	}

	public ArrayList<JOption> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<JOption> grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	
	
	
	
}
