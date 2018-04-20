package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
				String campos = "nick, pass, nombre, apellidos, dni, email, fecha_registro";
				String value = "'"+data.getNick()+"', '"+enc.encriptarMD5(data.getPass())+"', '"+data.getNombre()+"', '"+data.getApellidos()+"', '"+data.getDni()+"', '"+data.getEmail()+"', '"+fecha+"'";
				System.out.println(value);
				ventana.getMysqlc().insertInto(nombreTabla, campos, value);
				ventana.resetRegForm();
				ventana.setRegDisplay(2, "back");
				ventana.showPopUp("regcomplete");
				ventana.setDisplay(ventana.getDisplay_login(), ventana.getDisplay_login().getGrupo(),"login");
				break;
			case "login":
				ResultSet rs = ventana.getLoginResultSet();
				try {
					if (rs.next()) {
						String estado = rs.getString("estado");
						if(estado.equals("offline")){
							Timestamp tiempo_inicio =  new Timestamp(new java.util.Date().getTime());
							int pk_usuario = rs.getInt("pk_usuario");
							String where = "pk_usuario="+pk_usuario;
							ventana.getMysqlc().Update("usuario", "estado='online'",where);
							Sesion sesion = new Sesion(ventana.getLoginResultSet());
							ResultSet rs2 = ventana.getMysqlc().selectFrom("sesion");
							sesion.generarCodigo(rs2);
							ventana.iniciarSesion(sesion);
							ventana.getMysqlc().insertInto("sesion", "codigo, tiempo_inicio, fk_usuario","'"+sesion.getCodigo()+"', '"+tiempo_inicio+"', "+pk_usuario);
							switch(sesion.getUsuario().getAcceso()) {
							case 0:
								//sesion alumno
								break;
							case 1:
								//sesion profesor
								break;
							case 2:
								//sesion  administrador
								break;
							case 3:
								//sesion desarrollador
								break;
								
							}
							ventana.showPopUp("logincomplete");
						}else {
							switch(estado) {
							case "online":
								ventana.showPopUp("useronline");
								break;
							case "suspendido":
								ventana.showPopUp("usersuspend");
								break;
							}
							
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
