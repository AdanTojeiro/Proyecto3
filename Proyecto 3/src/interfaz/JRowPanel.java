package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import clases.Usuario;

public class JRowPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel nick, dni, acceso, estado;
	private JRowBtn editar_btn;
	

	
	public JRowPanel(Usuario usuario) {
		this.setLayout(new GridLayout(1, 5, 10, 2));
		this.setOpaque(false);
		this.setBounds(0, 0, 780, 50);
		
		nick = new JLabel("<html>"+usuario.getNick());
		this.add(nick);
		nick.setForeground(Color.WHITE);
		nick.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		dni = new JLabel(usuario.getDni());
		this.add(dni);
		dni.setForeground(Color.WHITE);
		dni.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
		
		
		String accesoText = "";
		switch(usuario.getAcceso()) {
		case 0:
			accesoText = "Alumno";
			break;
		case 1:
			accesoText = "Profesor";
			break;
		case 2:
			accesoText = "Administrador";
			break;
		case 3:
			accesoText = "Desarrollador";
			break;
		}
		
		acceso = new JLabel(accesoText);
		this.add(acceso);
		acceso.setBounds(0, 0, 70, 50);
		acceso.setForeground(Color.WHITE);
		acceso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		estado = new JLabel(usuario.getEstado());
		this.add(estado);
		estado.setBounds(0, 0, 70, 50);
		estado.setForeground(Color.WHITE);
		estado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setVerticalAlignment(SwingConstants.CENTER);
		
		
		editar_btn = new JRowBtn(usuario.getPk_usuario());
		this.add(editar_btn);
		
		
		
		

		
		
	}

}
