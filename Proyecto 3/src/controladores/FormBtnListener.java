package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import interfaz.Ventana;
import interfaz.componentes.JFormBtn;

public class FormBtnListener implements MouseListener {

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
			switch (formBtn.getFunction()) {
			case "reg":
				if (ventana.getGestorUsuarios().registarUsuario(ventana.getRegData())) {
					ventana.resetRegForm();
					ventana.setRegDisplay(2, "back");
					ventana.showPopUp("regcomplete");
					ventana.goTo("display_login");
				} else {
					ventana.showPopUp("mysqlerror");
				}
				break;
			case "login":
				ResultSet rs = ventana.getLoginResultSet();
				try {
					if (rs.next()) {
						String estado = rs.getString("estado");
						if (estado.equals("offline")) {
							int pk_usuario = rs.getInt("pk_usuario");
							String where = "pk_usuario=" + pk_usuario;
							ventana.getGestorUsuarios().actualizarEstadoUsuario("online", where);
							ventana.iniciarSesion(ventana.getGestorSesiones().abrirSesion(rs));
							switch (ventana.getSesionActual().getUsuario().getAcceso()) {
							case 0:
								// sesion alumno
								break;
							case 1:
								// sesion profesor
								break;
							case 2:
								// sesion administrador
								break;
							case 3:
								// sesion desarrollador
								break;

							}
							ventana.showPopUp("logincomplete");
						} else {
							switch (estado) {
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

		if (formBtn.isGroupAllTrue()) {
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
