package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Consulta;
import clases.Usuario;
import interfaz.Ventana;
import interfaz.componentes.JRowBtn;

public class JRowBtnListener implements MouseListener {
	
	private JRowBtn btn;
	private Ventana ventana;
	
	

	public JRowBtnListener(JRowBtn btn, Ventana ventana) {
		super();
		this.btn = btn;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ventana.getFocusFixer().requestFocus();
		switch(btn.getTipo()) {
		case "usuario":
			ResultSet rsu = ventana.getGestorUsuarios().getUsuario("pk_usuario", ""+btn.getPk());
			try {
				if(rsu.next()) {
					Usuario  usuario=  new Usuario(rsu);
					ventana.setUsuarioInspeccionado(usuario);
					ventana.actualizarMostraUsuario(usuario);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "consulta":
			ResultSet rsc = ventana.getGestorConsultas().getConsulta("pk_consulta ="+btn.getPk());
			try {
				if(rsc.next()) {
					Consulta  consulta=  new Consulta(rsc);
					ventana.actualizarMostrarConsulta(consulta);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		}
		
		

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		btn.setBackground(btn.getCOLOR_HOVER());

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		btn.setBackground(btn.getCOLOR_CHECK());

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
