package clases;

import java.util.Date;

public class Usuario {

		private String nick, pass, nombre, apellidos, dni, email;
		private Date fecha_registro, fecha_ultima_sesion;
		private int pk_usuario, acceso;
		
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

		public int getPk_usuario() {
			return pk_usuario;
		}

		public void setPk_usuario(int pk_usuario) {
			this.pk_usuario = pk_usuario;
		}

		public int getAcceso() {
			return acceso;
		}

		public void setAcceso(int acceso) {
			this.acceso = acceso;
		}
		
		

}
