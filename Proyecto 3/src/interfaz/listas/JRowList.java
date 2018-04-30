package interfaz.listas;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import clases.Usuario;
import interfaz.JRowPanel;

public class JRowList {
	
	private ArrayList<Usuario> lista;
	private JPanel contenedor;
	
	
	
	public JRowList(ArrayList<Usuario> lista, JPanel contendor) {
		super();
		this.lista = lista;
		this.contenedor = contendor;
	}

	
	public void cargarLista() {
		if(lista.size() < 8) {
			contenedor.setLayout(new GridLayout(9, 1, 0, 20));
		} else {
			contenedor.setLayout(new GridLayout(0, 1, 0, 20));
		}
		Iterator<Usuario> it = lista.iterator();
		while(it.hasNext()) {
			contenedor.add(new JRowPanel(it.next()));
			
		}
	}
	
	public void limpiarLista() {
		contenedor.removeAll();
		lista = null;
		contenedor.setVisible(false);
		contenedor.setVisible(true);
	}


	public void setLista(ArrayList<Usuario> lista) {
		this.lista = lista;
	}
	
	

}
