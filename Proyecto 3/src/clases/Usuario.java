package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Usuario {

		private String nick, pass, nombre, apellidos, dni, email, estado;
		private Date fecha_registro;
		private int acceso, pk_usuario;
		
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
		}
		
		public Usuario(ResultSet rs) {
			
					try {
						this.nick =(rs.getString("nick"));
						this.nombre = (rs.getString("nombre"));
						this.apellidos =(rs.getString("apellidos"));
						this.dni = (rs.getString("dni"));
						this.email =(rs.getString("email"));
						this.acceso =(rs.getInt("acceso"));
						this.fecha_registro = (rs.getDate("fecha_Registro"));
						this.pk_usuario = (rs.getInt("pk_usuario"));
						this.estado =(rs.getString("estado"));
					
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

		public int getAcceso() {
			return acceso;
		}

		public void setAcceso(int acceso) {
			this.acceso = acceso;
		}

		public int getPk_usuario() {
			return pk_usuario;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		
		
		

}
