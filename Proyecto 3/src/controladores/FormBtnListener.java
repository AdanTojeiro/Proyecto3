package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import acceso_a_datos.Encriptador;
import clases.Sesion;
import clases.Usuario;
import interfaz.JFormBtn;
import interfaz.Ventana;

public class FormBtnListener implements MouseListener{
	
	JFormBtn formBtn;
	private Ventana ventana;
	

	public FormBtnListener(JFormBtn formBtn, Ventana ventana) {
		super();
		this.formBtn = formBtn;
		this.ventana = ventana;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (formBtn.isGroupAllTrue()) {
			switch(formBtn.getFunction()) {
			case "reg":
				Encriptador enc = new Encriptador();
				Date fecha = new Date(new java.util.Date().getTime());
				ventana.setRegData();
				Usuario data = ventana.getRegData();
				String nombreTabla = "usuario";
				String campos = "nick, pass, nombre, apellidos, dni, email, fecha_registro, fecha_ultima_sesion";
				String value = "'"+data.getNick()+"', '"+enc.encriptarMD5(data.getPass())+"', '"+data.getNombre()+"', '"+data.getApellidos()+"', '"+data.getDni()+"', '"+data.getEmail()+"', '"+fecha+"', '"+fecha+"'";
				System.out.println(value);
				ventana.getMysqlc().insertInto(nombreTabla, campos, value);
				ventana.resetRegForm();
				ventana.setRegDisplay(2, "back");
				ventana.showPopUp("regcomplete");
				ventana.setDisplay(ventana.getDisplay_login(), ventana.getDisplay_login().getGrupo(),"login");
				break;
			case "login":
				ventana.iniciarSesion(new Sesion(ventana.getLoginResultSet()));
				ventana.showPopUp("logincomplete");
			}	
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(formBtn.isGroupAllTrue()) {
			formBtn.setBackground(formBtn.getCOLOR_HOVER());
			formBtn.setToolTipText("Todo correcto! pulsa aqui para registrarte.");
		} else {
			formBtn.setBackground(formBtn.getCOLOR_DISABLED());
			formBtn.setToolTipText("Algunos de los campos requeridos no estan correctamente complentados.");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		formBtn.setBackground(formBtn.getCOLOR_CHECK());
		
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
