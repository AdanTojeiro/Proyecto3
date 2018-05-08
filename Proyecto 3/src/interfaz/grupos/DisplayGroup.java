package interfaz.grupos;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaz.Ventana;
import interfaz.componentes.JDisplay;



public class DisplayGroup {

	private ArrayList<JDisplay> grupo;
	private JLabel titulo_ico, titulo_text;
	private Ventana ventana;
	
	public DisplayGroup(JLabel titulo_ico, JLabel titulo_text, Ventana ventana) {
		super();
		grupo =  new ArrayList<JDisplay>();
		this.titulo_ico = titulo_ico;
		this.titulo_text = titulo_text;
		this.ventana = ventana;
	}

	public void mostarDisplay(JDisplay display) {
		
		Iterator<JDisplay> it = grupo.iterator();
		while (it.hasNext()) {
			JDisplay d = it.next();
			ventana.getFocusFixer().requestFocus();
			d.setVisible(false);
		}
		display.setVisible(true);
		titulo_ico.setIcon(new ImageIcon(Ventana.class.getResource(display.getIcoPath())));
		titulo_text.setText(display.getTitulo());
	}
	
	public void  addDisplay(JDisplay display) {
		grupo.add(display);
	}

	public ArrayList<JDisplay> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<JDisplay> grupo) {
		this.grupo = grupo;
	}
	
	
	
	
}
