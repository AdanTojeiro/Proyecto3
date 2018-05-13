package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import clases.Consulta;
import clases.Usuario;
import interfaz.Ventana;

public class JRowPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel col1, col2, col3, col4, col5;
	private JRowBtn editar_btn;
	
	
	

	
	

	public JRowPanel(String col1t, String col2t, String col3t, String col4t, String col5t) {
		super();
		
		this.setLayout(new GridLayout(1, 5, 10, 2));
		this.setOpaque(false);
		this.setBounds(0, 0, 780, 50);
		
		col1 = new JLabel(col1t);
		this.add(col1);
		col1.setForeground(Color.WHITE);
		col1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		col2 = new JLabel(col2t);
		this.add(col2);
		col2.setForeground(Color.WHITE);
		col2.setFont(new Font("Tahoma", Font.BOLD, 18));
	

		col3 = new JLabel(col3t);
		this.add(col3);
		col3.setBounds(0, 0, 70, 50);
		col3.setForeground(Color.WHITE);
		col3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		col4 = new JLabel(col4t);
		this.add(col4);
		col4.setBounds(0, 0, 70, 50);
		col4.setForeground(Color.WHITE);
		col4.setFont(new Font("Tahoma", Font.BOLD, 18));
		//col4.setHorizontalAlignment(SwingConstants.CENTER);
		col4.setVerticalAlignment(SwingConstants.CENTER);
		
		col5 = new JLabel(col5t);
		this.add(col5);
		col5.setBounds(0, 0, 70, 50);
		col5.setForeground(Color.WHITE);
		col5.setFont(new Font("Tahoma", Font.BOLD, 18));
		col5.setHorizontalAlignment(SwingConstants.CENTER);
		col5.setVerticalAlignment(SwingConstants.CENTER);
	}

	public JRowPanel(Usuario usuario, Ventana ventana) {
		
		this.setLayout(new GridLayout(1, 4, 10, 2));
		this.setOpaque(false);
		this.setBounds(0, 0, 780, 50);
		
		col1 = new JLabel("<html>"+usuario.getNick());
		this.add(col1);
		col1.setForeground(Color.WHITE);
		col1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		col2 = new JLabel(usuario.getDni());
		this.add(col2);
		col2.setForeground(Color.WHITE);
		col2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
		
		
		String accesoText = "";
		switch(usuario.getAcceso()) {
		case "alumno":
			accesoText = "Alumno";
			break;
		case "profesor":
			accesoText = "Profesor";
			break;
		case "administrador":
			accesoText = "Administrador";
			break;
		case "desarrollador":
			accesoText = "Desarrollador";
			break;
		}
		
		col3 = new JLabel(accesoText);
		this.add(col3);
		col3.setBounds(0, 0, 70, 50);
		col3.setForeground(Color.WHITE);
		col3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		col4 = new JLabel(usuario.getEstado());
		this.add(col4);
		col4.setBounds(0, 0, 70, 50);
		col4.setForeground(Color.WHITE);
		col4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//col4.setHorizontalAlignment(SwingConstants.CENTER);
		col4.setVerticalAlignment(SwingConstants.CENTER);
		
		
		editar_btn = new JRowBtn(usuario.getPk_usuario(), ventana, "usuario");
		this.add(editar_btn);	
	}

	public JRowPanel(Consulta consulta, Ventana ventana) {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(1, 5, 10, 2));
		this.setOpaque(false);
		this.setBounds(0, 0, 780, 50);
		
		col1 = new JLabel("<html>"+consulta.getUsuario().getNick());
		this.add(col1);
		col1.setForeground(Color.WHITE);
		col1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		String accesoText = "";
		switch(consulta.getUsuario().getAcceso()) {
		case "alumno":
			accesoText = "Alumno";
			break;
		case "profesor":
			accesoText = "Profesor";
			break;
		case "administrador":
			accesoText = "Administrador";
			break;
		case "desarrollador":
			accesoText = "Desarrollador";
			break;
		default:
			accesoText = "Invitado";
		}
		
		
		col2 = new JLabel(accesoText);
		this.add(col2);
		col2.setForeground(Color.WHITE);
		col2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		
		col3 = new JLabel(consulta.getAsunto().length()<16?consulta.getAsunto():consulta.getAsunto().substring(0, 16));
		this.add(col3);
		col3.setBounds(0, 0, 70, 50);
		col3.setForeground(Color.WHITE);
		col3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		col4 = new JLabel(consulta.getFecha().toString().substring(0, 16));
		this.add(col4);
		col4.setBounds(0, 0, 70, 50);
		col4.setForeground(Color.WHITE);
		col4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//col4.setHorizontalAlignment(SwingConstants.CENTER);
		col4.setVerticalAlignment(SwingConstants.CENTER);
		
		
		editar_btn = new JRowBtn(consulta.getPk_consulta(), ventana, "consulta");
		this.add(editar_btn);	
	}

}
