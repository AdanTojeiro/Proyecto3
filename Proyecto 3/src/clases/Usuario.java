package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Usuario {

		private String nick, pass, nombre, apellidos, dni, email;
		private Date fecha_registro, fecha_ultima_sesion;
		private int acceso;
		
		public Usuario() {
			
		}
		
		public Usuario(String nick, String pass, String nombre, String apellidos, String dni, String email,
				Date fecha_registro, Date fecha_ultima_sesion) {
			super();
			this.nick = nick;
			this.pass = pass;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.dni = dni;
			this.email = email;
			this.fecha_registro = fecha_registro;
			this.fecha_ultima_sesion = fecha_ultima_sesion;
		}
		
		public Usuario(ResultSet rs) {
			try {
				if(rs.next()) {
					this.setNick(rs.getString("nick"));
					this.setNombre(rs.getString("nombre"));
					this.setApellidos(rs.getString("apellidos"));
					this.setDni(rs.getString("dni"));
					this.setEmail(rs.getString("email"));
					this.setAcceso(rs.getInt("acceso"));
					this.setFecha_registro(rs.getDate("fecha_Registro"));
					this.setFecha_ultima_sesion(rs.getDate("fecha_ultima_sesion"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getFecha_registro() {
			return fecha_registro;
		}

		public void setFecha_registro(Date fecha_registro) {
			this.fecha_registro = fecha_registro;
		}

		public Date getFecha_ultima_sesion() {
			return fecha_ultima_sesion;
		}

		public void setFecha_ultima_sesion(Date fecha_ultima_sesion) {
			this.fecha_ultima_sesion = fecha_ultima_sesion;
		}

		public int getAcceso() {
			return acceso;
		}

		public void setAcceso(int acceso) {
			this.acceso = acceso;
		}
		
		

}
