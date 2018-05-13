package interfaz.listas;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import clases.Consulta;
import clases.Usuario;
import interfaz.Ventana;
import interfaz.componentes.JRowPanel;

public class JConsultaRowList extends JRowList{

	private ArrayList<Consulta> lista;
	private JPanel contenedor;
	private Ventana ventana;
	
	
	
	public JConsultaRowList(ArrayList<Consulta> lista, JPanel contendor, Ventana ventana) {
		super();
		this.lista = lista;
		this.contenedor = contendor;
		this.ventana = ventana;
	}

	
	public void cargarLista() {
		if(lista.size() < 7) {
			contenedor.setLayout(new GridLayout(9, 1, 0, 20));
		} else {
			contenedor.setLayout(new GridLayout(0, 1, 0, 20));
		}
		Iterator<Consulta> it = lista.iterator();
		contenedor.add(new JRowPanel("NICK", "ACESSO", "ASUNTO", "FECHA", "  "));
		while(it.hasNext()) {
			contenedor.add(new JRowPanel(it.next(), ventana));
			
		}
	}
	
	public void limpiarLista() {
		contenedor.removeAll();
		lista = null;
		contenedor.setVisible(false);
		contenedor.setVisible(true);
	}


	public void setLista(ArrayList<Consulta> lista) {
		this.lista = lista;
	}
}
