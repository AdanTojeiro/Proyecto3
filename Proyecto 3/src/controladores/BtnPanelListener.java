package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import acceso_a_datos.Encriptador;
import clases.Usuario;
import interfaz.JBtnPanel;
import interfaz.Ventana;

public class BtnPanelListener implements MouseListener{
	
	JBtnPanel btnPanel;
	private Ventana ventana;
	

	public BtnPanelListener(JBtnPanel btnPanel, Ventana ventana) {
		super();
		this.btnPanel = btnPanel;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(btnPanel.getFunction()) {
		case "reg":
			Encriptador enc = new Encriptador();
			Date fecha = new Date(new java.util.Date().getTime());
			ventana.setRegData();
			Usuario data = ventana.getRegData();
			System.out.println(data.getNick());
			String nombreTabla = "usuario";
			String campos = "nick, pass, nombre, apellidos, dni, email, fecha_registro, fecha_ultima_sesion";
			String value = "'"+data.getNick()+"', '"+enc.encriptarMD5(data.getPass())+"', '"+data.getNombre()+"', '"+data.getApellidos()+"', '"+data.getDni()+"', '"+data.getEmail()+"', '"+fecha+"', '"+fecha+"'";
			System.out.println(value);
			ventana.getMysqlc().insertInto(nombreTabla, campos, value);
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		btnPanel.setBackground(btnPanel.getCOLOR_HOVER());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		btnPanel.setBackground(btnPanel.getCOLOR_CHECK());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
